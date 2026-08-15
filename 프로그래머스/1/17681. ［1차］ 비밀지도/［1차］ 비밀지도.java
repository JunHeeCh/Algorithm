class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        // 어디 하나라도 벽은 전체에서도 벽
        // 벽은 1
        // or로 가야함
        
        for(int i=0; i<n; i++){
            String a = Integer.toBinaryString(arr1[i]);
            String b = Integer.toBinaryString(arr2[i]);
            if(a.length()!=n) {
            	a = "0".repeat(n-a.length())+a;
            }
            if(b.length()!=n) {
            	b = "0".repeat(n-b.length())+b;
            }
            String plus = new String();
            for(int j=0; j<n; j++){
                if(a.charAt(j)=='1' || b.charAt(j)=='1'){
                    plus += "#";
                }else{
                    plus += " ";
                }
            }
            answer[i] = plus;
        }
        return answer;
    }
}