def solution(s):
    s=s.lower()
    x,y=0,0
    for a in s:
        if a=='p':
            x+=1
        elif a=='y':
            y+=1
            
            
    if x==y:
        return True

    return False