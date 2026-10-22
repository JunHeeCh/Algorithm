def solution(s):
    
    if len(s)%2==0: #길이가 짝수 
        return s[len(s)//2-1:len(s)//2+1]
        
    return s[len(s)//2]