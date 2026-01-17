
select c.ID, c.GENOTYPE, p.GENOTYPE as PARENT_GENOTYPE
from ECOLI_DATA as p
join ECOLI_DATA as c
on p.id = c.parent_id
where (c.GENOTYPE & p.GENOTYPE ) = p.GENOTYPE
order by c.id