from collections import deque

def solution(cacheSize, cities):
    if cacheSize==0:
        return len(cities)*5
    answer = 0
    
    dq = deque() 
    s = set() 
        
    for city in cities:
        now = city.lower()
        if now in s:
            answer += 1
            dq.remove(now)
            dq.append(now)
            continue
        
        answer += 5
        if len(s) == cacheSize:
            rm = dq.popleft()
            s.remove(rm)
            
        dq.append(now)
        s.add(now)
    return answer