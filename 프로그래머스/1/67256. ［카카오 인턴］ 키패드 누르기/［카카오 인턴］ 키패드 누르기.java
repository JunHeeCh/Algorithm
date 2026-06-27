import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int[] left = new int[]{3,0};
        int[] right = new int[]{3,2};
        
        for(int i=0; i<numbers.length; i++){
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7){
                answer.append("L");
                left = cal(numbers[i]);
            }else if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9){
                answer.append("R");
                right = cal(numbers[i]);
            }else{
                int l = dist(left, cal(numbers[i]));
                int r = dist(right, cal(numbers[i]));
                if(l<r){
                    answer.append("L");
                    left = cal(numbers[i]);
                }else if(l>r){
                    answer.append("R");
                    right = cal(numbers[i]);
                }else{
                    if(hand.equals("left")){
                        answer.append("L");
                        left = cal(numbers[i]);
                    }else{
                        answer.append("R");
                        right = cal(numbers[i]);
                    }
                }
            }
        }
        
        return answer.toString();
    }
    
    public int[] cal(int num){
        int[] ans = new int[2];
        
        if(num==2){
            ans = new int[]{0,1};
        }else if(num==5){
            ans = new int[]{1,1};
        }else if(num==8){
            ans = new int[]{2,1};
        }else if(num==0){
            ans = new int[]{3,1};
        }
        
        else if(num==1){
            ans = new int[]{0,0};
        }else if(num==4){
            ans = new int[]{1,0};
        }else if(num==7){
            ans = new int[]{2,0};
        }
        
        else if(num==3){
            ans = new int[]{0,2};
        }else if(num==6){
            ans = new int[]{1,2};
        }else if(num==9){
            ans = new int[]{2,2};
        }
        return ans;
    }
    public int dist(int[] now, int[] num){        
        return Math.abs(now[0]-num[0])+Math.abs(now[1]-num[1]);
    }
}