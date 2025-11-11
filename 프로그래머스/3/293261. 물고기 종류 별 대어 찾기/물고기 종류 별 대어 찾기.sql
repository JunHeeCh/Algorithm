-- 코드를 작성해주세요

SELECT ID, FISH_NAME, LENGTH
from FISH_INFO join FISH_NAME_INFO 
where FISH_INFO.FISH_TYPE = FISH_NAME_INFO.FISH_TYPE
    and (FISH_NAME_INFO.FISH_TYPE, length) in (
        select fish_type, max(length)
        from fish_info
        group by fish_type
    )
order by ID