-- 코드를 입력하세요
select CATEGORY, SUM(TOTAL) TOTAL_SALES
from BOOK a
join (
    SELECT BOOK_ID, SUM(SALES) AS TOTAL
    from BOOK_SALES 
    where SALES_DATE >= date '2022-01-01' and SALES_DATE < date '2022-02-01'
    GROUP BY BOOK_ID
) b
on a.BOOK_ID = b.BOOK_ID
group by CATEGORY
ORDER BY CATEGORY
