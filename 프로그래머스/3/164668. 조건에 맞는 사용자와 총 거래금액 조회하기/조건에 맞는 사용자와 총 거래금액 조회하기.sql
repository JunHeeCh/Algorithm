-- 코드를 입력하세요
SELECT u.user_id as USER_ID, u.nickname as NICKNAME, sum(price) as TOTAL_SALES
from used_goods_board b join USED_GOODS_USER u
where b.WRITER_ID = u.USER_ID and b.STATUS = 'done'
group by WRITER_ID
having sum(price) >= 700000
order by TOTAL_SALES asc