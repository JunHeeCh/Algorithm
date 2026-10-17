def solution(n):
    answer = sorted(list(str(n)))
    answer = [int(c) for c in answer]
    answer.reverse()
    return int("".join(map(str,answer)))
 