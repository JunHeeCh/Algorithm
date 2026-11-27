answer = 0
def solution(numbers, target):
    global answer
    
    dfs(numbers, target, 0, 0)
    return answer

def dfs(numbers, target, idx, make):
    global answer
    if idx==len(numbers):
        if target==make:
            answer += 1
        return
    dfs(numbers, target, idx+1, make+numbers[idx])
    dfs(numbers, target, idx+1, make-numbers[idx])