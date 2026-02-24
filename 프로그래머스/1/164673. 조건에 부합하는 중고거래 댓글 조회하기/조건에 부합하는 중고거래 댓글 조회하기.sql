-- 코드를 입력하세요
SELECT b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, to_char(r.CREATED_DATE, 'yyyy-mm-dd') CREATED_DATE
from USED_GOODS_BOARD  b
join USED_GOODS_REPLY  r
on b.BOARD_ID = r.BOARD_ID
where b.CREATED_DATE >= date '2022-10-01' and b.CREATED_DATE < date '2022-11-01'
order by r.CREATED_DATE, b.TITLE