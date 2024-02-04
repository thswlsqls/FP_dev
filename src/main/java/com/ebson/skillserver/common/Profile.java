package com.ebson.skillserver.common;

import lombok.Data;

@Data
public class Profile {
    private String nickname; // 필수O 프로필 이름
    private String imageUrl; // 필수X 프로필 이미지
}
