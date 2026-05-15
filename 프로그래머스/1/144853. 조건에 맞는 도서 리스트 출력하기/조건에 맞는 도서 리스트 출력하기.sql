-- 코드를 입력하세요
SELECT BOOK_ID, PUBLISHED_DATE
from book
where PUBLISHED_DATE >= date '2021-01-01' and PUBLISHED_DATE < date '2022-01-01' and CATEGORY = '인문'
order by PUBLISHED_DATE