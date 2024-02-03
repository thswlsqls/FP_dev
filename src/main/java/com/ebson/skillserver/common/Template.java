package com.ebson.skillserver.common;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Template {
    // template 내부 구조에 따라 필드 추가
    private List<Map<String, Object>> outputs; // Map<String, Object> 는 Component에 해당하고 SimpleText, SimpleImage, TextCard, BasicCard, CommerceCard, ListCard, ItemCard, Carousel 클래스가 Object 값 으로 사용될 수 있음.
    private List<QuickReply> quickReplies;

    @Data
    public class QuickReply {
        private String label;
        private String action;
        private String messagText;
        private String blockId;
        private Map<String, Object> extra;
    }
}

