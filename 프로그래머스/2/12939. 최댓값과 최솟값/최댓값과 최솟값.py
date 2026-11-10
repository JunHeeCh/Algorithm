def solution(s):    
    nums = list(map(int, s.split()))
    mx = max(nums)
    mn = min(nums)
        
    return str(mn) + " "+ str(mx)