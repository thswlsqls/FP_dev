package com.ebson.skillserver.common;

import lombok.Data;
import java.util.List;

@Data
public class CommerceCard {
    private String title; // 필수X 제품의 이름입니다. 최대 30자
    private String description; // 필수X 제품에 대한 상세 설명입니다. 최대 40자
    private int price; // 필수O 제품의 가격입니다.
    private String currency; // 필수X 제품의 가격에 대한 통화입니다. 현재 won만 가능
    private Integer discount; // 필수X 제품의 가격에 대한 할인할 금액입니다.
    private Integer discountRate; // 필수X 제품의 가격에 대한 할인율입니다.
    private Integer discountedPrice; // 필수X(discountRate을 쓰는 경우 필수) 제품의 가격에 대한 할인가(할인된 가격)입니다.
    private List<Thumbnail> thumbnails; // 필수O 제품에 대한 사진입니다. 현재 1개만 가능
    private Profile profile; // 필수X 제품을 판매하는 프로필 정보입니다.
    private List<Button> buttons; // 필수X 다양한 액션을 수행할 수 있는 버튼입니다. 1개 이상, 3개 이하
}
