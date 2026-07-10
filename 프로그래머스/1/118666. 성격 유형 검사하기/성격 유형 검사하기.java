class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        int[] arr = new int[26];
        
        for(int i=0; i<survey.length; i++){
            if(choices[i]<4){
                arr[survey[i].charAt(0)-'A'] += 4-choices[i];
            }else if(choices[i]>4){
                arr[survey[i].charAt(1)-'A'] += choices[i]-4;
            }
        }
        
        String inst = arr['R'-'A'] >= arr['T'-'A'] ? "R":"T";
        answer += inst;
        inst = arr['C'-'A'] >= arr['F'-'A'] ? "C":"F";
        answer += inst;
        inst = arr['J'-'A'] >= arr['M'-'A'] ? "J":"M";
        answer += inst;
        inst = arr['A'-'A'] >= arr['N'-'A'] ? "A":"N";
        answer += inst;
        return answer;
    }
}