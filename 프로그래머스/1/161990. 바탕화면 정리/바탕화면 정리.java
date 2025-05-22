import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        String[][] board = new String[wallpaper.length][];
        for(int i=0; i< wallpaper.length; i++){
            String[] temp = wallpaper[i].split("");
            board[i] = new String[temp.length];
            for(int j=0; j< temp.length; j++){
                board[i][j] = temp[j];
            }
        }
        
        
        
        int lux = wallpaper.length, luy = wallpaper[0].length(); // 최솟값은 최대값으로 초기화
        int rdx = 0, rdy = 0; // 최댓값은 0으로 초기화

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    lux = Math.min(lux, i);  // 가장 위쪽 x
                    luy = Math.min(luy, j);  // 가장 왼쪽 y
                    rdx = Math.max(rdx, i + 1);  // 가장 아래쪽 x + 1
                    rdy = Math.max(rdy, j + 1);  // 가장 오른쪽 y + 1
                }
            }
        }

        return new int[]{lux, luy, rdx, rdy};
    }
}