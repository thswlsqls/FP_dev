package com.ebson.skillserver.v1.channels.FP.kakao.service.scenario;

import com.ebson.skillserver.common.SkillResponse;
import com.ebson.skillserver.v1.channels.FP.entity.*;
import com.ebson.skillserver.v1.channels.FP.kakao.service.KakaoFPTemplateService;
import com.ebson.skillserver.v1.channels.FP.process.FPProcessService;
import com.ebson.skillserver.v1.channels.FP.repository.SkillBusiV1BlockProcEntityRepository;
import com.ebson.skillserver.v1.channels.FP.repository.SkillBusiV1BlockProcUnitEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.UUID;

@Service("KakaoFPScenarioS01Service")
public class KakaoFPScenarioS01Service implements KakaoFPScenarioService {

    private static final Logger log = LoggerFactory.getLogger(KakaoFPScenarioS01Service.class);
    @Autowired
    KakaoFPTemplateService kakaoFPTemplateService;

    @Autowired
    FPProcessService fPProcessService;

    @Autowired
    SkillBusiV1BlockProcEntityRepository skillBusiV1BlockProcEntityRepository;

    @Autowired
    SkillBusiV1BlockProcUnitEntityRepository skillBusiV1BlockProcUnitEntityRepository;


    @Override
    public SkillResponse getTemplateAndReturn(SkillBusiV1UserFpEntity skillBusiV1UserFpEntity
                                            , BuilderV1BlockEntity builderV1BlockEntity
                                            , BuilderV1BlockContextEntity builderV1BlockContextEntity
                                            , String channelName) {

        SkillResponse skillResponse = null;
        try {
            UUID contextId = builderV1BlockContextEntity.getContextId();
            SkillBusiV1BlockProcEntity skillBusiV1BlockProcEntity = skillBusiV1BlockProcEntityRepository.findByBuilderV1BlockContextEntity_ContextId(contextId);
            UUID procId = skillBusiV1BlockProcEntity.getProcId();
            List<SkillBusiV1BlockProcUnitEntity> skillBusiV1BlockProcUnitEntityList = skillBusiV1BlockProcUnitEntityRepository.findBySkillBusiV1BlockProcEntity_ProcIdOrderByProcUnitNoAsc(procId);

            UUID templateId = null;
            int nextProcNo = 1;
            while (nextProcNo > 0) {
                SkillBusiV1BlockProcUnitEntity curProcUnit = skillBusiV1BlockProcUnitEntityRepository.findBySkillBusiV1BlockProcEntity_ProcIdAndProcUnitNo(procId, nextProcNo);
                nextProcNo = switch (curProcUnit.getProcUnitType()) {
                    case "DIV" -> {
                        /** DIV 타입 프로세스 유닛 메서드 실행 */
                        int condition = 1;
                        yield condition == 1 ? curProcUnit.getNextProcUnitNo1() : condition == 2 ? curProcUnit.getNextProcUnitNo2() : curProcUnit.getNextProcUnitNo3();
                    } case "VLD" -> {
                        /** VLD 타입 프로세스 유닛 메서드 실행 */
                        yield curProcUnit.getNextProcUnitNo1();
                    } case "DBT" -> {
                        /** DBT 타입 프로세스 유닛 메서드 실행 */
                        yield curProcUnit.getNextProcUnitNo1();
                    } case "ITF" -> {
                        /** ITF 타입 프로세스 유닛 메서드 실행 */
                        yield curProcUnit.getNextProcUnitNo1();
                    } case "CAH" -> {
                        /** CAH 타입 프로세스 유닛 메서드 실행 */
                        yield curProcUnit.getNextProcUnitNo1();
                    } case "TPL" -> {
                        /** TPL타입 프로세스 유닛 메서드 실행 */
                        /** templateId 추출 */
                        templateId = UUID.randomUUID();
                        log.info("KakaoFPScenarioS01Service^^getTemplateAndReturn() :: {}", templateId.toString());
                        yield 0;
                    }
                    default -> 0;
                };
            }

            skillResponse = kakaoFPTemplateService.setTemplateAndReturn(templateId, builderV1BlockEntity);
            /** skillResponse 의 context 를 세팅 */
        } catch(Exception e) {
            StackTraceElement[] ste = e.getStackTrace();
            String className = ste[0].getClassName();
            String metodName = ste[0].getMethodName();
            int lineNum = ste[0].getLineNumber();
            String fileNeme = ste[0].getFileName();
            log.error("Exception : {}, className : {} , methodName : {}, fileName : {}, lineNum : {}",
                    e.getMessage(), className, metodName, fileNeme, lineNum);
        }
        return skillResponse;
    }
}
