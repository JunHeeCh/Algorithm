-- 코드를 입력하세요
select CAR_ID
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where CAR_ID in (
    SELECT CAR_ID
    from CAR_RENTAL_COMPANY_CAR 
    where CAR_TYPE = '세단'
) and START_DATE like '2022-10-%' 
group by CAR_ID
order by CAR_ID desc

