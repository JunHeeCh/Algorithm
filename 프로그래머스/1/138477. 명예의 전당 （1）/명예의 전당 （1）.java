class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        int[] arr = new int[k];
        
        for(int i=0; i<score.length; i++){
            insert(arr, score[i]);
            answer[i] = arr[Math.min(k-1, i)];
        }
        return answer;
    }
    
    public void insert(int[] arr, int score){
        for(int i=0; i<arr.length; i++){
            if(score>=arr[i]){
                int temp = arr[i];
                arr[i] = score;
                score = temp;
            }
        }
    }
}