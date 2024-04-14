
INSERT INTO SKILL_BUSI_V1_BLOCK_PROC
(
	BLOCK_ID
	, CONTEXT_ID
	, BLOCK_CODE
	, PROC_NAME
	, IN_CONTEXT_NAME
	, CREATOR
	, LAST_UPDATER
)
VALUES
(
	'6590ab5b193392115b5a7ff8'
	, UNHEX('0334AEA5F95111EEB5380A48BC1A5EE1')
	, 'FP_S01_B01'
	, 'S01_B01_테스트프로세스'
	, 'S01_B01_테스트콘텍스트'
	, 'admin'
	, 'admin'
)
;

INSERT INTO SKILL_BUSI_V1_BLOCK_PROC_UNIT
(
	PROC_ID
	, PROC_UNIT_NO
	, PROC_UNIT_CODE
	, PROC_UNIT_NAME
	, PROC_UNIT_TYPE
	, NEXT_PROC_UNIT_NO1
	, NEXT_PROC_UNIT_NO2
	, NEXT_PROC_UNIT_NO3
	, INTERFACE_CODE
	, CREATOR
	, LAST_UPDATER
)
VALUES
(
	UNHEX('6DDA2A18F99111EEB5380A48BC1A5EE1')
	, 1
	, 'FPPRTPL01'
	, 'FP_템플릿_01_테스트'
	, 'TPL'
	, NULL
	, NULL
	, NULL
	, NULL
	, 'admin'
	, 'admin'
)
;