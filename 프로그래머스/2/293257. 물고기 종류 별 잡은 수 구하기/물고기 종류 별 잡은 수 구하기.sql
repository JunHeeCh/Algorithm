
select count(id) as FISH_COUNT,FISH_NAME
from FISH_NAME_INFO as a
join FISH_INFO as b
on a.FISH_TYPE=b.FISH_TYPE
group by a.FISH_NAME
order by FISH_COUNT desc
