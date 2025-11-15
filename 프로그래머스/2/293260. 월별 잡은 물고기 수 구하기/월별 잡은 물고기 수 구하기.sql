
select count(id) as FISH_COUNT,month(time) as month
from fish_info
group by month(time)
having count(id) > 0
order by month