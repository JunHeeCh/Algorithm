import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        int idx = -1;
        
        switch(ext){
            case "code":
                idx = 0;
                break;
            case "date":
                idx = 1;
                break;
            case "maximum":
                idx = 2;
                break;
            case "remain":
                idx = 3;
                break;
        }
        
        List<int[]> list = new ArrayList();
        for(int i=0; i<data.length; i++){
            if(data[i][idx]<val_ext){
                list.add(data[i]);
            }
        }
        
        int[][] answer = new int[list.size()][4];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        switch(sort_by){
            case "code":
                idx = 0;
                break;
            case "date":
                idx = 1;
                break;
            case "maximum":
                idx = 2;
                break;
            case "remain":
                idx = 3;
                break;
        }
        
        final int sortIdx = idx;
        Arrays.sort(answer, (a, b)->Integer.compare(a[sortIdx],b[sortIdx]));
        return answer;
    }
}

class node{
    int code;
    int date;
    int maximum;
    int remain;
    
    public node(int code, int date, int maximum, int remain){
        this.code = code;
        this.date = date;
        this.maximum = maximum;
        this.remain = remain;
    }
}