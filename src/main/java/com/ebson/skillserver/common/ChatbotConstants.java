package com.ebson.skillserver.common;

public final class ChatbotConstants {

    public class ComponentType {
        // 컴포넌트 타입 상수
        public static final String SIMPLE_TEXT = "simpleText";
        public static final String SIMPLE_IMAGE = "simpleImage";
        public static final String TEXT_CARD = "textCard";
        public static final String BASIC_CARD = "basicCard";
        public static final String COMMERCE_CARD = "commerceCard";
        public static final String LIST_CARD = "listCard";
        public static final String ITEM_CARD = "itemCard";
        public static final String CAROUSEL = "carousel";
    }

    public static final String VERSION = "2.0";



    // 기타 고정 문자열 상수
    public static final String WELCOME_MESSAGE = "Welcome to our Chatbot";

    // private 생성자를 통해 인스턴스화 방지
    private ChatbotConstants() {
        // 이 클래스는 인스턴스화되어서는 안됩니다.
    }
}
