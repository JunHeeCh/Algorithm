def solution(prices):
    answer = []
    
    length = len(prices)
    
    for i in range(length):
        #prices[i]를 체크할 차례
        cnt = 0
        for j in range(i+1, length):
            cnt += 1
            if prices[j]<prices[i]:
                # 값이 떨어졌어 
                break

        answer.append(cnt)
    
    return answer