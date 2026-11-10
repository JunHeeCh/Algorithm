def solution(A,B):
    answer = 0

    A.sort()
    B.sort()
    B.reverse()
    
    for i,j in zip(A,B):
        answer += i*j

    return answer