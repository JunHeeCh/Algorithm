SELECT a.hour AS HOUR, COUNT(b.ANIMAL_ID) AS COUNT
FROM (
    select level-1 hour
    from dual
    connect by level <= 24
) a
left join animal_outs b
on a.hour = TO_NUMBER(TO_CHAR(b.datetime, 'HH24'))
GROUP BY a.hour
ORDER BY a.hour;