import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int wanhoA = scores[0][0];
        int wanhoB = scores[0][1];
        int wanhoSum = wanhoA + wanhoB;
        
        Arrays.sort(scores, (a,b)->{
            if(a[0]!=b[0]) return b[0]-a[0];
            return a[1]-b[1];
        });
        
        int bmax = 0;
        
        List<node> list = new ArrayList();
        
        for(int i=0; i<scores.length; i++){
            int a = scores[i][0];
            int b = scores[i][1];
            
            if(b < bmax){
                if (a == wanhoA && b == wanhoB) return -1;
                continue;
            }
            bmax = b;
            
            if (a == wanhoA && b == wanhoB) {
                list.add(new node(a+b, 0, true));
            }else{
                list.add(new node(a+b, 0, false));
            }
        }
        
        list.sort((x,y)->{
            return Integer.compare(y.sum, x.sum);
        });
        
        for(int i=0; i<list.size(); i++){
            list.get(i).order = i+1;
            if(i>0 && list.get(i).sum == list.get(i-1).sum){
                list.get(i).order = list.get(i-1).order;
            }
            if(list.get(i).is){
                return list.get(i).order;
            }
        }
        
        return 0;
    }
}

class node{
    int sum;
    int order;
    boolean is;
    
    public node(int sum, int order, boolean flag){
        this.sum = sum;
        this.order = order;
        this.is = flag;
    }
}