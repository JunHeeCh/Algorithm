SELECT t3.score, t2.emp_no, t2.emp_name, t2.position, t2.email
FROM HR_EMPLOYEES AS t2 
JOIN (
    SELECT emp_no, SUM(score) AS score
    FROM HR_GRADE
    WHERE year = 2022
    GROUP BY emp_no
    ORDER BY SUM(score) DESC
    LIMIT 1
) AS t3 ON t2.emp_no = t3.emp_no