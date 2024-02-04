package com.ebson.skillserver.v1.channels.FP.kakao;

import com.ebson.skillserver.common.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class KakaoFPSkillController {

    private static final Logger log = LoggerFactory.getLogger(KakaoFPSkillController.class);

    @PostMapping("/FP/kakao/basicSkill")
    public SkillResponse handleSkillRequest(@RequestBody SkillPayload skillPayload) {

        // 요청 처리 로직 구현
        // 예제로 간단한 응답을 생성하여 반환
        SkillResponse skillResponse = new SkillResponse();
        Template template = new Template();

        // Component #1 SimpleText
        SimpleText simpleText = new SimpleText();
        simpleText.setText("스킬 응답 : 테스트 블럭을 호출하셨습니다.");
        List<Map<String, Object>> outputs = new ArrayList<>();
        Map<String, Object> component1 = new HashMap<String, Object>();
        component1.put(ChatbotConstants.SIMPLE_TEXT, simpleText);
        outputs.add(component1);

        // Component #2 SimpleImage
        SimpleImage simpleImage = new SimpleImage();
        simpleImage.setAltText("이미지가 없습니다.");
        simpleImage.setImgUrl("http://localhost:8080/testImg.jpg");
        Map<String, Object> component2 = new HashMap<String, Object>();
        component2.put(ChatbotConstants.SIMPLE_IMAGE, simpleImage);
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
        component3.put(ChatbotConstants.TEXT_CARD, textCard);
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
        component4.put(ChatbotConstants.BASIC_CARD, basicCard);
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
        component5.put(ChatbotConstants.COMMERCE_CARD, commerceCard);
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
        component6.put(ChatbotConstants.LIST_CARD, listCard);
        outputs.add(component6);

        // Component #7 ItemCard

        // Component #8 Carousel

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
