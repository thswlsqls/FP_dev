package com.ebson.skillserver.common;

import lombok.Data;

import java.util.List;

@Data
public class Carousel {
    private String type;
    private List<Object> items;
    private CarouselHeader header;

    @Data
    public class CarouselHeader {
        private String title;
        private String description;
        private Thumbnail thumbnail;
    }
}
