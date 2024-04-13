package com.ebson.skillserver.v1.channels.FP.kakao.service.scenario;

import com.ebson.skillserver.common.SkillResponse;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1BlockContextEntity;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1BlockEntity;
import com.ebson.skillserver.v1.channels.FP.entity.SkillBusiV1UserFpEntity;
import com.ebson.skillserver.v1.channels.FP.kakao.service.KakaoFPTemplateService;
import com.ebson.skillserver.v1.channels.FP.process.FPProcessService;
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

    @Autowired
    FPProcessService fPProcessService;

    @Override
    public SkillResponse getTemplateAndReturn(SkillBusiV1UserFpEntity skillBusiV1UserFpEntity
                                            , BuilderV1BlockEntity builderV1BlockEntity
                                            , BuilderV1BlockContextEntity builderV1BlockContextEntity
                                            , String channelName) {

        SkillResponse skillResponse = null;
        try {
            // context 엔티티로부터 process 엔티티를 조회
            // process 실행 결과 templateId 조회
            UUID templateId = UUID.randomUUID();

            skillResponse = kakaoFPTemplateService.setTemplateAndReturn(templateId, builderV1BlockEntity);

            // skillResponse 의 context 를 세팅
        } catch(Exception e) {
            e.printStackTrace();
        }

        return skillResponse;
    }
}
