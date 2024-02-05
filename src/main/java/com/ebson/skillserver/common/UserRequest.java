package com.ebson.skillserver.common;

import lombok.Data;
import java.util.Map;

@Data
public class UserRequest {
    private Block block; // 사용자의 발화에 반응한 블록의 정보입니다. 블록의 id와 name을 포함합니다.
    private User user; // 사용자의 정보입니다.
    private String utterance; // 봇 시스템에 전달된 사용자의 발화입니다.
    private Map<String, String> params;
    private String lang; // 사용자의 언어를 반화합니다. 한국에서 보낸 요청이라면 “ko”를 갖습니다.
    private String timezone; // 사용자의 시간대를 반환합니다.한국에서 보낸 요청이라면 “Asia/Seoul”를 갖습니다.

    @Data
    public class Block {
        private String id;
        private String name;
    }

    @Data
    public class User {
        private String id; // 사용자를 식별할 수 있는 key로 최대 70자의 값을 가지고 있습니다. 이 값은 특정한 bot에서 사용자를 식별할 때 사용할 수 있습니다. 동일한 사용자더라도, 봇이 다르면 다른 id가 발급됩니다.
        private String type; // 현재는 botUserKey만 제공합니다.
        private Map<String, String> properties; // 추가적으로 제공하는 사용자의 속성 정보입니다.
    }
}



