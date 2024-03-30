-- 5. commerceCard
-- 5.1. SKILL_RES_V1_TEMPLATE
INSERT INTO SKILL_RES_V1_TEMPLATE (BLOCK_ID, BLOCK_CODE, TEMPLATE_NAME, CREATOR, LAST_UPDATER)
VALUES ('6590ab5b193392115b5a7ff8', 'FP_S01_B01', '테스트 템플릿(single commerceCard)', 'admin', 'admin')
;

-- 5.2. SKILL_RES_V1_TEMPLATE_OUTPUT
INSERT INTO SKILL_RES_V1_TEMPLATE_OUTPUT (TEMPLATE_ID, OUTPUT_ORD, OUTPUT_NAME, CREATOR, LAST_UPDATER)
VALUES (UNHEX('64C3A144EE8511EEB5380A48BC1A5EE1'), 1, '테스트 아웃풋(single commerceCard)', 'admin', 'admin')
;

-- 5.3. SKILL_RES_V1_TEMPLATE_COMPONENT
INSERT INTO SKILL_RES_V1_TEMPLATE_COMPONENT (OUTPUT_ID, COMPONENT_TYPE, COMPONENT_NAME, CREATOR, LAST_UPDATER)
VALUES (UNHEX('748AC60CEE8511EEB5380A48BC1A5EE1'), 'commerceCard', '테스트 컴포넌트(single commerceCard)', 'admin', 'admin')
;

-- 5.4. SKILL_RES_V1_TEMPLATE_COMMERCECARD
INSERT INTO SKILL_RES_V1_TEMPLATE_COMMERCECARD (COMPONENT_ID, TITLE, `DESC`, PRICE, CURRENCY, DISCOUNT, DISCOUNT_RATE, DISCOUNTED_PRICE, THUMB_IMG_URL, CREATOR, LAST_UPDATER)
VALUES (UNHEX('7AD3851FEE8511EEB5380A48BC1A5EE1'), '테스트 타이틀', '테스트 상세 설명입니다.', '10000', 'won', 1000, 10, 9000, 'http://localhost:8080/resources/img/test.jpg', 'admin', 'admin')
;

-- 5.5. SKILL_RES_V1_TEMPLATE_COMPONENT_BTN
INSERT INTO SKILL_RES_V1_TEMPLATE_COMPONENT_BTN (COMPONENT_ID, LABEL, ACTION, MESSAGE_TEXT, CREATOR, LAST_UPDATER)
VALUES (UNHEX('7AD3851FEE8511EEB5380A48BC1A5EE1'), '테스트 라벨(commerceCard)', 'message', '테스트 메시지 입니다.', 'admin', 'admin')
;

-- 5.6. SKILL_RES_V1_TEMPLATE_QRPL
INSERT INTO SKILL_RES_V1_TEMPLATE_QRPL (TEMPLATE_ID, LABEL, ACTION, MESSAGE_TEXT, CREATOR, LAST_UPDATER)
VALUES (UNHEX('64C3A144EE8511EEB5380A48BC1A5EE1'), '테스트 라벨(commerceCard)', 'message', '테스트 메시지 입니다.', 'admin', 'admin')
;
