def solution(numbers):
    answer = 0
    
    s = set()
    li = []
    for i in numbers:
        li.append(i)
        
    visited = [False]*len(li)
    
    make(s, li, visited, "")
    
    for num in s:
        if check(num):
            answer += 1
    return answer

def check(num):
    if num < 2: return False
    for i in range(2, num):
        if num%i==0:
            return False
    return True

def make(s, li, visited, num):
    for i, res in enumerate(visited):
        if not res:
            tmp = num + li[i]
            visited[i] = True
            s.add(int(tmp))
            make(s,li,visited, tmp)
            visited[i] = False