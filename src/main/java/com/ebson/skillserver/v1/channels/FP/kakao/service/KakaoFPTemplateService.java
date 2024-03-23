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

    @Autowired
    SkillResV1TemplateComponentBtnExtraEntityRepository skillResV1TemplateComponentBtnExtraEntityRepository;

    @Autowired
    SkillResV1TemplateComponentBtnEntityRepository skillResV1TemplateComponentBtnEntityRepository;

    public SkillResponse setTemplateAndReturn(SkillResponse skillResponse, UUID templateId, BuilderV1BlockEntity be) {

        SkillResV1TemplateEntity skillResV1TemplateEntity = skillResV1TemplateEntityRepository.getReferenceById(templateId);

        List<SkillResV1TemplateOutputEntity> skillResV1TemplateOutputEntityList = skillResV1TemplateOutputEntityRepository.findBySkillResV1TemplateEntity_TemplateId(templateId);

        List<Map<String, Object>> outputs = new ArrayList<>();
        for (SkillResV1TemplateOutputEntity output : skillResV1TemplateOutputEntityList) {
            SkillResV1TemplateComponentEntity tce = skillResV1TemplateComponentEntityRepository.findBySkillResV1TemplateOutputEntity_OutputId(output.getOutputId());
            UUID componentId = tce.getComponentId();
            List<SkillResV1TemplateComponentBtnEntity> btneList = skillResV1TemplateComponentBtnEntityRepository.findBySkillResV1TemplateComponentEntity_ComponentId(componentId);

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

                    yield getTextCard(tcde, be, btneList);
                } case ChatbotConstants.ComponentType.BASIC_CARD -> {
                    SkillResV1TemplateBasicCardEntity bcde = skillResV1TemplateBasicCardEntityRepository.getReferenceById(componentId);

                    yield getBasicCard(bcde, be, btneList);
                } case ChatbotConstants.ComponentType.COMMERCE_CARD -> {
                    SkillResV1TemplateCommerceCardEntity ccde = skillResV1TemplateCommerceCardEntityRepository.getReferenceById(componentId);

                    yield getCommerceCard(ccde, be, btneList);
                } case ChatbotConstants.ComponentType.ITEM_CARD -> {
                    SkillResV1TemplateItemCardEntity itce = skillResV1TemplateItemCardEntityRepository.getReferenceById(componentId);
                    List<SkillResV1TemplateItemCardItemListEntity> itemListelist = skillResV1TemplateItemCardItemListEntityRepository.findBySkillResV1TemplateItemCardEntity_ComponentId(componentId);

                    yield getItemCard(itce, itemListelist, be, btneList);
                } case ChatbotConstants.ComponentType.LIST_CARD -> {
                    SkillResV1TemplateListCardEntity lcde = skillResV1TemplateListCardEntityRepository.getReferenceById(componentId);
                    List<SkillResV1TemplateListCardListItemEntity> listItemeList = skillResV1TemplateListCardListItemEntityRepository.findBySkillResV1TemplateListCardEntity_ComponentId(componentId);

                    yield getListCard(lcde, listItemeList, be, btneList);
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
        return output;
    }

    public Map<String, Object> getTextCard(SkillResV1TemplateTextCardEntity tcde, BuilderV1BlockEntity be, List<SkillResV1TemplateComponentBtnEntity> btneList){
        TextCard tcd = new TextCard();

        if (Objects.nonNull(tcde)) {
            if (StringUtils.hasText(tcde.getTitle())){
                tcd.setTitle(tcde.getTitle());
            }
            if (StringUtils.hasText(tcde.getDataType())) {
                tcd.setDescription(tcde.getDesc());
            }
        }

        tcd = switch (be.getBlockId()) {
            case "" -> {
                yield null;
            }
            default -> tcd;
        };

        if (btneList.size() != 0) {
            List<Button> btnList = getButtonList(btneList);
            tcd.setButtons(btnList);
        }

        Map<String, Object> output = new HashMap<>(); // component
        output.put(ChatbotConstants.ComponentType.TEXT_CARD, tcd);
        return output;
    }

    public Map<String, Object> getBasicCard(SkillResV1TemplateBasicCardEntity bcde, BuilderV1BlockEntity be, List<SkillResV1TemplateComponentBtnEntity> btneList){
        BasicCard bcd = new BasicCard();

        if (Objects.nonNull(bcd)) {
            if (StringUtils.hasText(bcde.getTitle())) {
                bcd.setTitle(bcde.getTitle());
            }
            if (StringUtils.hasText(bcde.getDesc())) {
                bcd.setDescription(bcde.getDesc());
            }
            if (StringUtils.hasText(bcde.getThumb())) {
                Thumbnail thumbnail = new Thumbnail();
                thumbnail.setImageUrl(bcde.getThumb());
                bcd.setThumbnail(thumbnail);
            }
        }

        bcd = switch (be.getBlockId()) {
            case "" -> {
                yield null;
            }
            default -> bcd;
        };

        if (btneList.size() != 0) {
            List<Button> btnList = getButtonList(btneList);
            bcd.setButtons(btnList);
        }

        Map<String, Object> output = new HashMap<>(); // component
        output.put(ChatbotConstants.ComponentType.BASIC_CARD, bcd);
        return output;
    }

    public Map<String, Object> getCommerceCard(SkillResV1TemplateCommerceCardEntity ccde, BuilderV1BlockEntity be, List<SkillResV1TemplateComponentBtnEntity> btneList){
        CommerceCard ccd = new CommerceCard();

        // 제목, 설명, 가격, 통화 설정
        if (StringUtils.hasText(ccde.getTitle())) {
            ccd.setTitle(ccde.getTitle());
        }
        if (StringUtils.hasText(ccde.getDesc())) {
            ccd.setDescription(ccde.getDesc());
        }
        if (StringUtils.hasText(ccde.getCurrency())) {
            ccd.setCurrency(ccde.getCurrency());
        }

        if (ccde.getPrice() != null) {
            ccd.setPrice(ccde.getPrice());
        } else {
            ccd.setPrice(0);
        }
        if (ccde.getDiscount() != null) {
            ccd.setDiscount(ccde.getDiscount());
        } else {
            ccd.setDiscount(0);
        }
        if (ccde.getDiscountRate() != null) {
            ccd.setDiscountRate(ccde.getDiscountRate());
        } else {
            ccd.setDiscountRate(0);
        }
        if (ccde.getDiscountedPrice() != null) {
            ccd.setDiscountedPrice(ccde.getDiscountedPrice());
        } else {
            ccd.setDiscountedPrice(0);
        }

        Thumbnail thumbnail = new Thumbnail();
        Link link = new Link();
        if (StringUtils.hasText(ccde.getThumbImgUrl())) {
            thumbnail.setImageUrl(ccde.getThumbImgUrl());
        }
        if (StringUtils.hasText(ccde.getThumbFixedRatio())) {
            thumbnail.setFixedRatio(Boolean.parseBoolean(ccde.getThumbFixedRatio()));
        }
        if (StringUtils.hasText(ccde.getThumbLinkWeb())) {
            link.setWeb(ccde.getThumbLinkWeb());
        }
        if (StringUtils.hasText(ccde.getThumbLinkPc())){
            link.setPc(ccde.getThumbLinkPc());
        }
        if (StringUtils.hasText(ccde.getThumbLinkMobile())) {
            link.setMobile(ccde.getThumbLinkMobile());
        }
        thumbnail.setLink(link);
        ccd.setThumbnails(Collections.singletonList(thumbnail));

        Profile profile = new Profile();
        if (StringUtils.hasText(ccde.getProfileNickname())) {
            profile.setNickname(ccde.getProfileNickname());
        }
        if (StringUtils.hasText(ccde.getProfileImgUrl())) {
            profile.setImageUrl(ccde.getProfileImgUrl());
        }
        ccd.setProfile(profile);

        ccd = switch (be.getBlockId()) {
            case "" -> {
                yield null;
            }
            default -> ccd;
        };

        if (btneList.size() != 0) {
            List<Button> btnList = getButtonList(btneList);
            ccd.setButtons(btnList);
        }

        Map<String, Object> output = new HashMap<>(); // component
        output.put(ChatbotConstants.ComponentType.COMMERCE_CARD, ccd);
        return output;
    }

    public Map<String, Object> getItemCard(SkillResV1TemplateItemCardEntity icde, List<SkillResV1TemplateItemCardItemListEntity> itemListelist, BuilderV1BlockEntity be, List<SkillResV1TemplateComponentBtnEntity> btneList){
        ItemCard icd = new ItemCard();

        if (StringUtils.hasText(icde.getTitle())){
            icd.setTitle(icde.getTitle());
        }
        if (StringUtils.hasText(icde.getDesc())){
            icd.setDescription(icde.getDesc());
        }
        if (StringUtils.hasText(icde.getItemlistAlign())){
            icd.setItemListAlignment(icde.getItemlistAlign());
        }
        if (StringUtils.hasText(icde.getBtnLayout())){
            icd.setButtonLayout(icde.getBtnLayout());
        }
        // 버튼 설정 등 추가 필드 설정이 필요하면 여기에 추가

        // Thumbnail 설정
        if ("Y".equals(icde.getThumbYn())) {
            ItemCard.Thumbnail thumbnail = new ItemCard.Thumbnail();
            if (StringUtils.hasText(icde.getThumbImgUrl())){
                thumbnail.setImageUrl(icde.getThumbImgUrl());
            }
            if (icde.getThumbWidth() != null) {
                thumbnail.setWidth(icde.getThumbWidth());
            }
            if (icde.getThumbHeight() != null) {
                thumbnail.setHeight(icde.getThumbHeight());
            }
            // Link 설정이 필요하면 여기에 추가
            icd.setThumbnail(thumbnail);
        }

        // Head 또는 Profile 설정 (동시에 설정 불가)
        if ("Y".equals(icde.getHeadYn())) {
            ItemCard.Head head = new ItemCard.Head();
            if (StringUtils.hasText(icde.getHeadTitle())){
                head.setTitle(icde.getHeadTitle());
            }
            icd.setHead(head);
        } else if ("Y".equals(icde.getProfileYn())) {
            ItemCard.Profile profile = new ItemCard.Profile();
            if (StringUtils.hasText(profile.getImageUrl())) {
                profile.setImageUrl(icde.getProfileImgUrl());
            }
            if (icde.getProfileWidth() != null) {
                profile.setWidth(icde.getProfileWidth());
            }
            if (icde.getProfileHeight() != null) {
                profile.setHeight(icde.getProfileHeight());
            }
            if (StringUtils.hasText(icde.getProfileTitle())) {
                profile.setTitle(icde.getProfileTitle());
            }

            icd.setProfile(profile);
        }

        // ImageTitle 설정
        if ("Y".equals(icde.getImgtitleYn())) {
            ItemCard.ImageTitle imageTitle = new ItemCard.ImageTitle();
            if (StringUtils.hasText(icde.getImgtitleTitle())) {
                imageTitle.setTitle(icde.getImgtitleTitle());
            }
            if (StringUtils.hasText(icde.getImgtitleDesc())) {
                imageTitle.setDescription(icde.getImgtitleDesc());
            }
            if (StringUtils.hasText(icde.getImgtitleImgUrl())) {
                imageTitle.setImageUrl(icde.getImgtitleImgUrl());
            }
            icd.setImageTitle(imageTitle);
        }

        // ItemList 설정 (필수)
        // 여기에 list를 사용하여 ItemList 객체들을 생성하고 설정하는 로직 추가

        // ItemListSummary 설정
        if ("Y".equals(icde.getItemlistSummaryYn())) {
            ItemCard.ItemListSummary itemListSummary = new ItemCard.ItemListSummary();
            if (StringUtils.hasText(icde.getItemlistSummaryTitle())) {
                itemListSummary.setTitle(icde.getItemlistSummaryTitle());
            }
            if (StringUtils.hasText(icde.getItemlistSummaryDesc())) {
                itemListSummary.setDescription(icde.getItemlistSummaryDesc());
            }
            icd.setItemListSummary(itemListSummary);
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
            icd.setItemList(itemListArrayList);
        }

        icd = switch (be.getBlockId()) {
            case "" -> {
                yield null;
            }
            default -> icd;
        };

        if (btneList.size() != 0) {
            List<Button> btnList = getButtonList(btneList);
            icd.setButtons(btnList);
        }

        Map<String, Object> output = new HashMap<>(); // component
        output.put(ChatbotConstants.ComponentType.ITEM_CARD, icd);
        return output;
    }

    public Map<String, Object> getListCard(SkillResV1TemplateListCardEntity lcde, List<SkillResV1TemplateListCardListItemEntity> itemListelist, BuilderV1BlockEntity be, List<SkillResV1TemplateComponentBtnEntity> btneList){
        ListCard lcd = new ListCard();
        List<ListItem> items = new ArrayList<>();
        for (SkillResV1TemplateListCardListItemEntity listItem : itemListelist) {
            ListItem item = new ListItem();
            if (StringUtils.hasText(listItem.getTitle())){
                item.setTitle(listItem.getTitle());
            }
            if (StringUtils.hasText(listItem.getDesc())){
                item.setDescription(listItem.getDesc());
            }
            if (StringUtils.hasText(listItem.getImgUrl())) {
                item.setImageUrl(listItem.getImgUrl());
            }
            Link link = new Link();
            if (StringUtils.hasText(listItem.getLinkWeb())){
                link.setWeb(listItem.getLinkWeb());
            }
            if (StringUtils.hasText(listItem.getLinkPc())){
                link.setPc(listItem.getLinkPc());
            }
            if (StringUtils.hasText(listItem.getLinkMobile())){
                link.setMobile(listItem.getLinkMobile());
            }
            if (StringUtils.hasText(link.getPc()) || StringUtils.hasText(link.getWeb()) || StringUtils.hasText(link.getMobile())) {
                item.setLink(link);
            }
            if (StringUtils.hasText(listItem.getAction())) {
                item.setAction(listItem.getAction());
            }
            if (StringUtils.hasText(listItem.getBlockId())) {
                item.setBlockId(listItem.getAction());
            }
            if (StringUtils.hasText(listItem.getMessageText())) {
                item.setMessageText(listItem.getMessageText());
            }
            SkillResV1TemplateListCardListItemExtraEntity extrae = skillResV1TemplateListCardListItemExtraEntityRepository.findBySkillResV1TemplateListCardListItemEntity_ListItemId(listItem.getListItemId());
            if (Objects.nonNull(extrae)) {
                if (StringUtils.hasText(extrae.getKey())) {
                    if (StringUtils.hasText(extrae.getValue())) {
                        Map<String, Object> extra = new HashMap<>();
                        extra.put(extrae.getKey(), extrae.getValue());
                        item.setExtra(extra);
                    }
                }
            }
            if (listItem.getHeaderYn().equals('Y')) {
                lcd.setHeader(item);
            } else {
                items.add(item);
            }
        }

        if (items.size() != 0){
            lcd.setItems(items);
        }

        lcd = switch (be.getBlockId()) {
            case "" -> {
                yield null;
            }
            default -> lcd;
        };

        if (btneList.size() != 0) {
            List<Button> btnList = getButtonList(btneList);
            lcd.setButtons(btnList);
        }

        Map<String, Object> output = new HashMap<>(); // component
        output.put(ChatbotConstants.ComponentType.LIST_CARD, lcd);
        return output;
    }

    public List<Button> getButtonList(List<SkillResV1TemplateComponentBtnEntity> btnEntityList) {
        List<Button> btnList = new ArrayList<>();

        for (SkillResV1TemplateComponentBtnEntity btnEntity : btnEntityList) {
            Button btn = new Button();
            if (StringUtils.hasText(btnEntity.getLabel())) {
                btn.setLabel(btnEntity.getLabel());
            }
            if (StringUtils.hasText(btnEntity.getAction())) {
                btn.setAction(btnEntity.getAction());
            }
            if (StringUtils.hasText(btnEntity.getWebLinkUrl())) {
                btn.setWebLinkUrl(btnEntity.getWebLinkUrl());
            }
            if (StringUtils.hasText(btnEntity.getMessageText())) {
                btn.setMessageText(btnEntity.getMessageText());
            }
            if (StringUtils.hasText(btnEntity.getPhone())) {
                btn.setPhoneNumber(btnEntity.getPhone());
            }
            if (StringUtils.hasText(btnEntity.getBlockId())) {
                btn.setBlockId(btnEntity.getBlockId());
            }
            UUID btneId = btnEntity.getBtnId();
            SkillResV1TemplateComponentBtnExtraEntity btnExtrae = skillResV1TemplateComponentBtnExtraEntityRepository.findBySkillResV1TemplateComponentBtnEntity_BtnId(btneId);
            if (Objects.nonNull(btnExtrae)) {
                Map<String, Object> extra = new HashMap<>();
                if (StringUtils.hasText(btnExtrae.getKey())){
                    if(StringUtils.hasText(btnExtrae.getValue())){
                        extra.put(btnExtrae.getKey(), btnExtrae.getValue());
                        btn.setExtra(extra);
                    }
                }
            }
            btnList.add(btn);
        }

        return btnList;
    }
}
