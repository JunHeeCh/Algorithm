#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int first = 0;
    int second = 1;
    
    int cnt = 2;

    while(cnt <= n){
        int temp = first + second;
        
        first = second;
        second = temp % 1234567;
        cnt++;
    }
    return second;
}