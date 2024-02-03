package com.ebson.skillserver.common;

import lombok.Data;

import java.util.List;

@Data
public class BasicCard {
    private String title;
    private String description;
    private Thumbnail thumbnail;
    private List<Button> buttons;
}
