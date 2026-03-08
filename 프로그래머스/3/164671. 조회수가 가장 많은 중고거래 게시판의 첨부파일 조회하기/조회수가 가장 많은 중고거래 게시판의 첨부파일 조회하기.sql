-- 코드를 입력하세요
select '/home/grep/src/' || BOARD_ID || '/' || FILE_ID || FILE_NAME || FILE_EXT FILE_PATH
from USED_GOODS_FILE 
where BOARD_ID = (
    SELECT BOARD_ID
    from USED_GOODS_BOARD
    order by VIEWS desc
    fetch next 1 rows only
)
ORDER BY FILE_ID DESC
