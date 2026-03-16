-- 코드를 입력하세요

select USER_ID, nickname, CITY || ' ' || STREET_ADDRESS1 || ' ' || STREET_ADDRESS2 전체주소, substr(tlno, 1, 3) || '-' || substr(tlno, 4, 4) || '-' || substr(tlno, 8, 4) 전화번호
from USED_GOODS_USER 
where USER_ID in (
    SELECT WRITER_ID
    FROM USED_GOODS_BOARD 
    GROUP BY WRITER_ID
    HAVING COUNT(BOARD_ID) >= 3
)
order by user_id desc