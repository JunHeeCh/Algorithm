-- 코드를 입력하세요
select extract(month from START_DATE) month, car_id, count(HISTORY_ID) records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where START_DATE >= date '2022-08-01' and START_DATE < date '2022-11-01' and
CAR_ID in (
    SELECT CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where START_DATE >= date '2022-08-01' and START_DATE < date '2022-11-01'
    group by CAR_ID
    having count(HISTORY_ID) >= 5
)
group by extract(month from START_DATE), car_id
having count(HISTORY_ID) > 0
order by month, car_id desc