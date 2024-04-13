package com.ebson.skillserver.v1.channels.FP.kakao.service;

import com.ebson.skillserver.common.SkillResponse;
import com.ebson.skillserver.common.Template;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1BlockEntity;
import com.ebson.skillserver.v1.channels.FP.entity.SkillBusiV1UserFpEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("KakaoFPScenarioS01Service")
public class KakaoFPScenarioS01Service implements KakaoFPScenarioService{

    private static final Logger log = LoggerFactory.getLogger(KakaoFPScenarioS01Service.class);
    @Autowired
    KakaoFPTemplateService kakaoFPTemplateService;

    @Override
    public SkillResponse getTemplateAndReturn(SkillBusiV1UserFpEntity skillBusiV1UserFpEntity
                                            , BuilderV1BlockEntity builderV1BlockEntity
                                            , String channelName) {

        SkillResponse skillResponse = null;
        try {
            // process 실행 결과 templateId 조회
            UUID templateId = UUID.randomUUID();

            skillResponse = kakaoFPTemplateService.setTemplateAndReturn(templateId, builderV1BlockEntity);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return skillResponse;
    }
}
