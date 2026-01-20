-- 코드를 작성해주세요
select ITEM_ID, ITEM_NAME, RARITY
from ITEM_INFO
where item_id in (
    select item_id
    from ITEM_TREE 
    where PARENT_ITEM_ID in (
        select item_id
        from ITEM_INFO 
        where rarity = 'rare'
    )
)
order by item_id desc




