-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME
from ANIMAL_INS 
where NAME like '%EL%'
and NAME like '%el%'
and ANIMAL_TYPE = 'DOG'
order by NAME