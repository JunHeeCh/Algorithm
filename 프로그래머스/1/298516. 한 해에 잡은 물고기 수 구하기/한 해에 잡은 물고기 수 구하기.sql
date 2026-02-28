-- 코드를 작성해주세요
select count(id) as FISH_COUNT
from FISH_INFO 
where time >= '2021-01-01' and time < '2022-01-01'
