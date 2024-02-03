package com.ebson.skillserver.common;

import lombok.Data;

import java.util.Map;

@Data
public class Button {
    private String label;
    private String action;
    private String webLinkUrl;
    private String messageText;
    private String phoneNumber;
    private String blockId;
    private Map<String, Object> extra;
}
