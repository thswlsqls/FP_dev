package com.ebson.skillserver.v1.channels.FP.kakao.service;

import com.ebson.skillserver.common.*;
import com.ebson.skillserver.v1.channels.FP.entity.*;
import com.ebson.skillserver.v1.channels.FP.repository.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    SkillResV1TemplateComponentBtnExtraEntityRepository skillResV1TemplateComponentBtnExtraEntityRepository;

    @Autowired
    SkillResV1TemplateComponentBtnEntityRepository skillResV1TemplateComponentBtnEntityRepository;

    @Autowired
    SkillResV1TemplateQrplEntityRepository skillResV1TemplateQrplEntityRepository;

    private final ObjectMapper om = new ObjectMapper();

    @Transactional
    public SkillResponse setTemplateAndReturn(UUID templateId, BuilderV1BlockEntity be) {
        log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: templateId : {} blockId : {}", templateId, be.getBlockId());
        SkillResponse skillResponse = new SkillResponse();

        try {
            SkillResV1TemplateEntity skillResV1TemplateEntity = skillResV1TemplateEntityRepository.getReferenceById(templateId);

            List<SkillResV1TemplateOutputEntity> skillResV1TemplateOutputEntityList = skillResV1TemplateOutputEntityRepository.findBySkillResV1TemplateEntity_TemplateId(templateId);

            List<Map<String, Object>> outputs = new ArrayList<>();
            for (SkillResV1TemplateOutputEntity output : skillResV1TemplateOutputEntityList) {
                log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: outputId : {} outputName : {} outputOrd : {}", output.getOutputId(), output.getOutputName(), output.getOutputOrd());

                SkillResV1TemplateComponentEntity tce = skillResV1TemplateComponentEntityRepository.findBySkillResV1TemplateOutputEntity_OutputId(output.getOutputId());
                UUID componentId = tce.getComponentId();
                log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: componentId : {} componentName : {} componentType : {}", tce.getComponentId(), tce.getComponentName(), tce.getComponentType());

                List<SkillResV1TemplateComponentBtnEntity> btneList = skillResV1TemplateComponentBtnEntityRepository.findBySkillResV1TemplateComponentEntity_ComponentId(componentId);

                /** componentType 으로 분기처리해 outputs 리스트의 component 를 세팅 */
                Map<String, Object> component = switch (tce.getComponentType()) {
                    case ChatbotConstants.ComponentType.SIMPLE_TEXT -> {
                        SkillResV1TemplateSimpleTextEntity ste = skillResV1TemplateSimpleTextEntityRepository.getReferenceById(componentId);
                        log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: componentType : {}", ChatbotConstants.ComponentType.SIMPLE_TEXT);
                        yield getSimpleText(ste, be);
                    } case ChatbotConstants.ComponentType.SIMPLE_IMAGE -> {
                        SkillResV1TemplateSimpleImageEntity sie = skillResV1TemplateSimpleImageEntityRepository.getReferenceById(componentId);
                        log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: componentType : {}", ChatbotConstants.ComponentType.SIMPLE_IMAGE);
                        yield getSimpleImage(sie, be);
                    } case ChatbotConstants.ComponentType.TEXT_CARD -> {
                        SkillResV1TemplateTextCardEntity tcde = skillResV1TemplateTextCardEntityRepository.getReferenceById(componentId);
                        if (Objects.nonNull(tcde.getSkillResV1TemplateCarouselEntity())) {
                            yield null;
                        }
                        log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: componentType : {}", ChatbotConstants.ComponentType.TEXT_CARD);
                        yield getTextCard(tcde, be, btneList);
                    } case ChatbotConstants.ComponentType.BASIC_CARD -> {
                        SkillResV1TemplateBasicCardEntity bcde = skillResV1TemplateBasicCardEntityRepository.getReferenceById(componentId);
                        if (Objects.nonNull(bcde.getSkillResV1TemplateCarouselEntity())) {
                            yield null;
                        }
                        log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: componentType : {}", ChatbotConstants.ComponentType.BASIC_CARD);
                        yield getBasicCard(bcde, be, btneList);
                    } case ChatbotConstants.ComponentType.COMMERCE_CARD -> {
                        SkillResV1TemplateCommerceCardEntity ccde = skillResV1TemplateCommerceCardEntityRepository.getReferenceById(componentId);
                        if (Objects.nonNull(ccde.getSkillResV1TemplateCarouselEntity())) {
                            yield null;
                        }
                        log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: componentType : {}", ChatbotConstants.ComponentType.COMMERCE_CARD);
                        yield getCommerceCard(ccde, be, btneList);
                    } case ChatbotConstants.ComponentType.LIST_CARD -> {
                        SkillResV1TemplateListCardEntity lcde = skillResV1TemplateListCardEntityRepository.getReferenceById(componentId);
                        List<SkillResV1TemplateListCardListItemEntity> listItemeList = skillResV1TemplateListCardListItemEntityRepository.findBySkillResV1TemplateListCardEntity_ComponentId(componentId);
                        log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: listItemeList : {}", listItemeList);
                        if (Objects.nonNull(lcde.getSkillResV1TemplateCarouselEntity())) {
                            yield null;
                        }
                        log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: componentType : {}", ChatbotConstants.ComponentType.LIST_CARD);
                        yield getListCard(lcde, listItemeList, be, btneList);
                    } case ChatbotConstants.ComponentType.ITEM_CARD -> {
                        SkillResV1TemplateItemCardEntity itce = skillResV1TemplateItemCardEntityRepository.getReferenceById(componentId);
                        List<SkillResV1TemplateItemCardItemListEntity> itemListelist = skillResV1TemplateItemCardItemListEntityRepository.findBySkillResV1TemplateItemCardEntity_ComponentId(componentId);
                        log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: itemListelist : {}", itemListelist);
                        if (Objects.nonNull(itce.getSkillResV1TemplateCarouselEntity())) {
                            yield null;
                        }
                        log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: componentType : {}", ChatbotConstants.ComponentType.ITEM_CARD);
                        yield getItemCard(itce, itemListelist, be, btneList);
                    } case ChatbotConstants.ComponentType.CAROUSEL -> {
                        SkillResV1TemplateCarouselEntity tcse = skillResV1TemplateCarouselEntityRepository.findBySkillResV1TemplateComponentEntity_ComponentId(componentId);
                        log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: componentType : {}", ChatbotConstants.ComponentType.CAROUSEL);
                        UUID carouselId = tcse.getCarouselId();
                        String c_type = tcse.getCardType();
                        log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: carouselId : {} cardType : {}", carouselId, c_type);

                        List<Map<String, Object>> c_items = switch (c_type) {
                            case ChatbotConstants.ComponentType.TEXT_CARD -> {
                                List<SkillResV1TemplateTextCardEntity> tceList = skillResV1TemplateTextCardEntityRepository.findBySkillResV1TemplateCarouselEntity_CarouselId(carouselId);
                                List<Map<String, Object>> componentList = new ArrayList<>();
                                for ( SkillResV1TemplateTextCardEntity c_tcde : tceList ) {
                                    UUID c_componentId = c_tcde.getComponentId();
                                    log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: c_componentId : {}", c_componentId);
                                    List<SkillResV1TemplateComponentBtnEntity> c_btneList = skillResV1TemplateComponentBtnEntityRepository.findBySkillResV1TemplateComponentEntity_ComponentId(c_componentId);
                                    Map<String, Object> c_tcd = getCarouselTextCard(c_tcde, be, c_btneList);
                                    componentList.add(c_tcd);
                                }
                                yield componentList;
                            } case ChatbotConstants.ComponentType.BASIC_CARD -> {
                                List<SkillResV1TemplateBasicCardEntity> c_bcdeList = skillResV1TemplateBasicCardEntityRepository.findBySkillResV1TemplateCarouselEntity_CarouselId(carouselId);
                                List<Map<String, Object>> componentList = new ArrayList<>();
                                for ( SkillResV1TemplateBasicCardEntity c_bcde : c_bcdeList ) {
                                    UUID c_componentId = c_bcde.getComponentId();
                                    log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: c_componentId : {}", c_componentId);
                                    List<SkillResV1TemplateComponentBtnEntity> c_btneList = skillResV1TemplateComponentBtnEntityRepository.findBySkillResV1TemplateComponentEntity_ComponentId(c_componentId);
                                    Map<String, Object> c_bcd = getCarouselBasicCard(c_bcde, be, c_btneList);
                                    componentList.add(c_bcd);
                                }
                                yield componentList;
                            } case ChatbotConstants.ComponentType.COMMERCE_CARD -> {
                                List<SkillResV1TemplateCommerceCardEntity> c_ccdeList = skillResV1TemplateCommerceCardEntityRepository.findBySkillResV1TemplateCarouselEntity_CarouselId(carouselId);
                                List<Map<String, Object>> componentList = new ArrayList<>();
                                for ( SkillResV1TemplateCommerceCardEntity c_ccde : c_ccdeList ) {
                                    UUID c_componentId = c_ccde.getComponentId();
                                    log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: c_componentId : {}", c_componentId);
                                    List<SkillResV1TemplateComponentBtnEntity> c_btneList = skillResV1TemplateComponentBtnEntityRepository.findBySkillResV1TemplateComponentEntity_ComponentId(c_componentId);
                                    Map<String, Object> c_ccd = getCarouselCommerceCard(c_ccde, be, c_btneList);
                                    componentList.add(c_ccd);
                                }
                                yield componentList;
                            } case ChatbotConstants.ComponentType.LIST_CARD -> {
                                List<SkillResV1TemplateListCardEntity> c_lcdeList = skillResV1TemplateListCardEntityRepository.findBySkillResV1TemplateCarouselEntity_CarouselId(carouselId);
                                List<Map<String, Object>> componentList = new ArrayList<>();
                                for ( SkillResV1TemplateListCardEntity c_lcde : c_lcdeList ) {
                                    UUID c_componentId = c_lcde.getComponentId();
                                    log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: c_componentId : {}", c_componentId);
                                    List<SkillResV1TemplateListCardListItemEntity> c_listItemeList = skillResV1TemplateListCardListItemEntityRepository.findBySkillResV1TemplateListCardEntity_ComponentId(c_componentId);
                                    log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: c_listItemeList : {}", c_listItemeList);
                                    List<SkillResV1TemplateComponentBtnEntity> c_btneList = skillResV1TemplateComponentBtnEntityRepository.findBySkillResV1TemplateComponentEntity_ComponentId(c_componentId);
                                    Map<String, Object> c_lcd = getCarouselListCard(c_lcde, c_listItemeList, be, c_btneList);
                                    componentList.add(c_lcd);
                                }
                                yield componentList;
                            } case ChatbotConstants.ComponentType.ITEM_CARD -> {
                                List<SkillResV1TemplateItemCardEntity> c_icdeList = skillResV1TemplateItemCardEntityRepository.findBySkillResV1TemplateCarouselEntity_CarouselId(carouselId);
                                List<Map<String, Object>> componentList = new ArrayList<>();
                                for ( SkillResV1TemplateItemCardEntity c_icde : c_icdeList ) {
                                    UUID c_componentId = c_icde.getComponentId();
                                    log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: c_componentId : {}", c_componentId);
                                    List<SkillResV1TemplateItemCardItemListEntity> c_itemListelist = skillResV1TemplateItemCardItemListEntityRepository.findBySkillResV1TemplateItemCardEntity_ComponentId(c_componentId);
                                    log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: c_itemListelist : {}", c_itemListelist);
                                    List<SkillResV1TemplateComponentBtnEntity> c_btneList = skillResV1TemplateComponentBtnEntityRepository.findBySkillResV1TemplateComponentEntity_ComponentId(c_componentId);
                                    Map<String, Object> c_icd = getCarouselItemCard(c_icde, c_itemListelist, be, c_btneList);
                                    componentList.add(c_icd);
                                }
                                yield componentList;
                            }
                            default -> null;
                        };
                        yield getCarousel(c_type, c_items, tcse);
                    }
                    default -> null;
                };
                if (Objects.nonNull(component)) {
                    outputs.add(component);
                }
            }

            Template template = new Template();
            template.setOutputs(outputs);

            List<SkillResV1TemplateQrplEntity> qrpleList = skillResV1TemplateQrplEntityRepository.findBySkillResV1TemplateEntity_TemplateId(templateId);
            if (qrpleList.size() != 0) {
                List<Map<String, Object>> qrplList =  getQrplList(qrpleList);
                template.setQuickReplies(qrplList);
            }

            skillResponse.setTemplate(template);
            try {
                log.info("KakaoFPTemplateService^^setTemplateAndReturn() :: skillResponse : {}", om.writeValueAsString(skillResponse));
            } catch (JsonProcessingException e) {
                StackTraceElement[] ste = e.getStackTrace();
                String className = ste[0].getClassName();
                String metodName = ste[0].getMethodName();
                int lineNum = ste[0].getLineNumber();
                String fileNeme = ste[0].getFileName();
                log.error("Exception : {}, className : {} , methodName : {}, fileName : {}, lineNum : {}",
                        e.getMessage(), className, metodName, fileNeme, lineNum);
            }
            
        } catch (Exception e) {
            StackTraceElement[] ste = e.getStackTrace();
            String className = ste[0].getClassName();
            String metodName = ste[0].getMethodName();
            int lineNum = ste[0].getLineNumber();
            String fileNeme = ste[0].getFileName();
            log.error("Exception : {}, className : {} , methodName : {}, fileName : {}, lineNum : {}",
                    e.getMessage(), className, metodName, fileNeme, lineNum);
        }

        return skillResponse;
    }

    public Map<String, Object> getSimpleText(SkillResV1TemplateSimpleTextEntity ste, BuilderV1BlockEntity be){
        SimpleText st = new SimpleText();

        if (Objects.nonNull(ste)
            && StringUtils.hasText(ste.getText())) {
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
        try {
            log.info("KakaoFPTemplateService^^getSimpleText() :: output : {}", om.writeValueAsString(output));
        } catch (JsonProcessingException e){
            StackTraceElement[] stet = e.getStackTrace();
            String className = stet[0].getClassName();
            String metodName = stet[0].getMethodName();
            int lineNum = stet[0].getLineNumber();
            String fileNeme = stet[0].getFileName();
            log.error("Exception : {}, className : {} , methodName : {}, fileName : {}, lineNum : {}",
                    e.getMessage(), className, metodName, fileNeme, lineNum);
        }
        return output;
    }

    public Map<String, Object> getSimpleImage(SkillResV1TemplateSimpleImageEntity sie, BuilderV1BlockEntity be){
        SimpleImage si = new SimpleImage();

        if (Objects.nonNull(sie)){
            if (StringUtils.hasText(sie.getImgUrl())) {
                si.setImgUrl(sie.getImgUrl());
            }
            if (StringUtils.hasText(sie.getAltText())) {
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
        try {
            log.info("KakaoFPTemplateService^^getSimpleImage() :: output : {}", om.writeValueAsString(output));
        } catch (JsonProcessingException e){
            StackTraceElement[] stet = e.getStackTrace();
            String className = stet[0].getClassName();
            String metodName = stet[0].getMethodName();
            int lineNum = stet[0].getLineNumber();
            String fileNeme = stet[0].getFileName();
            log.error("Exception : {}, className : {} , methodName : {}, fileName : {}, lineNum : {}",
                    e.getMessage(), className, metodName, fileNeme, lineNum);
        }
        return output;
    }

    public Map<String, Object> getTextCard(SkillResV1TemplateTextCardEntity tcde, BuilderV1BlockEntity be, List<SkillResV1TemplateComponentBtnEntity> btneList){
        Map<String, Object> tcdMap = new HashMap<>();
        if (Objects.nonNull(tcde)) {
            if (StringUtils.hasText(tcde.getTitle())){
                tcdMap.put("title", tcde.getTitle());
            }
            if (StringUtils.hasText(tcde.getDesc())) {
                tcdMap.put("description", tcde.getDesc());
            }
        }

        tcdMap = switch (be.getBlockId()) {
            case "" -> {
                yield null;
            }
            default -> tcdMap;
        };

        if (btneList.size() != 0) {
            List<Map<String, Object>> btnList = getButtonList(btneList);
            tcdMap.put("buttons", btnList);
        }

        Map<String, Object> output = new HashMap<>(); // component
        output.put(ChatbotConstants.ComponentType.TEXT_CARD, tcdMap);
        try {
            log.info("KakaoFPTemplateService^^getTextCard() :: output : {}", om.writeValueAsString(output));
        } catch (JsonProcessingException e){
            StackTraceElement[] stet = e.getStackTrace();
            String className = stet[0].getClassName();
            String metodName = stet[0].getMethodName();
            int lineNum = stet[0].getLineNumber();
            String fileNeme = stet[0].getFileName();
            log.error("Exception : {}, className : {} , methodName : {}, fileName : {}, lineNum : {}",
                    e.getMessage(), className, metodName, fileNeme, lineNum);
        }
        return output;
    }

    public Map<String, Object> getCarouselTextCard(SkillResV1TemplateTextCardEntity tcde, BuilderV1BlockEntity be, List<SkillResV1TemplateComponentBtnEntity> btneList) {
        Map<String, Object> output = new HashMap<>(); // component
        if (Objects.nonNull(tcde)) {
            if (StringUtils.hasText(tcde.getTitle())){
                output.put("title", tcde.getTitle());
            } else { output.put("title", ""); }
            if (StringUtils.hasText(tcde.getDesc())) {
                output.put("description", tcde.getDesc());
            } else { output.put("description", ""); }
        }

        output = switch (be.getBlockId()) {
            case "" -> {
                yield null;
            }
            default -> output;
        };

        if (btneList.size() != 0) {
            List<Map<String, Object>> btnList = getButtonList(btneList);
            output.put("buttons", btnList);
        }
        try {
            log.info("KakaoFPTemplateService^^getCarouselTextCard() :: output : {}", om.writeValueAsString(output));
        } catch (JsonProcessingException e){
            StackTraceElement[] stet = e.getStackTrace();
            String className = stet[0].getClassName();
            String metodName = stet[0].getMethodName();
            int lineNum = stet[0].getLineNumber();
            String fileNeme = stet[0].getFileName();
            log.error("Exception : {}, className : {} , methodName : {}, fileName : {}, lineNum : {}",
                    e.getMessage(), className, metodName, fileNeme, lineNum);
        }
        return output;
    }

    public Map<String, Object> getBasicCard(SkillResV1TemplateBasicCardEntity bcde, BuilderV1BlockEntity be, List<SkillResV1TemplateComponentBtnEntity> btneList){
        BasicCard bcd = new BasicCard();
        Map<String, Object> bcdMap = new HashMap<>();

        if (Objects.nonNull(bcde)) {
            if (StringUtils.hasText(bcde.getTitle())) {
                bcdMap.put("title", bcde.getTitle());
            }
            if (StringUtils.hasText(bcde.getDesc())) {
                bcdMap.put("description", bcde.getDesc());
            }
            Map<String, Object> thumbnail = new HashMap<>();
            Map<String, Object> link = new HashMap<>();
            if (StringUtils.hasText(bcde.getThumbImgUrl())) {
                thumbnail.put("imageUrl", bcde.getThumbImgUrl());
            }
            if (StringUtils.hasText(bcde.getThumbFixedRatio())) {
                thumbnail.put("fixedRatio", Boolean.parseBoolean(bcde.getThumbFixedRatio()));
            }
            if (StringUtils.hasText(bcde.getThumbLinkWeb())) {
                link.put("web", bcde.getThumbLinkWeb());
            }
            if (StringUtils.hasText(bcde.getThumbLinkPc())){
                link.put("pc", bcde.getThumbLinkPc());
            }
            if (StringUtils.hasText(bcde.getThumbLinkMobile())) {
                link.put("mobile", bcde.getThumbLinkMobile());
            }
            if (Objects.nonNull(link.get("pc")) || Objects.nonNull(link.get("web")) || Objects.nonNull(link.get("mobile"))) {
                thumbnail.put("link", link);
            }
            bcdMap.put("thumbnail", thumbnail);
        }

        bcdMap = switch (be.getBlockId()) {
            case "" -> {
                yield null;
            }
            default -> bcdMap;
        };

        if (btneList.size() != 0) {
            List<Map<String, Object>> btnList = getButtonList(btneList);
            bcdMap.put("buttons", btnList);
        }

        Map<String, Object> output = new HashMap<>(); // component
        output.put(ChatbotConstants.ComponentType.BASIC_CARD, bcdMap);
        try {
            log.info("KakaoFPTemplateService^^getBasicCard() :: output : {}", om.writeValueAsString(output));
        } catch (JsonProcessingException e){
            StackTraceElement[] stet = e.getStackTrace();
            String className = stet[0].getClassName();
            String metodName = stet[0].getMethodName();
            int lineNum = stet[0].getLineNumber();
            String fileNeme = stet[0].getFileName();
            log.error("Exception : {}, className : {} , methodName : {}, fileName : {}, lineNum : {}",
                    e.getMessage(), className, metodName, fileNeme, lineNum);
        }
        return output;
    }

    public Map<String, Object> getCarouselBasicCard(SkillResV1TemplateBasicCardEntity bcde, BuilderV1BlockEntity be, List<SkillResV1TemplateComponentBtnEntity> btneList){
        Map<String, Object> output = new HashMap<>(); // component

        if (Objects.nonNull(bcde)) {
            if (StringUtils.hasText(bcde.getTitle())) {
                output.put("title", bcde.getTitle());
            }
            if (StringUtils.hasText(bcde.getDesc())) {
                output.put("description", bcde.getDesc());
            }

            Map<String, Object> thumbnail = new HashMap<>();
            Map<String, Object> link = new HashMap<>();
            if (StringUtils.hasText(bcde.getThumbImgUrl())) {
                thumbnail.put("imageUrl", bcde.getThumbImgUrl());
            }
            if (StringUtils.hasText(bcde.getThumbFixedRatio())) {
                thumbnail.put("fixedRatio", Boolean.parseBoolean(bcde.getThumbFixedRatio()));
            }
            if (StringUtils.hasText(bcde.getThumbLinkWeb())) {
                link.put("web", bcde.getThumbLinkWeb());
            }
            if (StringUtils.hasText(bcde.getThumbLinkPc())){
                link.put("pc", bcde.getThumbLinkPc());
            }
            if (StringUtils.hasText(bcde.getThumbLinkMobile())) {
                link.put("mobile", bcde.getThumbLinkMobile());
            }
            if (Objects.nonNull(link.get("pc")) || Objects.nonNull(link.get("web")) || Objects.nonNull(link.get("mobile"))) {
                thumbnail.put("link", link);
            }
            output.put("thumbnail", thumbnail);
        }

        output = switch (be.getBlockId()) {
            case "" -> {
                yield null;
            }
            default -> output;
        };

        if (btneList.size() != 0) {
            List<Map<String, Object>> btnList = getButtonList(btneList);
            output.put("buttons", btnList);
        }

        try {
            log.info("KakaoFPTemplateService^^getCarouselBasicCard() :: output : {}", om.writeValueAsString(output));
        } catch (JsonProcessingException e){
            StackTraceElement[] stet = e.getStackTrace();
            String className = stet[0].getClassName();
            String metodName = stet[0].getMethodName();
            int lineNum = stet[0].getLineNumber();
            String fileNeme = stet[0].getFileName();
            log.error("Exception : {}, className : {} , methodName : {}, fileName : {}, lineNum : {}",
                    e.getMessage(), className, metodName, fileNeme, lineNum);
        }
        return output;
    }

    public Map<String, Object> getCommerceCard(SkillResV1TemplateCommerceCardEntity ccde, BuilderV1BlockEntity be, List<SkillResV1TemplateComponentBtnEntity> btneList){
        Map<String, Object> ccdMap = new HashMap<>(); // component

        // 제목, 설명, 가격, 통화 설정
        if (StringUtils.hasText(ccde.getTitle())) {
            ccdMap.put("title", ccde.getTitle());
        }
        if (StringUtils.hasText(ccde.getDesc())) {
            ccdMap.put("description", ccde.getDesc());
        }
        if (StringUtils.hasText(ccde.getCurrency())) {
            ccdMap.put("currency", ccde.getCurrency());
        }

        if (ccde.getPrice() != null) {
            ccdMap.put("price", ccde.getPrice());
        } else {
            ccdMap.put("price", 0);
        }
        if (ccde.getDiscount() != null) {
            ccdMap.put("discount", ccde.getDiscount());
        } else {
            ccdMap.put("discount", 0);
        }
        if (ccde.getDiscountRate() != null) {
            ccdMap.put("discountRate", ccde.getDiscountRate());
        } else {
            ccdMap.put("discountRate", 0);
        }
        if (ccde.getDiscountedPrice() != null) {
            ccdMap.put("discountedPrice", ccde.getDiscountedPrice());
        } else {
            ccdMap.put("discountedPrice", 0);
        }

        Map<String, Object> thumbnail = new HashMap<>();
        Map<String , Object> link = new HashMap<>();
        if (StringUtils.hasText(ccde.getThumbImgUrl())) {
            thumbnail.put("imgUrl", ccde.getThumbImgUrl());
        }
        if (StringUtils.hasText(ccde.getThumbFixedRatio())) {
            thumbnail.put("fixedRatio", Boolean.parseBoolean(ccde.getThumbFixedRatio()));
        }
        if (StringUtils.hasText(ccde.getThumbLinkWeb())) {
            link.put("web", ccde.getThumbLinkWeb());
        }
        if (StringUtils.hasText(ccde.getThumbLinkPc())){
            link.put("pc", ccde.getThumbLinkPc());
        }
        if (StringUtils.hasText(ccde.getThumbLinkMobile())) {
            link.put("mobile", ccde.getThumbLinkMobile());
        }
        if (Objects.nonNull(link.get("web")) || Objects.nonNull(link.get("pc")) || Objects.nonNull(link.get("mobile"))) {
            thumbnail.put("link", link);
        }
        ccdMap.put("thumbnails", Collections.singletonList(thumbnail));

        Map<String, Object> profile = new HashMap<>();
        if (StringUtils.hasText(ccde.getProfileNickname())) {
            profile.put("nickname", ccde.getProfileNickname());
        }
        if (StringUtils.hasText(ccde.getProfileImgUrl())) {
            profile.put("imageUrl", ccde.getProfileImgUrl());
        }
        if (Objects.nonNull(profile.get("nickname")) || Objects.nonNull(profile.get("imageUrl"))) {
            ccdMap.put("profile", profile);
        }

        ccdMap = switch (be.getBlockId()) {
            case "" -> {
                yield null;
            }
            default -> ccdMap;
        };

        if (btneList.size() != 0) {
            List<Map<String, Object>> btnList = getButtonList(btneList);
            ccdMap.put("buttons", btnList);
        }

        Map<String, Object> output = new HashMap<>(); // component
        output.put(ChatbotConstants.ComponentType.COMMERCE_CARD, ccdMap);
        try {
            log.info("KakaoFPTemplateService^^getCommerceCard() :: output : {}", om.writeValueAsString(output));
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return output;
    }

    public Map<String, Object> getCarouselCommerceCard(SkillResV1TemplateCommerceCardEntity ccde, BuilderV1BlockEntity be, List<SkillResV1TemplateComponentBtnEntity> btneList){
        Map<String, Object> output = new HashMap<>(); // component

        // 제목, 설명, 가격, 통화 설정
        if (StringUtils.hasText(ccde.getTitle())) {
            output.put("title", ccde.getTitle());
        }
        if (StringUtils.hasText(ccde.getDesc())) {
            output.put("description", ccde.getDesc());
        }
        if (StringUtils.hasText(ccde.getCurrency())) {
            output.put("currency", ccde.getCurrency());
        }

        if (ccde.getPrice() != null) {
            output.put("price", ccde.getPrice());
        } else {
            output.put("price", 0);
        }
        if (ccde.getDiscount() != null) {
            output.put("discount", ccde.getDiscount());
        } else {
            output.put("discount", 0);
        }
        if (ccde.getDiscountRate() != null) {
            output.put("discountRate", ccde.getDiscountRate());
        } else {
            output.put("discountRate", 0);
        }
        if (ccde.getDiscountedPrice() != null) {
            output.put("discountedPrice", ccde.getDiscountedPrice());
        } else {
            output.put("discountedPrice", 0);
        }

        Map<String, Object> thumbnail = new HashMap<>();
        Map<String , Object> link = new HashMap<>();
        if (StringUtils.hasText(ccde.getThumbImgUrl())) {
            thumbnail.put("thumbImgUrl", ccde.getThumbImgUrl());
        }
        if (StringUtils.hasText(ccde.getThumbFixedRatio())) {
            thumbnail.put("thumbFixedRatio", Boolean.parseBoolean(ccde.getThumbFixedRatio()));
        }
        if (StringUtils.hasText(ccde.getThumbLinkWeb())) {
            link.put("web", ccde.getThumbLinkWeb());
        }
        if (StringUtils.hasText(ccde.getThumbLinkPc())){
            link.put("pc", ccde.getThumbLinkPc());
        }
        if (StringUtils.hasText(ccde.getThumbLinkMobile())) {
            link.put("mobile", ccde.getThumbLinkMobile());
        }
        if (Objects.nonNull(link.get("web")) || Objects.nonNull(link.get("pc")) || Objects.nonNull(link.get("mobile"))) {
            thumbnail.put("link", link);
        }
        output.put("thumbnails", Collections.singletonList(thumbnail));

        Map<String, Object> profile = new HashMap<>();
        if (StringUtils.hasText(ccde.getProfileNickname())) {
            profile.put("nickname", ccde.getProfileNickname());
        }
        if (StringUtils.hasText(ccde.getProfileImgUrl())) {
            profile.put("imageUrl", ccde.getProfileImgUrl());
        }
        if (Objects.nonNull(profile.get("nickname")) || Objects.nonNull(profile.get("imageUrl"))) {
            output.put("profile", profile);
        }

        output = switch (be.getBlockId()) {
            case "" -> {
                yield null;
            }
            default -> output;
        };

        if (btneList.size() != 0) {
            List<Map<String, Object>> btnList = getButtonList(btneList);
            output.put("buttons", btnList);
        }

        try {
            log.info("KakaoFPTemplateService^^getCarouselCommerceCard() :: output : {}", om.writeValueAsString(output));
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return output;
    }


    public Map<String, Object> getListCard(SkillResV1TemplateListCardEntity lcde, List<SkillResV1TemplateListCardListItemEntity> itemListelist, BuilderV1BlockEntity be, List<SkillResV1TemplateComponentBtnEntity> btneList){
        Map<String, Object> lcdMap = new HashMap<>(); // component
        List<Map<String, Object>> items = new ArrayList<>();
        for (SkillResV1TemplateListCardListItemEntity listItem : itemListelist) {
            Map<String, Object> item = new HashMap<>();

            if (StringUtils.hasText(listItem.getTitle())){
                item.put("title", listItem.getTitle());
            }
            if (StringUtils.hasText(listItem.getDesc())){
                item.put("description", listItem.getDesc());
            }
            if (StringUtils.hasText(listItem.getImgUrl())) {
                item.put("imageUrl", listItem.getImgUrl());
            }

            Map<String, Object> link = new HashMap<>();
            if (StringUtils.hasText(listItem.getLinkWeb())){
                link.put("web", listItem.getLinkWeb());
            }
            if (StringUtils.hasText(listItem.getLinkPc())){
                link.put("pc", listItem.getLinkPc());
            }
            if (StringUtils.hasText(listItem.getLinkMobile())){
                link.put("mobile", listItem.getLinkMobile());
            }
            if (Objects.nonNull(link.get("pc")) || Objects.nonNull(link.get("web")) || Objects.nonNull(link.get("mobile"))) {
                item.put("link", link);
            }
            if (StringUtils.hasText(listItem.getAction())) {
                item.put("action", listItem.getAction());
            }
            if (StringUtils.hasText(listItem.getBlockId())) {
                item.put("blockId", listItem.getAction());
            }
            if (StringUtils.hasText(listItem.getMessageText())) {
                item.put("messageText", listItem.getMessageText());
            }
            SkillResV1TemplateListCardListItemExtraEntity extrae = skillResV1TemplateListCardListItemExtraEntityRepository.findBySkillResV1TemplateListCardListItemEntity_ListItemId(listItem.getListItemId());
            if (Objects.nonNull(extrae)) {
                if (StringUtils.hasText(extrae.getKey())) {
                    if (StringUtils.hasText(extrae.getValue())) {
                        Map<String, Object> extra = new HashMap<>();
                        extra.put(extrae.getKey(), extrae.getValue());
                        item.put("extra", extra);
                    }
                }
            }
            if (StringUtils.hasText(listItem.getHeaderYn()) && listItem.getHeaderYn().equals("Y")) {
                lcdMap.put("header", item);
            } else {
                items.add(item);
            }
        }

        if (items.size() != 0){
            lcdMap.put("items", items);
        }

        lcdMap = switch (be.getBlockId()) {
            case "" -> {
                yield null;
            }
            default -> lcdMap;
        };

        if (btneList.size() != 0) {
            List<Map<String, Object>> btnList = getButtonList(btneList);
            lcdMap.put("buttons", btnList);
        }

        Map<String, Object> output = new HashMap<>(); // component
        output.put(ChatbotConstants.ComponentType.LIST_CARD, lcdMap);
        try {
            log.info("KakaoFPTemplateService^^getListCard() :: output : {}", om.writeValueAsString(output));
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return output;
    }

    public Map<String, Object> getCarouselListCard(SkillResV1TemplateListCardEntity lcde, List<SkillResV1TemplateListCardListItemEntity> itemListelist, BuilderV1BlockEntity be, List<SkillResV1TemplateComponentBtnEntity> btneList){

        Map<String, Object> output = new HashMap<>(); // component
        List<Map<String, Object>> items = new ArrayList<>();
        for (SkillResV1TemplateListCardListItemEntity listItem : itemListelist) {
            Map<String, Object> item = new HashMap<>();

            if (StringUtils.hasText(listItem.getTitle())){
                item.put("title", listItem.getTitle());
            }
            if (StringUtils.hasText(listItem.getDesc())){
                item.put("description", listItem.getDesc());
            }
            if (StringUtils.hasText(listItem.getImgUrl())) {
                item.put("imageUrl", listItem.getImgUrl());
            }

            Map<String, Object> link = new HashMap<>();
            if (StringUtils.hasText(listItem.getLinkWeb())){
                link.put("web", listItem.getLinkWeb());
            }
            if (StringUtils.hasText(listItem.getLinkPc())){
                link.put("pc", listItem.getLinkPc());
            }
            if (StringUtils.hasText(listItem.getLinkMobile())){
                link.put("mobile", listItem.getLinkMobile());
            }
            if (Objects.nonNull(link.get("pc")) || Objects.nonNull(link.get("web")) || Objects.nonNull(link.get("mobile"))) {
                item.put("link", link);
            }
            if (StringUtils.hasText(listItem.getAction())) {
                item.put("action", listItem.getAction());
            }
            if (StringUtils.hasText(listItem.getBlockId())) {
                item.put("blockId", listItem.getAction());
            }
            if (StringUtils.hasText(listItem.getMessageText())) {
                item.put("messageText", listItem.getMessageText());
            }
            SkillResV1TemplateListCardListItemExtraEntity extrae = skillResV1TemplateListCardListItemExtraEntityRepository.findBySkillResV1TemplateListCardListItemEntity_ListItemId(listItem.getListItemId());
            if (Objects.nonNull(extrae)) {
                if (StringUtils.hasText(extrae.getKey())) {
                    if (StringUtils.hasText(extrae.getValue())) {
                        Map<String, Object> extra = new HashMap<>();
                        extra.put(extrae.getKey(), extrae.getValue());
                        item.put("extra", extra);
                    }
                }
            }
            if (StringUtils.hasText(listItem.getHeaderYn()) && listItem.getHeaderYn().equals("Y")) {
                output.put("header", item);
            } else {
                items.add(item);
            }
        }

        if (items.size() != 0){
            output.put("items", items);
        }

        output = switch (be.getBlockId()) {
            case "" -> {
                yield null;
            }
            default -> output;
        };

        if (btneList.size() != 0) {
            List<Map<String, Object>> btnList = getButtonList(btneList);
            output.put("buttons", btnList);
        }

        try {
            log.info("KakaoFPTemplateService^^getCarouselListCard() :: output : {}", om.writeValueAsString(output));
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return output;
    }

    public Map<String, Object> getItemCard(SkillResV1TemplateItemCardEntity icde, List<SkillResV1TemplateItemCardItemListEntity> itemListelist, BuilderV1BlockEntity be, List<SkillResV1TemplateComponentBtnEntity> btneList){
        Map<String, Object> icdMap = new HashMap<>(); // component

        if (StringUtils.hasText(icde.getTitle())){
            icdMap.put("title", icde.getTitle());
        }
        if (StringUtils.hasText(icde.getDesc())){
            icdMap.put("description", icde.getDesc());
        }
        if (StringUtils.hasText(icde.getItemlistAlign())){
            icdMap.put("itemListAlignment", icde.getItemlistAlign());
        }
        if (StringUtils.hasText(icde.getBtnLayout())){
            icdMap.put("buttonLayout", icde.getBtnLayout());
        }
        // 버튼 설정 등 추가 필드 설정이 필요하면 여기에 추가

        // Thumbnail 설정
        if (StringUtils.hasText(icde.getThumbYn()) && "Y".equals(icde.getThumbYn())) {
            Map<String, Object> thumbnail = new HashMap<>();

            if (StringUtils.hasText(icde.getThumbImgUrl())){
                thumbnail.put("imageUrl", icde.getThumbImgUrl());
            }
            if (icde.getThumbWidth() != null) {
                thumbnail.put("width", icde.getThumbWidth());
            }
            if (icde.getThumbHeight() != null) {
                thumbnail.put("height", icde.getThumbHeight());
            }

            // Link 설정이 필요하면 여기에 추가
            icdMap.put("thumbnail", thumbnail);
        }

        // Head 또는 Profile 설정 (동시에 설정 불가)
        if (StringUtils.hasText(icde.getHeadYn()) && "Y".equals(icde.getHeadYn())) {
            Map<String, Object> head = new HashMap<>();

            if (StringUtils.hasText(icde.getHeadTitle())){
                head.put("title", icde.getHeadTitle());
            }

            icdMap.put("head", head);
        } else if (StringUtils.hasText(icde.getProfileYn()) && "Y".equals(icde.getProfileYn())) {
            Map<String, Object> profile = new HashMap<>();

            if (StringUtils.hasText(icde.getProfileImgUrl())) {
                profile.put("imageUrl", icde.getProfileImgUrl());
            }
            if (icde.getProfileWidth() != null) {
                profile.put("width", icde.getProfileWidth());
            }
            if (icde.getProfileHeight() != null) {
                profile.put("height", icde.getProfileHeight());
            }
            if (StringUtils.hasText(icde.getProfileTitle())) {
                profile.put("title", icde.getProfileTitle());
            }

            icdMap.put("profile", profile);
        }

        // ImageTitle 설정
        if (StringUtils.hasText(icde.getImgtitleYn()) && "Y".equals(icde.getImgtitleYn())) {
            Map<String, Object> imageTitle = new HashMap<>();

            if (StringUtils.hasText(icde.getImgtitleTitle())) {
                imageTitle.put("title", icde.getImgtitleTitle());
            }
            if (StringUtils.hasText(icde.getImgtitleDesc())) {
                imageTitle.put("description", icde.getImgtitleDesc());
            }
            if (StringUtils.hasText(icde.getImgtitleImgUrl())) {
                imageTitle.put("imageUrl", icde.getImgtitleImgUrl());
            }

            icdMap.put("imageTitle", imageTitle);
        }

        // ItemList 설정 (필수)
        // 여기에 list를 사용하여 ItemList 객체들을 생성하고 설정하는 로직 추가

        // ItemListSummary 설정
        if (StringUtils.hasText(icde.getItemlistSummaryYn()) && "Y".equals(icde.getItemlistSummaryYn())) {
            Map<String, Object> itemListSummary = new HashMap<>();

            if (StringUtils.hasText(icde.getItemlistSummaryTitle())) {
                itemListSummary.put("title", icde.getItemlistSummaryTitle());
            }
            if (StringUtils.hasText(icde.getItemlistSummaryDesc())) {
                itemListSummary.put("description", icde.getItemlistSummaryDesc());
            }
            icdMap.put("itemListSummary", itemListSummary);
        }

        List<ItemList> itemListArrayList = new ArrayList<>();
        for (SkillResV1TemplateItemCardItemListEntity itemCardItemList : itemListelist) {
            ItemList itemList = new ItemList();
            if (StringUtils.hasText(itemCardItemList.getTitle())){
                itemList.setTitle(itemCardItemList.getTitle());
            }
            if (StringUtils.hasText(itemCardItemList.getDesc())) {
                itemList.setDescription(itemCardItemList.getDesc());
            }
            itemListArrayList.add(itemList);
        }
        if (itemListArrayList.size() != 0){
            icdMap.put("itemList", itemListArrayList);
        }

        icdMap = switch (be.getBlockId()) {
            case "" -> {
                yield null;
            }
            default -> icdMap;
        };

        if (btneList.size() != 0) {
            List<Map<String, Object>> btnList = getButtonList(btneList);
            icdMap.put("buttons", btnList);
        }

        Map<String, Object> output = new HashMap<>(); // component
        output.put(ChatbotConstants.ComponentType.ITEM_CARD, icdMap);
        try {
            log.info("KakaoFPTemplateService^^getItemCard() :: output : {}", om.writeValueAsString(output));
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return output;
    }

    public Map<String, Object> getCarouselItemCard(SkillResV1TemplateItemCardEntity icde, List<SkillResV1TemplateItemCardItemListEntity> itemListelist, BuilderV1BlockEntity be, List<SkillResV1TemplateComponentBtnEntity> btneList){
        Map<String, Object> output = new HashMap<>(); // component

        if (StringUtils.hasText(icde.getTitle())){
            output.put("title", icde.getTitle());
        }
        if (StringUtils.hasText(icde.getDesc())){
            output.put("description", icde.getDesc());
        }
        if (StringUtils.hasText(icde.getItemlistAlign())){
            output.put("itemListAlignment", icde.getItemlistAlign());
        }
        if (StringUtils.hasText(icde.getBtnLayout())){
            output.put("buttonLayout", icde.getBtnLayout());
        }
        // 버튼 설정 등 추가 필드 설정이 필요하면 여기에 추가

        // Thumbnail 설정
        if (StringUtils.hasText(icde.getThumbYn()) && "Y".equals(icde.getThumbYn())) {
            Map<String, Object> thumbnail = new HashMap<>();

            if (StringUtils.hasText(icde.getThumbImgUrl())){
                thumbnail.put("imageUrl", icde.getThumbImgUrl());
            }
            if (icde.getThumbWidth() != null) {
                thumbnail.put("width", icde.getThumbWidth());
            }
            if (icde.getThumbHeight() != null) {
                thumbnail.put("height", icde.getThumbHeight());
            }

            // Link 설정이 필요하면 여기에 추가
            output.put("thumbnail", thumbnail);
        }

        // Head 또는 Profile 설정 (동시에 설정 불가)
        if (StringUtils.hasText(icde.getHeadYn()) && "Y".equals(icde.getHeadYn())) {
            Map<String, Object> head = new HashMap<>();

            if (StringUtils.hasText(icde.getHeadTitle())){
                head.put("title", icde.getHeadTitle());
            }

            output.put("head", head);
        } else if (StringUtils.hasText(icde.getProfileYn()) && "Y".equals(icde.getProfileYn())) {
            Map<String, Object> profile = new HashMap<>();

            if (StringUtils.hasText(icde.getProfileImgUrl())) {
                profile.put("imageUrl", icde.getProfileImgUrl());
            }
            if (icde.getProfileWidth() != null) {
                profile.put("width", icde.getProfileWidth());
            }
            if (icde.getProfileHeight() != null) {
                profile.put("height", icde.getProfileHeight());
            }
            if (StringUtils.hasText(icde.getProfileTitle())) {
                profile.put("title", icde.getProfileTitle());
            }

            output.put("profile", profile);
        }

        // ImageTitle 설정
        if (StringUtils.hasText(icde.getImgtitleYn()) && "Y".equals(icde.getImgtitleYn())) {
            Map<String, Object> imageTitle = new HashMap<>();

            if (StringUtils.hasText(icde.getImgtitleTitle())) {
                imageTitle.put("title", icde.getImgtitleTitle());
            }
            if (StringUtils.hasText(icde.getImgtitleDesc())) {
                imageTitle.put("description", icde.getImgtitleDesc());
            }
            if (StringUtils.hasText(icde.getImgtitleImgUrl())) {
                imageTitle.put("imageUrl", icde.getImgtitleImgUrl());
            }

            output.put("imageTitle", imageTitle);
        }

        // ItemList 설정 (필수)
        // 여기에 list를 사용하여 ItemList 객체들을 생성하고 설정하는 로직 추가

        // ItemListSummary 설정
        if (StringUtils.hasText(icde.getItemlistSummaryYn()) && "Y".equals(icde.getItemlistSummaryYn())) {
            Map<String, Object> itemListSummary = new HashMap<>();

            if (StringUtils.hasText(icde.getItemlistSummaryTitle())) {
                itemListSummary.put("title", icde.getItemlistSummaryTitle());
            }
            if (StringUtils.hasText(icde.getItemlistSummaryDesc())) {
                itemListSummary.put("description", icde.getItemlistSummaryDesc());
            }
            output.put("itemListSummary", itemListSummary);
        }

        List<ItemList> itemListArrayList = new ArrayList<>();
        for (SkillResV1TemplateItemCardItemListEntity itemCardItemList : itemListelist) {
            ItemList itemList = new ItemList();
            if (StringUtils.hasText(itemCardItemList.getTitle())){
                itemList.setTitle(itemCardItemList.getTitle());
            }
            if (StringUtils.hasText(itemCardItemList.getDesc())) {
                itemList.setDescription(itemCardItemList.getDesc());
            }
            itemListArrayList.add(itemList);
        }
        if (itemListArrayList.size() != 0){
            output.put("itemList", itemListArrayList);
        }

        output = switch (be.getBlockId()) {
            case "" -> {
                yield null;
            }
            default -> output;
        };

        if (btneList.size() != 0) {
            List<Map<String, Object>> btnList = getButtonList(btneList);
            // icd.setButtons(btnList);
        }

        try {
            log.info("KakaoFPTemplateService^^getCarouselItemCard() :: output : {}", om.writeValueAsString(output));
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return output;
    }

    public Map<String, Object> getCarousel(String type, List<Map<String, Object>> items, SkillResV1TemplateCarouselEntity crse) {
        Carousel carousel = new Carousel();
        carousel.setType(type);
        carousel.setItems(items);
        Carousel.CarouselHeader carouselHeader = new Carousel.CarouselHeader();

        if (StringUtils.hasText(crse.getHeaderTitle())) {
            carouselHeader.setTitle(crse.getHeaderTitle());
            if (StringUtils.hasText(crse.getHeaderDesc())) {
                carouselHeader.setDescription(crse.getHeaderDesc());
                if (StringUtils.hasText(crse.getHeaderThumb())) {
                    Thumbnail thumbnail = new Thumbnail();
                    thumbnail.setImageUrl(crse.getHeaderThumb());
                    carousel.setHeader(carouselHeader);
                }
            }
        }

        Map<String, Object> output = new HashMap<>(); // component
        output.put(ChatbotConstants.ComponentType.CAROUSEL, carousel);
        try {
            log.info("KakaoFPTemplateService^^getCarousel() :: output : {}", om.writeValueAsString(output));
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return output;
    }

    public List<Map<String, Object>> getButtonList(List<SkillResV1TemplateComponentBtnEntity> btnEntityList) {
        List<Map<String, Object>> btnMapList = new ArrayList<>();

        for (SkillResV1TemplateComponentBtnEntity btnEntity : btnEntityList) {
            Map<String, Object> btnMap = new HashMap<>();
            if (StringUtils.hasText(btnEntity.getLabel())) {
                btnMap.put("label", btnEntity.getLabel());
            }
            if (StringUtils.hasText(btnEntity.getAction())) {
                btnMap.put("action", btnEntity.getAction());
            }
            if (StringUtils.hasText(btnEntity.getWebLinkUrl())) {
                btnMap.put("webLinkUrl", btnEntity.getWebLinkUrl());
            }
            if (StringUtils.hasText(btnEntity.getMessageText())) {
                btnMap.put("messageText", btnEntity.getMessageText());
            }
            if (StringUtils.hasText(btnEntity.getPhone())) {
                btnMap.put("phoneNumber", btnEntity.getPhone());
            }
            if (StringUtils.hasText(btnEntity.getBlockId())) {
                btnMap.put("blockId", btnEntity.getBlockId());
            }
            UUID btneId = btnEntity.getBtnId();
            SkillResV1TemplateComponentBtnExtraEntity btnExtrae = skillResV1TemplateComponentBtnExtraEntityRepository.findBySkillResV1TemplateComponentBtnEntity_BtnId(btneId);
            if (Objects.nonNull(btnExtrae)) {
                Map<String, Object> extra = new HashMap<>();
                if (StringUtils.hasText(btnExtrae.getKey())){
                    if(StringUtils.hasText(btnExtrae.getValue())){
                        extra.put(btnExtrae.getKey(), btnExtrae.getValue());
                        btnMap.put("extra", extra);
                    }
                }
            }
            btnMapList.add(btnMap);
        }
        try {
            log.info("KakaoFPTemplateService^^getButtonList() :: btnList : {}", om.writeValueAsString(btnMapList));
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return btnMapList;
    }

    public List<Map<String, Object>> getQrplList(List<SkillResV1TemplateQrplEntity> qrpleList) {
        List<Map<String, Object>> qrplList = new ArrayList<>();
        for (SkillResV1TemplateQrplEntity qrple : qrpleList) {
            Map<String, Object> qrplMap = new HashMap<>();

            if (StringUtils.hasText(qrple.getLabel())) {
                qrplMap.put("label", qrple.getLabel());
            }
            if (StringUtils.hasText(qrple.getAction())) {
                qrplMap.put("action", qrple.getAction());
            }
            if (StringUtils.hasText(qrple.getMessageText())) {
                qrplMap.put("messagText", qrple.getMessageText());
            }
            qrplList.add(qrplMap);
        }
        try {
            log.info("KakaoFPTemplateService^^getQrplList() :: qrplList : {}", om.writeValueAsString(qrplList));
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return qrplList;
    }

}
