package com.ebson.skillserver.common;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ListCard {
    private ListItem header;
    private List<ListItem> items;
    private List<Button> buttons;
}
