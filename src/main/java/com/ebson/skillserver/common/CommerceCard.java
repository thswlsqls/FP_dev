package com.ebson.skillserver.common;

import lombok.Data;
import java.util.List;

@Data
public class CommerceCard {
    private String title; // 최대 30자
    private String description; // 최대 40자
    private int price;
    private String currency; // 2024-02-03 기준 won만 가능
    private Integer discount;
    private Integer discountRate;
    private Integer discountedPrice;
    private List<Thumbnail> thumbnails; // 2024-02-03 기준 1개만 가능
    private Profile profile;
    private List<Button> buttons; // 1개 이상, 3개 이하
}
