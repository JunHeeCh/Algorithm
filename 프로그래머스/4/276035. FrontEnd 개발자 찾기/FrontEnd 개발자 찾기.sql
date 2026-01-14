select distinct d.id, d.email, d.FIRST_NAME, d.last_name
from DEVELOPERS as d
join SKILLCODES as s
on (s.code & d.SKILL_CODE) != 0
and s.CATEGORY like 'Front%'
order by id