package com.ebson.skillserver.common;

import lombok.Data;

import java.util.List;

@Data
public class ItemCard {
    private Thumbnail thumbnail;
    private Head head;
    private Profile profile;
    private ImageTitle imageTitle;
    private List<ItemList> itemList;
    private String itemListAlignment;
    private ItemListSummary itemListSummary;
    private String title;
    private String description;
    private List<Button> buttons;
    private String buttonLayout;

    @Data
    public class Thumbnail {
        private String imageUrl;
        private Integer width;
        private Integer height;
        private Link link;
    }

    @Data
    public class Head {
        private String title;
    }

    @Data
    public class Profile {
       private String imageUrl;
       private Integer width;
       private Integer height;
       private String title;
    }

    @Data
    public class ImageTitle {
        private String title;
        private String description;
        private String imageUrl;
    }

    @Data
    public class ItemList {
        private String title;
        private String description;
    }

    @Data
    public class ItemListSummary {
        private String title;
        private String description;
    }
}
