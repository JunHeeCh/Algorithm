class Solution {
    public int solution(int[][] sizes) {

        int w = Math.max(sizes[0][0], sizes[0][1]);
        int h = Math.min(sizes[0][0], sizes[0][1]);
        
        for(int i=1; i<sizes.length; i++){
            int nw = Math.max(sizes[i][0], sizes[i][1]);
            int nh = Math.min(sizes[i][0], sizes[i][1]);
            
            w = Math.max(w,nw);
            h = Math.max(h,nh);
        }
        return w*h;
    }
}