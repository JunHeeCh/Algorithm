def solution(myString, pat):
    word = ''
    for a in myString:
        if a=='A':
            word+='B'
        else:
            word+='A'
            
    if pat in word:
        return 1
    return 0