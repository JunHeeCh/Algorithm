def solution(num_str):
    answer = 0
    # for s in num_str:
    #     answer += int(s)
        
    num = int(num_str)
    while num>0:
        answer += num%10
        num //= 10
    return answer