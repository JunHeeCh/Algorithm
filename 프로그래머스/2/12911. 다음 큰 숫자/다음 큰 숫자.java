class Solution {
    public int solution(int n) {
        
        int cnt1 = 0;
        
        char[] temp = Integer.toBinaryString(n).toCharArray();
        
        for(int i=0; i<temp.length; i++){
            if(temp[i]=='1'){
                cnt1++;
            }
        }
        
        while(true){
            n++;
            temp = Integer.toBinaryString(n).toCharArray();
            int cnt2 = 0;
            for(int i=0; i<temp.length; i++){
                if(temp[i]=='1'){
                    cnt2++;
                }
            }
            
            if(cnt2==cnt1){
                break;
            }
        }
        
        return n;
    }
}