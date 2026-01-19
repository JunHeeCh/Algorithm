-- 코드를 작성해주세요

select year(DIFFERENTIATION_DATE) as year,s.maax-m.SIZE_OF_COLONY as YEAR_DEV, id
from ECOLI_DATA as m
join (
    select max(SIZE_OF_COLONY) as maax, year(DIFFERENTIATION_DATE) as year
    from ECOLI_DATA 
    group by year(DIFFERENTIATION_DATE)
) as s
on year(m.DIFFERENTIATION_DATE) = s.year
order by year, YEAR_DEV