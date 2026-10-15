def solution(a, b):
    answer = 0
    if a > b:
        c = a
        a = b
        b = c
    for i in range(a,b+1):
        answer = answer + i
    return answer