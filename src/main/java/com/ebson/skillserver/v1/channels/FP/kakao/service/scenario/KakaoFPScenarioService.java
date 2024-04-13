package com.ebson.skillserver.v1.channels.FP.kakao.service.scenario;

import com.ebson.skillserver.common.SkillResponse;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1BlockEntity;
import com.ebson.skillserver.v1.channels.FP.entity.SkillBusiV1UserFpEntity;
import org.springframework.stereotype.Service;

@Service
public interface KakaoFPScenarioService {

    public SkillResponse getTemplateAndReturn(SkillBusiV1UserFpEntity skillBusiV1UserFpEntity
                                            , BuilderV1BlockEntity builderV1BlockEntity
                                            , String channelName);

}
