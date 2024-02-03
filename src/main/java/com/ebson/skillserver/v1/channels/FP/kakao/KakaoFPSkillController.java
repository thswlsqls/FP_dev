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
        SimpleText st = new SimpleText();
        st.setText("KakaoFPSkillController.handleSkillRequest : 테스트 블럭을 호출하셨습니다.");
        List<Map<String, Object>> outputs = new ArrayList<>();
        Map<String, Object> component = new HashMap<String, Object>();
        component.put(ChatbotConstants.SIMPLE_TEXT, st);
        outputs.add(component);
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
