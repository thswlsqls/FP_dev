package com.ebson.skillserver.common;

import lombok.Data;

import java.util.List;

@Data
public class TextCard {
    private String title;
    private String description;
    private List<Button> buttons;
}
