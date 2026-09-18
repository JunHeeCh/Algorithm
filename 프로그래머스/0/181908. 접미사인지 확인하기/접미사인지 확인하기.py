def solution(my_string, is_suffix):
    length = len(is_suffix)
    if my_string[len(my_string)-length:] == is_suffix:
        return 1
    return 0