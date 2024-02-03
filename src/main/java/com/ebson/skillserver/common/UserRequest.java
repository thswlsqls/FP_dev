package com.ebson.skillserver.common;

import lombok.Data;
import java.util.Map;

@Data
public class UserRequest {
    private Block block;
    private User user;
    private String utterance;
    private Map<String, String> params;
    private String lang;
    private String timezone;

    @Data
    public class Block {
        private String id;
        private String name;
    }

    @Data
    public class User {
        private String id;
        private String type;
        private Map<String, String> properties;
    }
}



