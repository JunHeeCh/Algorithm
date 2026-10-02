def solution(num_list, n):
    answer = []
    a=0
    while a < len(num_list):
        answer.append(num_list[a])
        a += n
    return answer