def solution(skill, skill_trees):
    answer = 0
    
    for word in skill_trees:
        learned = "".join(i for i in word if i in skill)
        if skill.startswith(learned):
            answer += 1
            
    return answer