-- 코드를 입력하세요
SELECT year(SALES_DATE) as year, month(SALES_DATE) as month, count(distinct(s.USER_ID)) as PURCHASED_USERS, ROUND(COUNT(DISTINCT s.USER_ID) /
        (SELECT COUNT(*) 
         FROM USER_INFO 
         WHERE joined LIKE '2021%')
    , 1) AS PURCHASED_RATIO
from ONLINE_SALE as s
join USER_INFO as u
on s.USER_ID = u.USER_ID
where u.joined like '2021%'
group by year(SALES_DATE), month(SALES_DATE)
order by 1,2