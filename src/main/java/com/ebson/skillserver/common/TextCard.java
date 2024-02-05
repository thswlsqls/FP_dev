package com.ebson.skillserver.common;

import lombok.Data;

import java.util.List;

@Data
public class TextCard {
    private String title; // 카드의 제목입니다. 최대 50자
    private String description; // 카드에 대한 상세 설명입니다. 단일형인 경우, 최대 400자 (title에 따라 달라짐) 케로셀인 경우, 최대 128자
    private List<Button> buttons; // 카드의 버튼들을 포함합니다. 최대 3개
}
