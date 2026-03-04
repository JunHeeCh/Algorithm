-- 코드를 입력하세요
select *
from places
where host_id in (
    SELECT HOST_ID
    from PLACES 
    group by HOST_ID
    having count(id) > 1
)
order by 1

