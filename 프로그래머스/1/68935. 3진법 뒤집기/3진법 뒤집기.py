def solution(n):
    res = toThree(n)
    res = res[::-1]
    return int(res,3)

def toThree(n):
    result = ''
    while n>0:
        n,r = divmod(n,3)
        result = str(r)+result
    return result or "0"