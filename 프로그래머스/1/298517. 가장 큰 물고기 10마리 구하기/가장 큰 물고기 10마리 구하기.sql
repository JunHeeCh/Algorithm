-- 코드를 작성해주세요

select id, length
from FISH_INFO
where length > 10
order by LENGTH desc, id 
limit 10