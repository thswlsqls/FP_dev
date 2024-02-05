package com.ebson.skillserver.common;


import lombok.Data;

@Data
public class SimpleImage {
    private String imgUrl; // 필수O 전달하고자 하는 이미지의 url입니다
    private String altText; // 필수O url이 유효하지 않은 경우, 전달되는 텍스트입니다
}
