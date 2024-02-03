package com.ebson.skillserver.common;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ListCard {
    private ListItem header;
    private List<ListItem> items;
    private List<Button> buttons;

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
}
