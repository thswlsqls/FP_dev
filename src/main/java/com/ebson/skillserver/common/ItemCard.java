package com.ebson.skillserver.common;

import lombok.Data;

import java.util.List;

@Data
public class ItemCard {
    private Thumbnail thumbnail; // 필수X 상단 이미지입니다. 단일형: 이미지 비율 2:1 (800*400), 1:1 (800*800)사용 가능 케로셀형: 이미지 비율 2:1 (800*400)만 사용 가능
    private Head head; // 필수X head와 profile 두 필드를 동시에 노출할 수 없음. 케로셀형: 카드별로 head와 profile을 섞어서 사용할 수 없음.
    private Profile profile; // 필수X 프로필 정보입니다. head와 profile 두 필드를 동시에 노출할 수 없음. 케로셀형: 카드별로 head와 profile을 섞어서 사용할 수 없음
    private ImageTitle imageTitle; // 필수X 이미지를 동반하는 제목 및 설명 정보입니다. 이미지 우측 정렬 고정 (위치 변경 불가)
    private List<ItemList> itemList; // 필수O 아이템 목록 정보입니다. 좌측 정렬 디폴트, 단일형: 최대 10개까지 사용 가능, 케로셀형: 최대 5개까지 사용 가능
    private String itemListAlignment; // 필수X itemList 및 itemListAlignment 정렬 정보입니다. "left" 혹은 "right"만 입력 가능
    private ItemListSummary itemListSummary; // 필수X 아이템 가격 정보입니다. itemListSummary 사용 시 itemListAlignment 우측 정렬을 권장
    private String title; // 필수X 타이틀 정보입니다. title과 description 합쳐서 글자수 제한. description을 넣는 경우, title이 필수 항목
    private String description; // 필수X 설명 정보입니다. title과 description 합쳐서 글자수 제한. description을 넣는 경우, title이 필수 항목
    private List<Button> buttons; // 다양한 액션을 수행할 수 있는 버튼 정보입니다. 단일형: 최대 3개까지 사용 가능. 케로셀형: 최대 2개까지 사용 가능.
    private String buttonLayout; // 버튼 정렬 정보입니다. "vertical" (세로배치) 혹은 "horizontal" (가로배치) 만 입력 가능.

    @Data
    public static class Thumbnail {
        private String imageUrl; // 필수O 이미지의 url 정보입니다.
        private Integer width; // 필수X 이미지의 넓이 정보입니다.
        private Integer height; // 필수X 이미지의 높이 정보입니다.
        private Link link; // 필수X 이미지 클릭 시 작동하는 link입니다.
    }

    @Data
    public static class Head {
        private String title; // 필수O 최대 1 줄 (한 줄에 들어갈 수 있는 글자수는 기기 별로 상이)
    }

    @Data
    public static class Profile {
       private String imageUrl; // 필수X 프로필 이미지 정보입니다.
       private Integer width; // 필수X 프로필 이미지의 넓이 정보입니다.
       private Integer height; // 필수X 프로필 이미지의 높이 정보입니다.
       private String title; // 필수O 프로필 타이틀 정보입니다.
    }

    @Data
    public static class ImageTitle {
        private String title;   // 필수O 최대 2줄 (한 줄에 들어갈 수 있는 글자수는 기기 별로 상이)
        private String description; // 필수X 최대 1줄 (한 줄에 들어갈 수 있는 글자수는 기기 별로 상이)
        private String imageUrl; // 필수X URL 형식, 최적이미지 사이즈 iOS 108 x 108, 안드로이드 98 x 98 (맞지 않는 경우 센터크롭됨)
    }

    @Data
    public static class ItemListSummary {
        private String title; // 필수O 아이템리스트 전체에 대한 제목 정보입니다. 최대 6자
        private String description; // 필수O 아이템리스트 전체에 대한 설명 정보입니다. 최대 14자 (통화기호/문자, 숫자, 콤마, 소수점, 띄어쓰기 포함)
    }
}
