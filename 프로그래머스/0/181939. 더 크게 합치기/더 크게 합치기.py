def solution(a, b):
    answer = int(str(a)+str(b))
    if int(str(b)+str(a))>answer:
        answer = int(str(b)+str(a))
    return answer