def solution(dirs):
    
    s = set()
    
    now = (0,0)
    for dir in dirs:
        x,y = now
        if dir == 'U':
            y += 1
        elif dir == 'D':
            y -= 1
        elif dir == 'R':
            x += 1
        elif dir == 'L':
            x -= 1
            
        if x > 5 or x < -5 or y > 5 or y < -5:
            continue
        else:
            s.add((now, (x,y)))
            s.add(((x,y), now))
            now = (x,y)
    return len(s)/2