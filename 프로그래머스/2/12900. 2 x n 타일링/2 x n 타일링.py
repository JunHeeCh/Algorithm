def solution(n):
    
    li = [0,1,2]
    
    for i in range(3, n+1):
        li.append((li[i-1]+li[i-2])%1000000007)
    return li[n]