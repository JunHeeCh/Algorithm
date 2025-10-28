class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = null;
        
        brown -= 4;
        brown /= 2;
        
        // a+b = brown;
        // a*b = yellow;
        
        for(int a=1; a<brown; a++){
            int b = brown-a;
            if(a*b==yellow){
                answer = new int[]{b+2,a+2};
                break;
            }
        }
        return answer;
    }
}