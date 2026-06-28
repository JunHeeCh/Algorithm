class Solution {
    public String solution(String X, String Y) {
        
        int[] x = new int[10];
        int[] y = new int[10];
        
        char[] temp = X.toCharArray();
        for(int i=0; i<temp.length; i++){
            x[temp[i]-'0']++;
        }
        
        temp = Y.toCharArray();
        for(int i=0; i<temp.length; i++){
            y[temp[i]-'0']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=9; i>0; i--){
            int a = Math.min(x[i],y[i]);
            sb.repeat(i+"", a);
        }
        
        int a = Math.min(x[0],y[0]);
        if(a>0&&sb.isEmpty()){
            sb.append("0");
        }else{
            sb.repeat("0", a);
        }
        if(sb.isEmpty()){
            sb.append("-1");
        }
        
        return sb.toString();
    }
}