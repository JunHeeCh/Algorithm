
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 1초마다 x 만큼 회복
        // t초 회복 시 y 만큼 추가 회복 
        int time = 0;
        int max = health;
        
        for(int i=0; i<attacks.length; i++){
            int t = attacks[i][0]-time-1;
            time = attacks[i][0];

            int moc = t/bandage[0];
            health += t*bandage[1];
            health += moc*bandage[2];
            health = Math.min(health, max);
            
            health -= attacks[i][1];
            if(health<=0){
                return -1;
            }
        }

        return health;
    }
}