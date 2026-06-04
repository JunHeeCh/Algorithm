/*
t초 동안 붕대를 감으면 1초마다 x만큼 회복
t초 연속 성공 시 y만큼 추가 회복 


*/
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int time = bandage[0]; // 시전 시간
        int recovery = bandage[1]; // 초당 회복량
        int plusRecovery = bandage[2]; // 추가 회복량 
        
        int max = health;
        
        // health는 초기 체력 및 최대 체력
        
        health -= attacks[0][1]; // 처음 공격을 맞음 
        
        for(int i=1; i<attacks.length; i++){
            if(health<=0) {
                health = -1;
                break;
            }
            int attackTime = attacks[i][0];
            int damage = attacks[i][1];
            
            // 1. 이전 시간과 지금 시간동안 추가한 체력을 보충
            int diff = attacks[i][0]-attacks[i-1][0]-1;
            health += recovery*diff;
            diff /= time;
            health += diff*plusRecovery;
            if(health>max){
                health = max;
            }
            // 2. 공격받은 만큼 체력 감소 
            health -= damage;
        }
        
        if(health<=0) return -1;
        return health;
    }
}