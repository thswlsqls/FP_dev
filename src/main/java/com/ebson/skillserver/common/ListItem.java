package com.ebson.skillserver.common;

import lombok.Data;

import java.util.Map;

@Data
public class ListItem {
    private String title;
    private String description;
    private String imageUrl;
    private Link link;
    private String action;
    private String blockId;
    private String messageText;
    private Map<String, Object> extra;
}
