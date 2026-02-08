-- 코드를 입력하세요
SELECT c.CAR_ID, c.CAR_TYPE, round(30*DAILY_FEE*(100-DISCOUNT_RATE)/100) as FEE
from CAR_RENTAL_COMPANY_CAR as c
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as d
    on d.DURATION_TYPE = '30일 이상'
    and c.CAR_TYPE = d.CAR_TYPE
where (c.CAR_TYPE = '세단' or c.CAR_TYPE = 'SUV')
    and c.car_id not in (
        select car_id
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
        where START_DATE <= '2022-11-30'
        and END_DATE >= '2022-11-01'
    )
    and round(30*DAILY_FEE*(100-DISCOUNT_RATE)/100) >= 500000
    and round(30*DAILY_FEE*(100-DISCOUNT_RATE)/100) < 2000000
order by FEE desc, CAR_TYPE, CAR_ID desc