def solution(phone_book):
    answer = True
    
    phone_book.sort()
    
    for i,init in enumerate(phone_book):
        for j in range(i+1, len(phone_book)):
            check = phone_book[j][:len(init)]
            if int(check) > int(init):
                break
            if phone_book[j].startswith(init):
                return False
    return answer