-- 코드를 입력하세요
SELECT a.rest_id, a.rest_name, a.FOOD_TYPE, a.FAVORITES, a.ADDRESS, b.REV_SCORE
from REST_INFO A
join (
select REST_ID, round(avg(REVIEW_SCORE), 2) REV_SCORE
from REST_REVIEW
group by REST_ID
) B
ON A.REST_ID = B.REST_ID
WHERE SUBSTR(A.ADDRESS,0,2) = '서울'
order by b.REV_SCORE desc, 4 desc