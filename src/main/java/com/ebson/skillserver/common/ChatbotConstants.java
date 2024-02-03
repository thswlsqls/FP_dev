package com.ebson.skillserver.common;

public final class ChatbotConstants {

    public static final String VERSION = "2.0";

    // 컴포넌트 타입 상수
    public static final String SIMPLE_TEXT = "SimpleText";
    public static final String SIMPLE_IMAGE = "SimpleImage";
    public static final String TEXT_CARD = "TextCard";
    public static final String BASIC_CARD = "BasicCard";
    public static final String COMMERCE_CARD = "CommerceCard";
    public static final String LIST_CARD = "ListCard";
    public static final String ITEM_CARD = "ItemCard";
    public static final String CAROUSEL = "Carousel";

    // 기타 고정 문자열 상수
    public static final String WELCOME_MESSAGE = "Welcome to our Chatbot";

    // private 생성자를 통해 인스턴스화 방지
    private ChatbotConstants() {
        // 이 클래스는 인스턴스화되어서는 안됩니다.
    }
}
