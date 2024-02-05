package com.ebson.skillserver.common;

import lombok.Data;

import java.util.Map;

@Data
public class ListItem {
    private String title; // 필수O header에 들어가는 경우, listCard의 제목이 됩니다. items에 들어가는 경우, 해당 항목의 제목이 됩니다.
    private String description; // 필수X header에 들어가는 경우, 아무런 작동을 하지 않습니다. items에 들어가는 경우, 해당 항목의 설명이 됩니다.
    private String imageUrl; // 필수X header에 들어가는 경우, 아무런 작동을 하지 않습니다. items에 들어가는 경우, 해당 항목의 우측 안내 사진이 됩니다.
    private Link link; // 필수X 클릭시 작동하는 링크입니다.
    private String action; // 필수X 클릭시 수행될 작업입니다. action 종류: block or message
    private String blockId; // action: block blockId를 갖는 블록을 호출합니다. (바로가기 응답의 블록 연결 기능과 동일) items의 title이 사용자의 발화로 나가게 됩니다.
    private String messageText; // action: message 사용자의 발화로 messageText를 내보냅니다. (바로가기 응답의 메세지 연결 기능과 동일)
    private Map<String, Object> extra; // 필수X block이나 message action으로 블록 호출시, 스킬 서버에 추가적으로 제공하는 정보
}
