answer = 0
flag = False

def solution(word): 
    global answer, flag
    answer = 0
    flag = False
    make(['A', 'E', 'I', 'O', 'U'], '', word)
    return answer

def make(li, made, word):
    global answer, flag
    
    if made == word:
        flag = True
        return
    if len(made)>=5 or flag:
        return
    for i in li:
        if flag: break
        answer += 1
        make(li, made+i, word)