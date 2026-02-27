import java.util.*;

class Solution {
    Set<Integer>[] arr = new HashSet[9];
    public int solution(int N, int number) {
        
        if(number == N) return 1;
        
        for(int i=1; i<9; i++){
            arr[i] = new HashSet();
        }
        
        arr[1].add(N);
        int num = N;
        
        for(int i=2; i<9; i++){
            num = num*10+N;
            arr[i].add(num);
            for(int j=1; j<=i/2; j++){
                //arr[j]랑 arr[(i-j)]의 조합
                find(i, j, i-j);
            }
            if(arr[i].contains(number)){
                return i;
            }
        }
        return -1;
    }
    
    public void find(int a, int b, int c){
        // arr[a].add를 통해서 arr[b]와 arr[c]의 조합을 추가해라
        for(int num1 : arr[b]){
            for(int num2 : arr[c]){
                arr[a].add(num1+num2);
                arr[a].add(num1-num2);
                arr[a].add(num2-num1);
                arr[a].add(num1*num2);
                if(num2 != 0){
                    arr[a].add(num1/num2);
                }
                if(num1 != 0){
                    arr[a].add(num2/num1);
                }
            }
        }
    }
}