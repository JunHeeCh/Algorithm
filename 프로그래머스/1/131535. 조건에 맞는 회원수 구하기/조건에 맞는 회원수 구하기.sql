-- 코드를 입력하세요
SELECT count(*) USERS
from USER_INFO 
where JOINED >= date('2021-01-01') and JOINED < date('2022-01-01')
and age >=20 and age < 30