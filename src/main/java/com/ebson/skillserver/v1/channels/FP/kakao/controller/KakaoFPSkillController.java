package com.ebson.skillserver.v1.channels.FP.kakao.controller;

import com.ebson.skillserver.common.*;
import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1BlockEntity;
import com.ebson.skillserver.v1.channels.FP.entity.SkillBusiV1UserFpEntity;
import com.ebson.skillserver.v1.channels.FP.kakao.service.KakaoFPBlockService;
import com.ebson.skillserver.v1.channels.FP.repository.BuilderV1BlockEntityRepository;
import com.ebson.skillserver.v1.channels.FP.repository.SkillBusiV1UserFpEntityRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class KakaoFPSkillController {

    private static final Logger log = LoggerFactory.getLogger(KakaoFPSkillController.class);

    @Autowired
    SkillBusiV1UserFpEntityRepository skillBusiV1UserFpEntityRepository;

    @Autowired
    BuilderV1BlockEntityRepository builderV1BlockEntityRepository;

    @Autowired
    KakaoFPBlockService kakaoFPBlockService;

    @PostMapping("/FP/kakao/mainSkill")
    public SkillResponse handleSkillRequest(@RequestBody SkillPayload skillPayload){
        SkillResponse skillResponse = null;

        try {
            String userKey = skillPayload.getBot().getId();
            SkillBusiV1UserFpEntity skillBusiV1UserFpEntity = skillBusiV1UserFpEntityRepository.findByUserKey(userKey);

            String blockId = skillPayload.getIntent().getId();
            BuilderV1BlockEntity builderV1BlockEntity = builderV1BlockEntityRepository.getReferenceById(blockId);

            skillResponse = kakaoFPBlockService.retrieveScenarioServiceAndReturn(skillBusiV1UserFpEntity, builderV1BlockEntity, "FP");

            skillResponse.setVersion(ChatbotConstants.VERSION);
            log.info("KakaoFPSkillController^^handleSkillRequest :: skillResponse : {}", skillResponse);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return skillResponse;
    }

    @PostMapping("/FP/kakao/skillResponseTest")
    public SkillResponse handleSkillRequestWithDomainTest(@RequestBody SkillPayload skillPayload) {

        // 요청 처리 로직 구현
        // 예제로 간단한 응답을 생성하여 반환
        SkillResponse skillResponse = new SkillResponse();
        Template template = new Template();

        // Component #1 SimpleText
        SimpleText simpleText = new SimpleText();
        simpleText.setText("스킬 응답 : 테스트 블럭을 호출하셨습니다.");
        List<Map<String, Object>> outputs = new ArrayList<>();
        Map<String, Object> component1 = new HashMap<String, Object>();
        component1.put(ChatbotConstants.ComponentType.SIMPLE_TEXT, simpleText);
        outputs.add(component1);

        // Component #2 SimpleImage
        SimpleImage simpleImage = new SimpleImage();
        simpleImage.setAltText("이미지가 없습니다.");
        simpleImage.setImgUrl("http://localhost:8080/testImg.jpg");
        Map<String, Object> component2 = new HashMap<String, Object>();
        component2.put(ChatbotConstants.ComponentType.SIMPLE_IMAGE, simpleImage);
        outputs.add(component2);

        // Component #3 TextCard
        TextCard textCard = new TextCard();
        textCard.setTitle("텍스트카드 제목");
        textCard.setDescription("텍스트카드 설명입니다.");
        Button textCardbutton1 = new Button();
        textCardbutton1.setLabel("텍스트카드 버튼1");
        textCardbutton1.setAction("block");
        textCardbutton1.setMessageText("테스트 블록 호출");
        Button textCardbutton2 = new Button();
        textCardbutton2.setLabel("텍스트카드 버튼2");
        textCardbutton2.setAction("webLinkUrl");
        textCardbutton2.setWebLinkUrl("http://localhost:8080/testPage");
        List<Button> textCardButtonList = new ArrayList<>();
        textCardButtonList.add(textCardbutton1);
        textCardButtonList.add(textCardbutton2);
        textCard.setButtons(textCardButtonList);
        Map<String, Object> component3 = new HashMap<String, Object>();
        component3.put(ChatbotConstants.ComponentType.TEXT_CARD, textCard);
        outputs.add(component3);

        // Component #4 BasicCard
        BasicCard basicCard = new BasicCard();
        basicCard.setTitle("베이직카드 제목");
        basicCard.setDescription("베이직카드 설명입니다.");
        Thumbnail thumbnail = new Thumbnail();
        thumbnail.setImageUrl("http://localhost:8080/testImg.jpg");
        basicCard.setThumbnail(thumbnail);
        Button basicCardbutton1 = new Button();
        basicCardbutton1.setLabel("베이직카드 버튼1");
        basicCardbutton1.setAction("block");
        basicCardbutton1.setMessageText("테스트 블록 호출");
        Button basicCardbutton2 = new Button();
        basicCardbutton2.setLabel("베이직카드 버튼2");
        basicCardbutton2.setAction("webLinkUrl");
        basicCardbutton2.setWebLinkUrl("http://localhost:8080/testPage");
        List<Button> basicCardButtonList = new ArrayList<>();
        basicCardButtonList.add(basicCardbutton1);
        basicCardButtonList.add(basicCardbutton2);
        basicCard.setButtons(basicCardButtonList);
        Map<String, Object> component4 = new HashMap<String, Object>();
        component4.put(ChatbotConstants.ComponentType.BASIC_CARD, basicCard);
        outputs.add(component4);

        // Component #5 CommerceCard
        CommerceCard commerceCard = new CommerceCard();
        commerceCard.setTitle("커머스카드 제목");
        commerceCard.setDescription("커머스카드 설명입니다.");
        commerceCard.setPrice(770000);
        commerceCard.setCurrency("won");
        commerceCard.setDiscount(77000);
        commerceCard.setDiscountRate(10);
        commerceCard.setDiscountedPrice(693000);
        List<Thumbnail> commerceCardThumbnails = new ArrayList<>();
        Thumbnail commerceCardThumbnail = new Thumbnail();
        commerceCardThumbnail.setImageUrl("http://localhost:8080/testImg.jpg");
        commerceCardThumbnails.add(commerceCardThumbnail);
        commerceCard.setThumbnails(commerceCardThumbnails);
        Profile commerceCardProfile = new Profile();
        commerceCardProfile.setImageUrl("http://localhost:8080/testImg.jpg");
        commerceCardProfile.setNickname("커머스카드 프로필 이름");
        commerceCard.setProfile(commerceCardProfile);
        List<Button> commerceCardButtonList = new ArrayList<>();
        Button commerceCardbutton1 = new Button();
        commerceCardbutton1.setLabel("커머스카드 버튼1");
        commerceCardbutton1.setAction("block");
        commerceCardbutton1.setMessageText("테스트 블록 호출");
        Map<String, Object> commerceCardBtn1extra = new HashMap<>();
        commerceCardBtn1extra.put("key1", "value1");
        commerceCardbutton1.setExtra(commerceCardBtn1extra);
        Button commerceCardbutton2 = new Button();
        commerceCardbutton2.setLabel("커머스카드 버튼2");
        commerceCardbutton2.setAction("webLinkUrl");
        commerceCardbutton2.setWebLinkUrl("http://localhost:8080/testPage");
        Map<String, Object> commerceCardBtn2extra = new HashMap<>();
        commerceCardBtn2extra.put("key1", "value1");
        commerceCardbutton2.setExtra(commerceCardBtn2extra);
        commerceCardButtonList.add(commerceCardbutton1);
        commerceCardButtonList.add(commerceCardbutton2);
        commerceCard.setButtons(commerceCardButtonList);
        Map<String, Object> component5 = new HashMap<String, Object>();
        component5.put(ChatbotConstants.ComponentType.COMMERCE_CARD, commerceCard);
        outputs.add(component5);

        // Component #6 ListCard
        ListCard listCard = new ListCard();
        ListItem listCardHeader = new ListItem();
        listCardHeader.setTitle("리스트카드 헤더 제목");
        listCardHeader.setAction("block");
        listCardHeader.setBlockId("6590ab5b193392115b5a7ff8");
        listCard.setHeader(listCardHeader);
        List<ListItem> listCardItems = new ArrayList<>();
        ListItem listCardItem1 = new ListItem();
        listCardItem1.setTitle("리스트카드 아이템1 제목");
        listCardItem1.setDescription("리스트카드 아이템1 설명입니다.");
        listCardItem1.setAction("block");
        listCardItem1.setBlockId("6590ab5b193392115b5a7ff8");
        Map<String, Object> listCardItem1Extra = new HashMap<>();
        listCardItem1Extra.put("key1", "value1");
        listCardItem1.setExtra(listCardItem1Extra);
        listCardItems.add(listCardItem1);
        ListItem listCardItem2 = new ListItem();
        listCardItem2.setTitle("리스트카드 아이템2 제목");
        listCardItem2.setDescription("리스트카드 아이템2 설명입니다.");
        listCardItem2.setAction("message");
        listCardItem2.setMessageText("리스트카드 아이템2의 액션 메세지 입니다.");
        Map<String, Object> listCardItem2Extra = new HashMap<>();
        listCardItem2Extra.put("key1", "value1");
        listCardItem2.setExtra(listCardItem2Extra);
        listCardItems.add(listCardItem2);
        listCard.setItems(listCardItems);
        List<Button> listCardButtons = new ArrayList<>();
        Button listCardButton1 = new Button();
        listCardButton1.setLabel("리스트카드 버튼1 제목");
        listCardButton1.setAction("block");
        listCardButton1.setBlockId("6590ab5b193392115b5a7ff8");
        listCardButtons.add(listCardButton1);
        Button listCardButton2 = new Button();
        listCardButton2.setLabel("리스트카드 버튼2 제목");
        listCardButton2.setAction("webLink");
        listCardButton2.setWebLinkUrl("http://localhost:8080/testPage");
        listCardButtons.add(listCardButton2);
        listCard.setButtons(listCardButtons);
        Map<String, Object> component6 = new HashMap<String, Object>();
        component6.put(ChatbotConstants.ComponentType.LIST_CARD, listCard);
        outputs.add(component6);

        // Component #7 ItemCard
        ItemCard itemCard = new ItemCard();
        ItemCard.Thumbnail itemCardThumbnail = new ItemCard.Thumbnail();
        itemCardThumbnail.setImageUrl("http://localhost:8080/testImg.jpg");
        itemCard.setThumbnail(itemCardThumbnail);
        ItemCard.Head itemCardHead = new ItemCard.Head();
        itemCardHead.setTitle("아이템카드 헤드의 제목");
        itemCard.setHead(itemCardHead);
        ItemCard.ImageTitle itemCardImageTitle = new ItemCard.ImageTitle();
        itemCardImageTitle.setTitle("아이템카드 이미지타이틀 제목");
        itemCardImageTitle.setDescription("아이템카드 이미지타이틀 설명입니다.");
        itemCardImageTitle.setImageUrl("http://localhost:8080/testImg.jpg");
        itemCard.setImageTitle(itemCardImageTitle);
        List<ItemList> itemCardItemListList = new ArrayList<>();
        ItemList itemCardItemList1 = new ItemList();
        itemCardItemList1.setTitle("아이템리스트1 제목");
        itemCardItemList1.setDescription("아이템리스트1 설명입니다.");
        itemCardItemListList.add(itemCardItemList1);
        ItemList itemCardItemList2 = new ItemList();
        itemCardItemList2.setTitle("아이템리스트2 제목");
        itemCardItemList2.setDescription("아이템리스트2 설명입니다.");
        itemCardItemListList.add(itemCardItemList2);
        itemCard.setItemList(itemCardItemListList);
        itemCard.setItemListAlignment("left");
        ItemCard.ItemListSummary itemCardItemListSummary = new ItemCard.ItemListSummary();
        itemCardItemListSummary.setTitle("아이템 리스트 서머리 제목");
        itemCardItemListSummary.setDescription("아이템 리스트 서머리 설명입니다.");
        itemCard.setItemListSummary(itemCardItemListSummary);
        itemCard.setTitle("아이템카드 제목");
        itemCard.setDescription("아이템카드 설명입니다.");
        List<Button> itemCardButtonList = new ArrayList<>();
        Button itemCardButton1 = new Button();
        itemCardButton1.setLabel("아이템카드 버튼1 제목");
        itemCardButton1.setAction("block");
        itemCardButton1.setBlockId("6590ab5b193392115b5a7ff8");
        itemCardButtonList.add(itemCardButton1);
        Button itemCardButton2 = new Button();
        itemCardButton2.setLabel("아이템카드 버튼2 제목");
        itemCardButton2.setAction("message");
        itemCardButton2.setMessageText("아이템카드 버튼2 액션 메시지입니다.");
        itemCardButtonList.add(itemCardButton2);
        itemCard.setButtons(itemCardButtonList);
        itemCard.setButtonLayout("vertical");
        Map<String, Object> component7 = new HashMap<String, Object>();
        component7.put(ChatbotConstants.ComponentType.ITEM_CARD, itemCard);
        outputs.add(component7);

        // Component #8 Carousel
        Carousel carousel = new Carousel();
        carousel.setType(ChatbotConstants.ComponentType.BASIC_CARD);
        List<Map<String, Object>> carouselItems = new ArrayList<>();
        BasicCard carouselBasicCard1 = new BasicCard();
        carouselBasicCard1.setTitle("캐러셀 베이직 카드1의 제목");
        carouselBasicCard1.setDescription("캐러셀 베이직 카드1의 설명입니다.");
        Thumbnail carouselBasicCard1Thumbnail = new Thumbnail();
        carouselBasicCard1Thumbnail.setImageUrl("http://localhost:8080/testImg.jpg");
        carouselBasicCard1.setThumbnail(carouselBasicCard1Thumbnail);
        List<Button> carouselBasicCard1Buttons = new ArrayList<>();
        Button carouselBasicCard1Button = new Button();
        carouselBasicCard1Button.setLabel("캐러셀 베이직카드1 버튼의 제목");
        carouselBasicCard1Button.setAction("block");
        carouselBasicCard1Button.setBlockId("6590ab5b193392115b5a7ff8");
        carouselBasicCard1Buttons.add(carouselBasicCard1Button);
        carouselBasicCard1.setButtons(carouselBasicCard1Buttons);
        Map<String, Object> carouselComponent1 = new HashMap<>();
        carouselComponent1.put(ChatbotConstants.ComponentType.BASIC_CARD, carouselBasicCard1);
        carouselItems.add(carouselComponent1);
        BasicCard carouselBasicCard2 = new BasicCard();
        carouselBasicCard2.setTitle("캐러셀 베이직 카드2의 제목");
        carouselBasicCard2.setDescription("캐러셀 베이직 카드2의 설명입니다.");
        Thumbnail carouselBasicCard2Thumbnail = new Thumbnail();
        carouselBasicCard2Thumbnail.setImageUrl("http://localhost:8080/testImg.jpg");
        carouselBasicCard2.setThumbnail(carouselBasicCard2Thumbnail);
        List<Button> carouselBasicCard2Buttons = new ArrayList<>();
        Button carouselBasicCard2Button = new Button();
        carouselBasicCard2Button.setLabel("캐러셀 베이직카드2 버튼의 제목");
        carouselBasicCard2Button.setAction("block");
        carouselBasicCard2Button.setBlockId("6590ab5b193392115b5a7ff8");
        carouselBasicCard2Buttons.add(carouselBasicCard2Button);
        carouselBasicCard2.setButtons(carouselBasicCard2Buttons);
        Map<String, Object> carouselComponent2 = new HashMap<>();
        carouselComponent2.put(ChatbotConstants.ComponentType.BASIC_CARD, carouselBasicCard2);
        carouselItems.add(carouselComponent2);
        carousel.setItems(carouselItems);
        Carousel.CarouselHeader carouselHeader = new Carousel.CarouselHeader();
        carouselHeader.setTitle("케러셀 헤더 제목");
        carouselHeader.setDescription("케러셀 헤더 설명입니다.");
        Thumbnail carouselHeaderThumbnail = new Thumbnail();
        carouselHeaderThumbnail.setImageUrl("http://localhost:8080/testImg.jpg");
        Link carouselHeaderThumbnailLink = new Link();
        carouselHeaderThumbnailLink.setPc("http://localhost:8080/testPage");
        carouselHeaderThumbnailLink.setMobile("http://localhost:8080/testPage");
        carouselHeaderThumbnailLink.setWeb("http://localhost:8080/testPage");
        carouselHeaderThumbnail.setLink(carouselHeaderThumbnailLink);
        carouselHeader.setThumbnail(carouselHeaderThumbnail);
        carousel.setHeader(carouselHeader);
        Map<String, Object> component8 = new HashMap<String, Object>();
        component8.put(ChatbotConstants.ComponentType.CAROUSEL, carousel);
        outputs.add(component8);

        template.setOutputs(outputs);
        skillResponse.setTemplate(template);
        skillResponse.setVersion(ChatbotConstants.VERSION);

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonSkillPayload = mapper.writeValueAsString(skillPayload);
            log.info("handleSkillRequest :: SkillPayload :: {}", jsonSkillPayload);
            String jsonSkillResponse = mapper.writeValueAsString(skillResponse);
            log.info("handleSkillRequest :: SkillResponse :: {}", jsonSkillResponse);
        } catch (Exception e){
            e.printStackTrace();
        }

        return skillResponse;
    }
}
