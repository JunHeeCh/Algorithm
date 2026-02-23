-- 코드를 작성해주세요
select count(id) as COUNT
from ECOLI_DATA
where GENOTYPE & (1<<1) = 0 and
(GENOTYPE & (1<<0) > 0 or GENOTYPE & (1<<2) > 0)
