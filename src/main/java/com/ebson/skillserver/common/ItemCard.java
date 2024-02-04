package com.ebson.skillserver.common;

import lombok.Data;

import java.util.List;

@Data
public class ItemCard {
    private Thumbnail thumbnail;
    private Head head; // 필수X head와 profile 두 필드를 동시에 노출할 수 없음. 케로셀형: 카드별로 head와 profile을 섞어서 사용할 수 없음.
    private Profile profile;
    private ImageTitle imageTitle; // 필수X 이미지를 동반하는 제목 및 설명 정보입니다. 이미지 우측 정렬 고정 (위치 변경 불가)
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
        private String title; // 필수O 최대 1 줄 (한 줄에 들어갈 수 있는 글자수는 기기 별로 상이)
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
        private String title;   // 필수O 최대 2줄 (한 줄에 들어갈 수 있는 글자수는 기기 별로 상이)
        private String description; // 필수X 최대 1줄 (한 줄에 들어갈 수 있는 글자수는 기기 별로 상이)
        private String imageUrl; // 필수X URL 형식, 최적이미지 사이즈 iOS 108 x 108, 안드로이드 98 x 98 (맞지 않는 경우 센터크롭됨)
    }

    @Data
    public class ItemListSummary {
        private String title;
        private String description;
    }
}
