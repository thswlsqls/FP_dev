package com.ebson.skillserver.common;

import lombok.Data;

@Data
public class Link {
    private String pc; // 필수X pc의 웹을 실행하는 link입니다.
    private String mobile; // 필수X mobile의 웹을 실행하는 link입니다.
    private String web; // 필수X 모든 기기에서 웹을 실행하는 link입니다.
}
