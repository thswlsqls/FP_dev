package com.ebson.skillserver.v1.channels.FP.kakao.service;

import com.ebson.skillserver.common.SkillResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public interface KakaoFPScenarioService {

    public SkillResponse getTemplateAndReturn(SkillResponse skillResponse);

}
