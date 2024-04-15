package com.ebson.skillserver.v1.channels.FP.process;

import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1BlockEntity;
import com.ebson.skillserver.v1.channels.FP.entity.SkillBusiV1UserFpEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FPProcessService {

    private static final Logger log = LoggerFactory.getLogger(FPProcessService.class);

    /**
     * 프로세스 타입
     * 1. DIV - 조건에 따른 분기
     * 2. VLD - 값 유효성 검사
     * 3. DBT - 데이터베이스 데이터를 변경
     * 4. ITF - 외부 인터페이스 호출
     * 5. CAH - 캐시 조회 및 변경
     * 6. TPL - 응답 템플릿 조회
     * */

    public int executeDIVTypeProcUnit(SkillBusiV1UserFpEntity userEntity
                                    , BuilderV1BlockEntity blockEntity) {

        return 0;
    }

    public void executeVLDTypeProcUnit(SkillBusiV1UserFpEntity userEntity
                                     , BuilderV1BlockEntity blockEntity) {

    }

    public void executeDBTTypeProcUnit(SkillBusiV1UserFpEntity userEntity
                                     , BuilderV1BlockEntity blockEntity) {

    }

    public void executeITFTypeProcUnit(SkillBusiV1UserFpEntity userEntity
                                     , BuilderV1BlockEntity blockEntity) {

    }

    public void executeCAHTypeProcUnit(SkillBusiV1UserFpEntity userEntity
                                     , BuilderV1BlockEntity blockEntity) {

    }

    public UUID executeTPLTypeProcUnit(SkillBusiV1UserFpEntity userEntity
                                     , BuilderV1BlockEntity blockEntity) {

        return null;
    }

}
