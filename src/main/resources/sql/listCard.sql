-- 6. listCard
-- 6.1. SKILL_RES_V1_TEMPLATE
INSERT INTO SKILL_RES_V1_TEMPLATE (BLOCK_ID, BLOCK_CODE, TEMPLATE_NAME, CREATOR, LAST_UPDATER)
VALUES ('6590ab5b193392115b5a7ff8', 'FP_S01_B01', '테스트 템플릿(single listCard)', 'admin', 'admin')
;

-- 6.2. SKILL_RES_V1_TEMPLATE_OUTPUT
INSERT INTO SKILL_RES_V1_TEMPLATE_OUTPUT (TEMPLATE_ID, OUTPUT_ORD, OUTPUT_NAME, CREATOR, LAST_UPDATER)
VALUES (UNHEX('048B8952EE9211EEB5380A48BC1A5EE1'), 1, '테스트 아웃풋(single listCard)', 'admin', 'admin')
;

-- 6.3. SKILL_RES_V1_TEMPLATE_COMPONENT
INSERT INTO SKILL_RES_V1_TEMPLATE_COMPONENT (OUTPUT_ID, COMPONENT_TYPE, COMPONENT_NAME, CREATOR, LAST_UPDATER)
VALUES (UNHEX('299F9C5AEE9211EEB5380A48BC1A5EE1'), 'itemCard', '테스트 컴포넌트(single listCard)', 'admin', 'admin')
;

-- 6.4. SKILL_RES_V1_TEMPLATE_LISTCARD , SKILL_RES_V1_TEMPLATE_LISTCARD_LISTITEM
INSERT INTO SKILL_RES_V1_TEMPLATE_LISTCARD (COMPONENT_ID, CREATOR, LAST_UPDATER)
VALUES (UNHEX('49CAD90CEE9211EEB5380A48BC1A5EE1'), 'admin', 'admin')
;

INSERT INTO SKILL_RES_V1_TEMPLATE_LISTCARD_LISTITEM (LISTITEM_ORD, COMPONENT_ID, HEADER_YN, TITLE, `DESC`, IMG_URL, ACTION, MESSAGE_TEXT, CREATOR, LAST_UPDATER)
VALUES (1, UNHEX('49CAD90CEE9211EEB5380A48BC1A5EE1'), 'Y', '테스트 제목', '테스트 설명입니다.', 'http://localhost:8080/resources/img/test.jpg', 'message', '테스트 메시지 입니다.', 'admin', 'admin')
;

INSERT INTO SKILL_RES_V1_TEMPLATE_LISTCARD_LISTITEM (LISTITEM_ORD, COMPONENT_ID, HEADER_YN, TITLE, `DESC`, IMG_URL, ACTION, MESSAGE_TEXT, CREATOR, LAST_UPDATER)
VALUES (1, UNHEX('49CAD90CEE9211EEB5380A48BC1A5EE1'), 'N', '테스트 제목', '테스트 설명입니다.', 'http://localhost:8080/resources/img/test.jpg', 'message', '테스트 메시지 입니다.', 'admin', 'admin')
;

-- 6.5. SKILL_RES_V1_TEMPLATE_COMPONENT_BTN
INSERT INTO SKILL_RES_V1_TEMPLATE_COMPONENT_BTN (COMPONENT_ID, LABEL, ACTION, MESSAGE_TEXT, CREATOR, LAST_UPDATER)
VALUES (UNHEX('49CAD90CEE9211EEB5380A48BC1A5EE1'), '테스트 라벨(listCard)', 'message', '테스트 메시지 입니다.', 'admin', 'admin')
;

-- 6.6. SKILL_RES_V1_TEMPLATE_QRPL
INSERT INTO SKILL_RES_V1_TEMPLATE_QRPL (TEMPLATE_ID, LABEL, ACTION, MESSAGE_TEXT, CREATOR, LAST_UPDATER)
VALUES (UNHEX('048B8952EE9211EEB5380A48BC1A5EE1'), '테스트 라벨(listCard)', 'message', '테스트 메시지 입니다.', 'admin', 'admin')
;