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
        List<Button> textCardbuttonList = new ArrayList<>();
        textCardbuttonList.add(textCardbutton1);
        textCardbuttonList.add(textCardbutton2);
        textCard.setButtons(textCardbuttonList);
        Map<String, Object> component3 = new HashMap<String, Object>();
        component3.put(ChatbotConstants.TEXT_CARD, textCard);
        outputs.add(component3);

        // Component #3 BasicCard
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
        List<Button> basicCardbuttonList = new ArrayList<>();
        basicCardbuttonList.add(basicCardbutton1);
        basicCardbuttonList.add(basicCardbutton2);
        basicCard.setButtons(basicCardbuttonList);
        Map<String, Object> component4 = new HashMap<String, Object>();
        component4.put(ChatbotConstants.BASIC_CARD, basicCard);
        outputs.add(component4);

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
