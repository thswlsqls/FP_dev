package com.ebson.skillserver.v1.channels.FP.kakao.service;

import com.ebson.skillserver.common.*;
import com.ebson.skillserver.v1.channels.FP.entity.*;
import com.ebson.skillserver.v1.channels.FP.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class KakaoFPTemplateService {
    private static final Logger log = LoggerFactory.getLogger(KakaoFPTemplateService.class);

    @Autowired
    SkillResV1TemplateEntityRepository skillResV1TemplateEntityRepository;

    @Autowired
    SkillResV1TemplateOutputEntityRepository skillResV1TemplateOutputEntityRepository;

    @Autowired
    SkillResV1TemplateComponentEntityRepository skillResV1TemplateComponentEntityRepository;

    @Autowired
    SkillResV1TemplateSimpleTextEntityRepository skillResV1TemplateSimpleTextEntityRepository;

    @Autowired
    SkillResV1TemplateSimpleImageEntityRepository skillResV1TemplateSimpleImageEntityRepository;

    @Autowired
    SkillResV1TemplateTextCardEntityRepository skillResV1TemplateTextCardEntityRepository;

    @Autowired
    SkillResV1TemplateBasicCardEntityRepository skillResV1TemplateBasicCardEntityRepository;

    @Autowired
    SkillResV1TemplateCommerceCardEntityRepository skillResV1TemplateCommerceCardEntityRepository;

    @Autowired
    SkillResV1TemplateItemCardEntityRepository skillResV1TemplateItemCardEntityRepository;

    @Autowired
    SkillResV1TemplateItemCardItemListEntityRepository skillResV1TemplateItemCardItemListEntityRepository;

    @Autowired
    SkillResV1TemplateListCardEntityRepository skillResV1TemplateListCardEntityRepository;

    @Autowired
    SkillResV1TemplateCarouselEntityRepository skillResV1TemplateCarouselEntityRepository;

    @Autowired
    SkillResV1TemplateListCardListItemEntityRepository skillResV1TemplateListCardListItemEntityRepository;

    @Autowired
    SkillResV1TemplateListCardListItemExtraEntityRepository skillResV1TemplateListCardListItemExtraEntityRepository;


    public SkillResponse setTemplateAndReturn(SkillResponse skillResponse, UUID templateId, BuilderV1BlockEntity be) {

        SkillResV1TemplateEntity skillResV1TemplateEntity = skillResV1TemplateEntityRepository.getReferenceById(templateId);

        List<SkillResV1TemplateOutputEntity> skillResV1TemplateOutputEntityList = skillResV1TemplateOutputEntityRepository.findBySkillResV1TemplateEntity_TemplateId(templateId);

        List<Map<String, Object>> outputs = new ArrayList<>();
        for (SkillResV1TemplateOutputEntity output : skillResV1TemplateOutputEntityList) {
            SkillResV1TemplateComponentEntity tce = skillResV1TemplateComponentEntityRepository.findBySkillResV1TemplateOutputEntity_OutputId(output.getOutputId());
            UUID componentId = tce.getComponentId();

            /** componentType 으로 분기처리해 outputs 리스트의 component 를 세팅 */
            Map<String, Object> component = switch (tce.getComponentType()) {
                case ChatbotConstants.ComponentType.SIMPLE_TEXT -> {
                    SkillResV1TemplateSimpleTextEntity ste = skillResV1TemplateSimpleTextEntityRepository.getReferenceById(componentId);

                    yield getSimpleText(ste, be);
                } case ChatbotConstants.ComponentType.SIMPLE_IMAGE -> {
                    SkillResV1TemplateSimpleImageEntity sie = skillResV1TemplateSimpleImageEntityRepository.getReferenceById(componentId);

                    yield getSimpleImage(sie, be);
                } case ChatbotConstants.ComponentType.TEXT_CARD -> {
                    SkillResV1TemplateTextCardEntity tcde = skillResV1TemplateTextCardEntityRepository.getReferenceById(componentId);

                    yield getTextCard(tcde, be);
                } case ChatbotConstants.ComponentType.BASIC_CARD -> {
                    SkillResV1TemplateBasicCardEntity bcde = skillResV1TemplateBasicCardEntityRepository.getReferenceById(componentId);

                    yield getBasicCard(bcde, be);
                } case ChatbotConstants.ComponentType.COMMERCE_CARD -> {
                    SkillResV1TemplateCommerceCardEntity skillResV1TemplateCommerceCardEntity = skillResV1TemplateCommerceCardEntityRepository.getReferenceById(componentId);

                    yield getCommerceCard(skillResV1TemplateCommerceCardEntity);
                } case ChatbotConstants.ComponentType.ITEM_CARD -> {
                    SkillResV1TemplateItemCardEntity skillResV1TemplateItemCardEntity = skillResV1TemplateItemCardEntityRepository.getReferenceById(componentId);
                    List<SkillResV1TemplateItemCardItemListEntity> skillResV1TemplateItemCardItemListEntityList = skillResV1TemplateItemCardItemListEntityRepository.findBySkillResV1TemplateItemCardEntity_ComponentId(componentId);

                    yield getItemCard(skillResV1TemplateItemCardEntity, skillResV1TemplateItemCardItemListEntityList);
                } case ChatbotConstants.ComponentType.LIST_CARD -> {
                    SkillResV1TemplateListCardEntity skillResV1TemplateListCardEntity = skillResV1TemplateListCardEntityRepository.getReferenceById(componentId);
                    List<SkillResV1TemplateListCardListItemEntity> skillResV1TemplateListCardListItemEntityList = skillResV1TemplateListCardListItemEntityRepository.findBySkillResV1TemplateListCardEntity_ComponentId(componentId);

                    yield getListCard(skillResV1TemplateListCardEntity, skillResV1TemplateListCardListItemEntityList);
                } case ChatbotConstants.ComponentType.CAROUSEL -> {
                    SkillResV1TemplateCarouselEntity skillResV1TemplateCarouselEntity = skillResV1TemplateCarouselEntityRepository.getReferenceById(componentId);

                    yield null;
                }
                default -> null; 
            };
            outputs.add(component);
        }

        Template template = new Template();
        template.setOutputs(outputs);
        skillResponse.setTemplate(template);
        return skillResponse;
    }

    public Map<String, Object> getSimpleText(SkillResV1TemplateSimpleTextEntity ste, BuilderV1BlockEntity be){
        SimpleText st = new SimpleText();

        if (Objects.nonNull(ste)
            && StringUtils.hasText(ste.getText())
            && StringUtils.hasLength(ste.getText())) {
            st.setText(ste.getText());
        }

        st = switch (be.getBlockId()) {
            case "" -> {
                yield null;
            }
            default -> st;
        };

        Map<String, Object> output = new HashMap<>(); // component
        output.put(ChatbotConstants.ComponentType.SIMPLE_TEXT, st);
        return output;
    }

    public Map<String, Object> getSimpleImage(SkillResV1TemplateSimpleImageEntity sie, BuilderV1BlockEntity be){
        SimpleImage si = new SimpleImage();

        if (Objects.nonNull(sie)){
            if (StringUtils.hasText(sie.getImgUrl()) && StringUtils.hasLength(sie.getImgUrl())) {
                si.setImgUrl(sie.getImgUrl());
            } if (StringUtils.hasText(sie.getAltText()) && StringUtils.hasLength(sie.getAltText())) {
                si.setAltText(sie.getAltText());
            }
        }

        si = switch (be.getBlockId()) {
            case "" -> {
                yield null;
            }
            default -> si;
        };

        Map<String, Object> output = new HashMap<>(); // component
        output.put(ChatbotConstants.ComponentType.SIMPLE_IMAGE, si);
        return output;
    }

    public Map<String, Object> getTextCard(SkillResV1TemplateTextCardEntity tcde, BuilderV1BlockEntity be){
        TextCard tcd = new TextCard();

        if (Objects.nonNull(tcde)) {
            if (StringUtils.hasText(tcde.getTitle()) && StringUtils.hasLength(tcde.getDesc())){
                tcd.setTitle(tcde.getTitle());
            } if (StringUtils.hasText(tcde.getDataType()) && StringUtils.hasLength(tcde.getDesc())) {
                tcd.setDescription(tcde.getDesc());
            }
        }

        tcd = switch (be.getBlockId()) {
            case "" -> {
                yield null;
            }
            default -> tcd;
        };

        Map<String, Object> output = new HashMap<>(); // component
        output.put(ChatbotConstants.ComponentType.TEXT_CARD, tcd);
        return output;
    }

    public Map<String, Object> getBasicCard(SkillResV1TemplateBasicCardEntity bcde, BuilderV1BlockEntity be){

        return null;
    }

    public Map<String, Object> getCommerceCard(SkillResV1TemplateCommerceCardEntity skillResV1TemplateCommerceCardEntity){

        return null;
    }

    public Map<String, Object> getItemCard(SkillResV1TemplateItemCardEntity skillResV1TemplateItemCardEntity, List<SkillResV1TemplateItemCardItemListEntity> skillResV1TemplateItemCardItemListEntityList){

        return null;
    }

    public Map<String, Object> getListCard(SkillResV1TemplateListCardEntity skillResV1TemplateListCardEntity, List<SkillResV1TemplateListCardListItemEntity> skillResV1TemplateListCardListItemEntityList){

        return null;
    }

}
