-- 코드를 입력하세요


select MEMBER_NAME, REVIEW_TEXT, to_char(REVIEW_DATE, 'yyyy-mm-dd') REVIEW_DATE
from MEMBER_PROFILE a
join REST_REVIEW b
on a.MEMBER_ID = b.MEMBER_ID
where a.MEMBER_ID = (
    SELECT MEMBER_ID
    from REST_REVIEW
    group by MEMBER_ID
    order by count(REVIEW_ID) desc
    fetch first 1 row only
)
order by 3, 2