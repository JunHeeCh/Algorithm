def solution(num_list):
    a=0
    b=0
    for i in num_list:
        if(i%2==0):
            a *= 10
            a += i
        else:
            b *= 10
            b += i
    return a+b