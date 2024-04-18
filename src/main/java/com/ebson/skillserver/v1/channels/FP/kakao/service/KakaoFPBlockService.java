package com.ebson.skillserver.v1.channels.FP.kakao.service;

import com.ebson.skillserver.common.SkillResponse;
import com.ebson.skillserver.component.ApplicationContextAwareImpl;
import com.ebson.skillserver.component.ScenarioServiceBeanIdProvider;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1BlockContextEntity;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1BlockEntity;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1ScenarioEntity;
import com.ebson.skillserver.v1.channels.FP.entity.SkillBusiV1UserFpEntity;
import com.ebson.skillserver.v1.channels.FP.kakao.service.scenario.KakaoFPScenarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.io.StringWriter;

@Service
public class KakaoFPBlockService {

    private static final Logger log = LoggerFactory.getLogger(KakaoFPBlockService.class);
    ApplicationContext applicationContext = ApplicationContextAwareImpl.getApplicationContext();
    @Autowired
    ScenarioServiceBeanIdProvider beanIdProvider;

    public SkillResponse retrieveScenarioServiceAndReturn(SkillBusiV1UserFpEntity skillBusiV1UserFpEntity
                                                        , BuilderV1BlockEntity builderV1BlockEntity
                                                        , BuilderV1BlockContextEntity builderV1BlockContextEntity
                                                        , String channelName){
        SkillResponse skillResponse = null;

        try {
            BuilderV1ScenarioEntity builderV1ScenarioEntity = builderV1BlockEntity.getBuilderV1ScenarioEntity();
            String scenarioCode = builderV1ScenarioEntity.getScenarioCode();

            KakaoFPScenarioService kakaoFPScenarioService = (KakaoFPScenarioService) applicationContext.getBean(beanIdProvider.getBeanId(channelName, scenarioCode));
            skillResponse = kakaoFPScenarioService.getTemplateAndReturn(skillBusiV1UserFpEntity, builderV1BlockEntity, builderV1BlockContextEntity, channelName);
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
        }

        return skillResponse;
    }

}
