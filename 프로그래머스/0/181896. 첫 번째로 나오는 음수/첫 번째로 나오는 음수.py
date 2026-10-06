def solution(num_list):
    for i,a in enumerate(num_list):
        if a<0:
            return i
    return -1