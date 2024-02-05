package com.ebson.skillserver.common;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ListCard {
    private ListItem header; // 필수O 카드의 상단 항목
    private List<ListItem> items; // 필수O 카드의 각각 아이템 최대 5 케로셀형 : 최대 4개
    private List<Button> buttons; // 필수X 최대 2개
}
