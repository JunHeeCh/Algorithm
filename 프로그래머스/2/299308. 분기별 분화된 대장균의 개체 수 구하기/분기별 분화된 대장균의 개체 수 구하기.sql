-- 코드를 작성해주세요

select QUARTER, COUNT(a.ID) as ECOLI_COUNT
from ECOLI_DATA as a
join (
    select 
        case 
            when Month(DIFFERENTIATION_DATE) >=1 && Month(DIFFERENTIATION_DATE) < 4 then "1Q"
            when Month(DIFFERENTIATION_DATE) >=4 && Month(DIFFERENTIATION_DATE) < 7 then "2Q"
            when Month(DIFFERENTIATION_DATE) >=7 && Month(DIFFERENTIATION_DATE) < 10 then "3Q"
            else "4Q"
        end as QUARTER, id
    from ECOLI_DATA
) as b
on a.id = b.id
group by QUARTER
order by QUARTER
