select ID, (select count(*)
    from ECOLI_DATA
    where p1.ID = PARENT_ID) as CHILD_COUNT
from ECOLI_DATA as p1
order by ID