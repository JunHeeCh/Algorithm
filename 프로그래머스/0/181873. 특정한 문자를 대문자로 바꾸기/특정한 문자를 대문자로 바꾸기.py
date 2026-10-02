def solution(my_string, alp):
    return my_string.replace(alp, chr(ord(alp)+ord('A')-ord('a')))