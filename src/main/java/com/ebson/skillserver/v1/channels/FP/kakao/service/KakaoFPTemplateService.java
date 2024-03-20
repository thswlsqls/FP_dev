package com.ebson.skillserver.v1.channels.FP.kakao.service;

import com.ebson.skillserver.common.ChatbotConstants;
import com.ebson.skillserver.common.SkillResponse;
import com.ebson.skillserver.v1.channels.FP.entity.*;
import com.ebson.skillserver.v1.channels.FP.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    SkillResV1TemplateListCardEntityRepository skillResV1TemplateListCardEntityRepository;

    @Autowired
    SkillResV1TemplateCarouselEntityRepository skillResV1TemplateCarouselEntityRepository;

    public SkillResponse setTemplateAndReturn(SkillResponse skillResponse, UUID templateId, BuilderV1BlockEntity builderV1BlockEntity) {

        SkillResV1TemplateEntity skillResV1TemplateEntity = skillResV1TemplateEntityRepository.getReferenceById(templateId);

        List<SkillResV1TemplateOutputEntity> skillResV1TemplateOutputEntityList = skillResV1TemplateOutputEntityRepository.findBySkillResV1TemplateEntity_TemplateId(templateId);

        for (SkillResV1TemplateOutputEntity output : skillResV1TemplateOutputEntityList) {
            SkillResV1TemplateComponentEntity skillResV1TemplateComponentEntity = skillResV1TemplateComponentEntityRepository.findBySkillResV1TemplateOutputEntity_OutputId(output.getOutputId());
            UUID componentId = skillResV1TemplateComponentEntity.getComponentId();

            /** componentType 으로 분기처리해 outputs 리스트의 component 를 세팅 */
            Map<String, Object> component = switch (skillResV1TemplateComponentEntity.getComponentType()) {
                case ChatbotConstants.ComponentType.SIMPLE_TEXT -> {
                    SkillResV1TemplateSimpleTextEntity skillResV1TemplateSimpleTextEntity = skillResV1TemplateSimpleTextEntityRepository.getReferenceById(componentId);

                    yield null;
                } case ChatbotConstants.ComponentType.SIMPLE_IMAGE -> {
                    SkillResV1TemplateSimpleImageEntity skillResV1TemplateSimpleImageEntity = skillResV1TemplateSimpleImageEntityRepository.getReferenceById(componentId);

                    yield null;
                } case ChatbotConstants.ComponentType.TEXT_CARD -> {
                    SkillResV1TemplateTextCardEntity skillResV1TemplateTextCardEntity = skillResV1TemplateTextCardEntityRepository.getReferenceById(componentId);

                    yield null;
                } case ChatbotConstants.ComponentType.BASIC_CARD -> {
                    SkillResV1TemplateBasicCardEntity skillResV1TemplateBasicCardEntity = skillResV1TemplateBasicCardEntityRepository.getReferenceById(componentId);

                    yield null;
                } case ChatbotConstants.ComponentType.COMMERCE_CARD -> {
                    SkillResV1TemplateCommerceCardEntity skillResV1TemplateCommerceCardEntity = skillResV1TemplateCommerceCardEntityRepository.getReferenceById(componentId);

                    yield null;
                } case ChatbotConstants.ComponentType.ITEM_CARD -> {
                    SkillResV1TemplateItemCardEntity skillResV1TemplateItemCardEntity = skillResV1TemplateItemCardEntityRepository.getReferenceById(componentId);

                    yield null;
                } case ChatbotConstants.ComponentType.LIST_CARD -> {
                    SkillResV1TemplateListCardEntity skillResV1TemplateListCardEntity = skillResV1TemplateListCardEntityRepository.getReferenceById(componentId);

                    yield null;
                } case ChatbotConstants.ComponentType.CAROUSEL -> {
                    SkillResV1TemplateCarouselEntity skillResV1TemplateCarouselEntity = skillResV1TemplateCarouselEntityRepository.getReferenceById(componentId);

                    yield null;
                }
                default -> null; 
            };
        }

        return null;
    }

    /** componentType 으로 분기 처리한 블럭 마다 호출할 메서드 정의 - 메서드 내에서는 블록 코드별로 커스텀 할 수 있도록 함 */
    public Map<String, Object> setSkillResV1TemplateSimpleText(SkillResV1TemplateSimpleTextEntity skillResV1TemplateSimpleTextEntity){

        return null;
    }
}
