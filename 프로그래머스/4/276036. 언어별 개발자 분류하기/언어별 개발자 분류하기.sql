-- 코드를 작성해주세요
select case
when d.SKILL_CODE & fe.CODE > 0 and d.SKILL_CODE & py.CODE > 0 then 'A'
when d.SKILL_CODE & cs.CODE > 0 then 'B'
when d.SKILL_CODE & fe.CODE > 0 then 'C'
end as grade, d.ID, d.EMAIL
from DEVELOPERS as d
left join (
    select sum(CODE) as code
    from SKILLCODES
    where CATEGORY like 'FRONT%'
) as fe on 1=1
left join SKILLCODES as cs
on cs.NAME = 'C#'
left join SKILLCODES as py
on py.NAME = 'Python'
WHERE
    (d.SKILL_CODE & fe.CODE > 0 and d.SKILL_CODE & py.CODE > 0)
    OR (d.SKILL_CODE & fe.CODE) > 0
    OR (d.SKILL_CODE & cs.CODE) > 0
order by 1,2