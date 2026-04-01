-- 코드를 입력하세요
SELECT ANIMAL_ID, name, to_char(DATETIME, 'YYYY-MM-DD') 날짜
from animal_ins
order by animal_id