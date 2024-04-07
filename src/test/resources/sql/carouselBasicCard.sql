-- 9. carousel > basicCard
-- 9.1. SKILL_RES_V1_TEMPLATE
INSERT INTO SKILL_RES_V1_TEMPLATE (BLOCK_ID, BLOCK_CODE, TEMPLATE_NAME, CREATOR, LAST_UPDATER)
VALUES ('6590ab5b193392115b5a7ff8', 'FP_S01_B01', '테스트 템플릿(carousel > basicCard)', 'admin', 'admin')
;

-- 9.2. SKILL_RES_V1_TEMPLATE_OUTPUT
INSERT INTO SKILL_RES_V1_TEMPLATE_OUTPUT (TEMPLATE_ID, OUTPUT_ORD, OUTPUT_NAME, CREATOR, LAST_UPDATER)
VALUES (UNHEX('BC10E1FEF34211EEB5380A48BC1A5EE1'), 1, '테스트 아웃풋(carousel > basicCard)', 'admin', 'admin')
;

-- 9.3. SKILL_RES_V1_TEMPLATE_COMPONENT
INSERT INTO SKILL_RES_V1_TEMPLATE_COMPONENT (OUTPUT_ID, COMPONENT_TYPE, COMPONENT_NAME, CREATOR, LAST_UPDATER)
VALUES (UNHEX('D632373BF34211EEB5380A48BC1A5EE1'), 'carousel', '테스트 컴포넌트(carousel > basicCard)', 'admin', 'admin')
;

INSERT INTO SKILL_RES_V1_TEMPLATE_COMPONENT (OUTPUT_ID, COMPONENT_TYPE, COMPONENT_NAME, CREATOR, LAST_UPDATER)
VALUES (NULL, 'basicCard', '테스트 컴포넌트(carousel > basicCard > 1)', 'admin', 'admin') -- carousel item 에 해당하는 component 의 경우 output_id = null
;

INSERT INTO SKILL_RES_V1_TEMPLATE_COMPONENT (OUTPUT_ID, COMPONENT_TYPE, COMPONENT_NAME, CREATOR, LAST_UPDATER)
VALUES (NULL, 'basicCard', '테스트 컴포넌트(carousel > basicCard > 2)', 'admin', 'admin') -- carousel item 에 해당하는 component 의 경우 output_id = null
;

-- 9.4. SKILL_RES_V1_TEMPLATE_CAROUSEL , SKILL_RES_V1_TEMPLATE_BASICCARD
INSERT INTO SKILL_RES_V1_TEMPLATE_CAROUSEL (COMPONENT_ID, CARD_TYPE, HEADER_TITLE, HEADER_DESC, HEADER_THUMB, CREATOR, LAST_UPDATER)
VALUES (UNHEX('F026C3BAF34211EEB5380A48BC1A5EE1'), 'basicCard', '테스트 헤더 제목', '테스트 헤더 설명입니다.', 'http://localhost:8080/resources/img/test.jpg', 'admin', 'admin')
;

INSERT INTO SKILL_RES_V1_TEMPLATE_BASICCARD (CAROUSEL_ID, COMPONENT_ID, CARD_ORD, TITLE, `DESC`, THUMB, CREATOR, LAST_UPDATER)
VALUES (UNHEX('1BB8B83DF34311EEB5380A48BC1A5EE1'), UNHEX('F914BD5CF34211EEB5380A48BC1A5EE1'), 1, '테스트 제목1', '테스트 설명입니다.1', 'http://localhost:8080/resources/img/test.jpg', 'admin', 'admin')  -- carousel item 에 해당하는 component card 의 경우 carousel_id 값이 필
;

INSERT INTO SKILL_RES_V1_TEMPLATE_BASICCARD (CAROUSEL_ID, COMPONENT_ID, CARD_ORD, TITLE, `DESC`, THUMB, CREATOR, LAST_UPDATER)
VALUES (UNHEX('1BB8B83DF34311EEB5380A48BC1A5EE1'), UNHEX('FA0DA2E9F34211EEB5380A48BC1A5EE1'), 2, '테스트 제목2', '테스트 설명입니다.2', 'http://localhost:8080/resources/img/test.jpg', 'admin', 'admin')  -- carousel item 에 해당하는 component card 의 경우 carousel_id 값이 필
;

-- 9.5. SKILL_RES_V1_TEMPLATE_COMPONENT_BTN
INSERT INTO SKILL_RES_V1_TEMPLATE_COMPONENT_BTN (COMPONENT_ID, LABEL, ACTION, MESSAGE_TEXT, CREATOR, LAST_UPDATER)
VALUES (UNHEX('F914BD5CF34211EEB5380A48BC1A5EE1'), '테스트 라벨(basicCard > 1)', 'message', '테스트 메시지 입니다.', 'admin', 'admin')
;

INSERT INTO SKILL_RES_V1_TEMPLATE_COMPONENT_BTN (COMPONENT_ID, LABEL, ACTION, MESSAGE_TEXT, CREATOR, LAST_UPDATER)
VALUES (UNHEX('FA0DA2E9F34211EEB5380A48BC1A5EE1'), '테스트 라벨(basicCard > 2)', 'message', '테스트 메시지 입니다.', 'admin', 'admin')
;

-- 9.6. SKILL_RES_V1_TEMPLATE_QRPL
INSERT INTO SKILL_RES_V1_TEMPLATE_QRPL (TEMPLATE_ID, LABEL, ACTION, MESSAGE_TEXT, CREATOR, LAST_UPDATER)
VALUES (UNHEX('BC10E1FEF34211EEB5380A48BC1A5EE1'), '테스트 라벨(carousel > basicCard)', 'message', '테스트 메시지 입니다.', 'admin', 'admin')
;