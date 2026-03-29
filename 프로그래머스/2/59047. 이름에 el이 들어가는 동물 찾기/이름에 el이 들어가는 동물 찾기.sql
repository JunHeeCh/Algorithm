-- 코드를 입력하세요
SELECT ANIMAL_ID, name
from ANIMAL_INS
WHERE lower(NAME) LIKE '%el%'
and ANIMAL_TYPE = 'Dog'
order by name