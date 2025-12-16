SELECT a.CATEGORY, sum(b.sales) as TOTAL_SALES
from book a
    join (
        select book_id, sales
        from book_sales
        where sales_date like "2022-01%") b
    on a.book_id = b.book_id
group by a.category
order by a.CATEGORY 
