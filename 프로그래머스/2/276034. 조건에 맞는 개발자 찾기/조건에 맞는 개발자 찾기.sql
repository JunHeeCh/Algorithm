-- 코드를 작성해주세요
select distinct ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS d 
join SKILLCODES c
on c.name in ("Python", "C#") and (c.code&d.skill_code) = c.code
order by id