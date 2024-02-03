package com.ebson.skillserver.common;

import lombok.Data;

@Data
public class Thumbnail {
    private String imageUrl;
    private Link link;
    private boolean fixedRatio;
}
