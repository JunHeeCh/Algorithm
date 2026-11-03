def solution(n, m):
    answer = [1]
    for i in range(1,min(n,m)+1):
        if n%i==0 and m%i==0:
            answer[0] = i
    
    for i in range(max(n,m), n*m+1):
        if i%n==0 and i%m==0:
            answer.append(i)
            break
    return answer