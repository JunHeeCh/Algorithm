import math
def solution(n):
    answer = math.sqrt(n)
    if answer == int(answer):
        return (answer+1)*(answer+1)
    return -1