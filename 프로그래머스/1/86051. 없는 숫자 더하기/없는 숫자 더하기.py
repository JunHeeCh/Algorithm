def solution(numbers):
    answer = 0
    for i in range(10):
        answer += i
        
    for num in numbers:
        answer -= num
    return answer