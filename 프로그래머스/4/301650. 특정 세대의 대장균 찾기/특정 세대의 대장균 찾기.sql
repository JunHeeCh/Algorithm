-- 코드를 작성해주세요
select id
from ECOLI_DATA 
where PARENT_ID in(
    select id
    from ECOLI_DATA 
    where PARENT_ID in (
        select id
        from ECOLI_DATA 
        where PARENT_ID is null
    )
)
order by id




