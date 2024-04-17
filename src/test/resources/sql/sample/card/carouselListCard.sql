-- 11. carousel > listCard
-- 11.1. SKILL_RES_V1_TEMPLATE
INSERT INTO SKILL_RES_V1_TEMPLATE (BLOCK_ID, BLOCK_CODE, TEMPLATE_NAME, CREATOR, LAST_UPDATER)
VALUES ('6590ab5b193392115b5a7ff8', 'FP_S01_B01', '테스트 템플릿(carousel > listCard)', 'admin', 'admin')
;

-- 11.2. SKILL_RES_V1_TEMPLATE_OUTPUT
INSERT INTO SKILL_RES_V1_TEMPLATE_OUTPUT (TEMPLATE_ID, OUTPUT_ORD, OUTPUT_NAME, CREATOR, LAST_UPDATER)
VALUES (UNHEX('E4071279F3D611EEB5380A48BC1A5EE1'), 1, '테스트 아웃풋(carousel > listCard)', 'admin', 'admin')
;

-- 11.3. SKILL_RES_V1_TEMPLATE_COMPONENT
INSERT INTO SKILL_RES_V1_TEMPLATE_COMPONENT (OUTPUT_ID, COMPONENT_TYPE, COMPONENT_NAME, CREATOR, LAST_UPDATER)
VALUES (UNHEX('F984BFCDF3D611EEB5380A48BC1A5EE1'), 'carousel', '테스트 컴포넌트(carousel > listCard)', 'admin', 'admin')
;

INSERT INTO SKILL_RES_V1_TEMPLATE_COMPONENT (OUTPUT_ID, COMPONENT_TYPE, COMPONENT_NAME, CREATOR, LAST_UPDATER)
VALUES (NULL, 'commerceCard', '테스트 컴포넌트(carousel > listCard > 1)', 'admin', 'admin') -- carousel item 에 해당하는 component 의 경우 output_id = null
;

INSERT INTO SKILL_RES_V1_TEMPLATE_COMPONENT (OUTPUT_ID, COMPONENT_TYPE, COMPONENT_NAME, CREATOR, LAST_UPDATER)
VALUES (NULL, 'commerceCard', '테스트 컴포넌트(carousel > listCard > 2)', 'admin', 'admin') -- carousel item 에 해당하는 component 의 경우 output_id = null
;

-- 11.4. SKILL_RES_V1_TEMPLATE_CAROUSEL , SKILL_RES_V1_TEMPLATE_LISTCARD , SKILL_RES_V1_TEMPLATE_LISTCARD_LISTITEM
INSERT INTO SKILL_RES_V1_TEMPLATE_CAROUSEL (COMPONENT_ID, CARD_TYPE, HEADER_TITLE, HEADER_DESC, HEADER_THUMB, CREATOR, LAST_UPDATER)
VALUES (UNHEX('050E7910F3D711EEB5380A48BC1A5EE1'), 'listCard', '테스트 헤더 제목', '테스트 헤더 설명입니다.', 'http://localhost:8080/resources/img/test.jpg', 'admin', 'admin')
;

INSERT INTO SKILL_RES_V1_TEMPLATE_LISTCARD  (CAROUSEL_ID, COMPONENT_ID, CARD_ORD, CREATOR, LAST_UPDATER)
VALUES (UNHEX('61A1C408F3D711EEB5380A48BC1A5EE1'), UNHEX('0E5F0E38F3D711EEB5380A48BC1A5EE1'), 1, 'admin', 'admin')  -- carousel item 에 해당하는 component card 의 경우 carousel_id 값이 필
;

INSERT INTO SKILL_RES_V1_TEMPLATE_LISTCARD (CAROUSEL_ID, COMPONENT_ID, CARD_ORD, CREATOR, LAST_UPDATER)
VALUES (UNHEX('61A1C408F3D711EEB5380A48BC1A5EE1'), UNHEX('0F75ACACF3D711EEB5380A48BC1A5EE1'), 2, 'admin', 'admin')  -- carousel item 에 해당하는 component card 의 경우 carousel_id 값이 필
;

INSERT INTO SKILL_RES_V1_TEMPLATE_LISTCARD_LISTITEM (LISTITEM_ORD, COMPONENT_ID, HEADER_YN, TITLE, `DESC`, IMG_URL, ACTION, MESSAGE_TEXT, CREATOR, LAST_UPDATER)
VALUES (1, UNHEX('0E5F0E38F3D711EEB5380A48BC1A5EE1'), 'N', '테스트 제목', '테스트 설명입니다.(carousel > listCard > 1)', 'http://localhost:8080/resources/img/test.jpg', 'message', '테스트 메시지 입니다.', 'admin', 'admin')
;

INSERT INTO SKILL_RES_V1_TEMPLATE_LISTCARD_LISTITEM (LISTITEM_ORD, COMPONENT_ID, HEADER_YN, TITLE, `DESC`, IMG_URL, ACTION, MESSAGE_TEXT, CREATOR, LAST_UPDATER)
VALUES (1, UNHEX('0F75ACACF3D711EEB5380A48BC1A5EE1'), 'N', '테스트 제목', '테스트 설명입니다.(carousel > listCard > 2)', 'http://localhost:8080/resources/img/test.jpg', 'message', '테스트 메시지 입니다.', 'admin', 'admin')
;

-- 11.5. SKILL_RES_V1_TEMPLATE_COMPONENT_BTN
INSERT INTO SKILL_RES_V1_TEMPLATE_COMPONENT_BTN (COMPONENT_ID, LABEL, ACTION, MESSAGE_TEXT, CREATOR, LAST_UPDATER)
VALUES (UNHEX('0E5F0E38F3D711EEB5380A48BC1A5EE1'), '테스트 라벨(listCard > 1)', 'message', '테스트 메시지 입니다.', 'admin', 'admin')
;

INSERT INTO SKILL_RES_V1_TEMPLATE_COMPONENT_BTN (COMPONENT_ID, LABEL, ACTION, MESSAGE_TEXT, CREATOR, LAST_UPDATER)
VALUES (UNHEX('0F75ACACF3D711EEB5380A48BC1A5EE1'), '테스트 라벨(listCard > 2)', 'message', '테스트 메시지 입니다.', 'admin', 'admin')
;

-- 11.6. SKILL_RES_V1_TEMPLATE_QRPL
INSERT INTO SKILL_RES_V1_TEMPLATE_QRPL (TEMPLATE_ID, LABEL, ACTION, MESSAGE_TEXT, CREATOR, LAST_UPDATER)
VALUES (UNHEX('E4071279F3D611EEB5380A48BC1A5EE1'), '테스트 라벨(carousel > listCard)', 'message', '테스트 메시지 입니다.', 'admin', 'admin')
;