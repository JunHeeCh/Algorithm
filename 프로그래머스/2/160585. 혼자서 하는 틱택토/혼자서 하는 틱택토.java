class Solution {
    public int solution(String[] board) {
        // 둘 다 우승을 하거나 (이건 틀린 거)
        // O가 X보다 1개 많거나 동일해야 하며 (이게 맞는거)
        
        int[][] map = new int[3][3]; // O는 1, X는 -1, 나머지는 빈칸
        
        int plus = 0, minus = 0;
        
        for(int i=0; i<3; i++){
            char[] temp = board[i].toCharArray();
            for(int j=0; j<3; j++){
                if(temp[j]=='O'){
                    map[i][j] = 1;
                    plus++;
                }else if(temp[j]=='X'){
                    map[i][j] = -1;
                    minus++;
                }
            }
        }
        
        if(plus - minus != 1 && plus != minus){
            return 0;
        }

        boolean flag1 = check(map,1);
        boolean flag2 = check(map, -1);
        if(flag1 && flag2){
            return 0;
        }
        
        if(flag1 && !flag2){
            if(plus == minus+1){
                return 1;
            }else{
                return 0;
            }
        }
        
        if(!flag1 && flag2){
            if(plus == minus){
                return 1;
            }else{
                return 0;
            }
        }
        return 1;
    }
    
    public boolean check(int[][] map, int num){

        for(int i=0; i<3; i++){
            int count = 0;
            for(int j=0; j<3; j++){
                if(map[i][j]==num){
                    count++;
                }
            }
            if(count==3){
                return true;
            }
        }
        
        for(int j=0; j<3; j++){
            int count = 0;
            for(int i=0; i<3; i++){
                if(map[i][j]==num){
                    count++;
                }
            }
            if(count==3){
                return true;
            }
        }
        
        if(map[0][0]==num && map[1][1]==num && map[2][2]==num){
            return true;
        }
        if(map[0][2]==num && map[1][1]==num && map[2][0]==num){
            return true;
        }
        return false;
    }
}