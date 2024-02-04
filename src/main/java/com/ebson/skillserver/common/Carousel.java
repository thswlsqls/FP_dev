package com.ebson.skillserver.common;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Carousel {
    private String type;
    private List<Map<String, Object>> items;
    private CarouselHeader header;

    @Data
    public class CarouselHeader {
        private String title;
        private String description;
        private Thumbnail thumbnail;
    }
}
