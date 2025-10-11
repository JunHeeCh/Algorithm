class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = 2 * w + 1; // 기지국 하나가 커버하는 범위
        
        // 첫 번째 기지국 이전 구간
        int blank = stations[0] - w - 1;
        if(blank > 0) {
            answer += (blank + coverage - 1) / coverage; // 올림 계산
        }
        
        // 기지국 사이의 빈 구간들
        for(int i = 1; i < stations.length; i++) {
            blank = (stations[i] - w) - (stations[i-1] + w) - 1;
            if(blank > 0) {
                answer += (blank + coverage - 1) / coverage;
            }
        }
        
        // 마지막 기지국 이후 구간
        blank = n - (stations[stations.length - 1] + w);
        if(blank > 0) {
            answer += (blank + coverage - 1) / coverage;
        }
        
        return answer;
    }
}