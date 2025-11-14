


select CAR_ID, 
case
    when std = 1 then "대여중"
    else "대여 가능"
end as AVAILABILITY
from (
    SELECT CAR_ID, 
        min(case 
                when end_date >= Date('2022-10-16') and start_date <= Date('2022-10-16') then 1
                else 2
            end) as std 
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    group by car_id
) as t
order by car_id desc