package com.ebson.skillserver.v1.channels.FP.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FPProcessService {

    private static final Logger log = LoggerFactory.getLogger(FPProcessService.class);

    /**
     * 프로세스 타입
     * 1. CHK - 조건에 따른 분기 처리
     * 2. DBT - 데이터베이스 데이터 상태를 변경
     * 3. ITF - 외부 인터페이스 호출
     * 4. CAH - 캐시 조회
     * 5. VLD - 입력값 유효성 검사
     * 6. TPL - 응답 템플릿 아이디 조회
     * */

}
