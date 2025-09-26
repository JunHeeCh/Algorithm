select ID, 
case when SIZE_OF_COLONY <= 100 then 'LOW'
    WHEN SIZE_OF_COLONY <= 1000 THEN 'MEDIUM'
    ELSE 'HIGH' END AS  SIZE
from ECOLI_DATA 
order by ID