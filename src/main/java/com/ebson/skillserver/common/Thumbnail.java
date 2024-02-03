package com.ebson.skillserver.common;

import lombok.Data;

@Data
public class Thumbnail {
    private String imageUrl; // 필수O 이미지의 url입니다.
    private Link link; // 필수X 이미지 클릭시 작동하는 link입니다.
    private boolean fixedRatio; // 필수X
    // true: 이미지 영역을 1:1 비율로 두고 이미지의 원본 비율을 유지합니다. 이미지가 없는 영역은 흰색으로 노출합니다.
    // false: 이미지 영역을 2:1 비율로 두고 이미지의 가운데를 크롭하여 노출합니다.
    // 기본값: false
    // ※ 케로셀 내에서는 모든 이미지가 정사각형 (1:1) 혹은 모든 이미지가 와이드형 (2:1)으로 통일되어야 합니다.
    // ※ BasicCard 또는 CommerceCard에서 true 설정 시, 버튼이 가로로 배열되며 최대 2개로 제한됩니다.
}
