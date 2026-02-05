-- 코드를 입력하세요
SELECT ANIMAL_TYPE, count(ANIMAL_ID) as count
from ANIMAL_INS 
where ANIMAL_TYPE = 'Cat' or ANIMAL_TYPE = 'Dog' 
group by ANIMAL_TYPE
order by ANIMAL_TYPE