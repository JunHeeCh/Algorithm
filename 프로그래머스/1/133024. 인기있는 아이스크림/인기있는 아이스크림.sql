-- 코드를 입력하세요
SELECT FLAVOR
from FIRST_HALF 
group by flavor
order by sum(TOTAL_ORDER) desc, SHIPMENT_ID