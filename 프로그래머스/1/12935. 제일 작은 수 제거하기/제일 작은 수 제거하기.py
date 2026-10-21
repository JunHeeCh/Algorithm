def solution(arr):
    answer = []
    if len(arr) == 1:
        return [-1]
    
    a = arr[0]
    for i in arr:
        if i < a:
            a = i
            
    for i in arr:
        if i != a:
            answer.append(i)
    return answer