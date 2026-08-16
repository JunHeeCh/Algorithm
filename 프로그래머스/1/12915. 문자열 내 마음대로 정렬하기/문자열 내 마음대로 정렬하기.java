import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        node[] arr = new node[strings.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = new node(strings[i], strings[i].charAt(n));
        }
        
        Arrays.sort(arr);
        
        for(int i=0; i<arr.length; i++){
            answer[i] = arr[i].word;
        }
        
        return answer;
    }
}

class node implements Comparable<node>{
    String word;
    char init;
    
    public node(String word, char init){
        this.word = word;
        this.init = init;
    }
    
    public int compareTo(node o){
        if(this.init != o.init){
            return Integer.compare(this.init, o.init);
        }
        return this.word.compareTo(o.word);
    }
}