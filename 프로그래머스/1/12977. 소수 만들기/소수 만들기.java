class Solution {
    static int res = 0;
    public int solution(int[] nums) {

        int[] pick = new int[3];
        makeThree(nums, pick, 0, 0);

        return res;
    }
    
    public boolean isOk(int num){
        for(int i = 2; i < num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    
    public void makeThree(int[] nums, int[] pick, int index, int idx){
        if(idx >= 3){
            int sum = 0;
            for(int i = 0; i < 3; i++){
                sum += pick[i];
            }
            if(isOk(sum)){
                res++;
            }
            return;
        }
        for(int i=index; i<nums.length; i++){
            pick[idx] = nums[i];
            makeThree(nums, pick, i+1, idx+1);
        }
    }
    
}