package com.ebson.skillserver.common;

import lombok.Data;

import java.util.List;

@Data
public class BasicCard {
    private String title; // 필수X 카드의 제목입니다. 최대 2줄
    private String description; // 필수X 카드에 대한 상세 설명입니다. 최대 230자
    private Thumbnail thumbnail; // 필수O 카드의 상단 이미지입니다.
    private List<Button> buttons; // 필수X 카드의 버튼들을 포함합니다. 최대 3개
}
