class Solution {
    int maxP = 0;
    int maxS = 0;
    int[][] users;
    int[] emoticons;
    public int[] solution(int[][] users, int[] emoticons) {
        
        this.users = users;
        this.emoticons = emoticons;
        /*
        1. 가입자를 늘리고
        2. 판매액을 늘릴 것 
        
        n명의 사용자
        m개의 이모티콘 
        
        각 사용자는 일정 할인률 이상의 이모티콘을 모두 구매 
        해당 비용이 일정 가격 이상인 경우, 플러스 가입 
        
        1. 각 사용자가 플러스에 가입하려고 할 때의 할인률을 구하기 
        1-1. 이모티콘의 합과 해당 고객의 할인률을 고려할 때 가입할 수 있는 사용자인지를 판별
        1-2. 가입할 수 있다면 가입자 수 +1, 할인률 갱신 
        
        */
        
        int[] discount = new int[emoticons.length];
        dfs(discount, 0);
        
        int[] answer = new int[]{maxP,maxS};
        
        return answer;
    }
    
    public void dfs(int[] discount, int idx){
        if(idx == discount.length){
            cal(discount);
            return;
        }
        
        for(int i=10;i<50;i+=10){
            discount[idx] = i;
            dfs(discount, idx+1);
        }
    }
    
    public void cal(int[] discount){
        int people = 0;
        int sales = 0;
        
        for(int i=0;i<users.length;i++){
            int ratio = users[i][0];
            int price = users[i][1];
            int total = 0;
            for(int j=0;j<emoticons.length; j++){
                if(discount[j]>=ratio){
                    total += emoticons[j]*(100-discount[j])/100;
                }
            }
            if(total >= price){
                people++;
            }else{
                sales += total;
            }
        }
        
        if(maxP < people){
            maxP = people;
            maxS = sales;
        }else if(maxP==people){
            maxS = Math.max(maxS, sales);
        }
    }
}