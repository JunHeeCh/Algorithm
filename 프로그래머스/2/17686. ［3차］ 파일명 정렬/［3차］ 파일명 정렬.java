import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];;
        
        file[] arr = new file[files.length];
        
        for(int i=0; i<files.length; i++){
            arr[i] = new file(i, "", 0);
            seperate(arr[i], files[i], i);
        }
        
        Arrays.sort(arr);
        
        for(int i=0; i<arr.length; i++){
            answer[i] = files[arr[i].no];
        }
        
        return answer;
    }
    
    public void seperate(file f, String name, int idx){
    int n = name.length();
    int i = 0;

    // HEAD: 첫 숫자 나오기 전까지 전부(공백/특수문자 포함)
    while (i < n && !Character.isDigit(name.charAt(i))) i++;
    String head = name.substring(0, i);

    // NUMBER: 연속된 숫자 최대 5자리
    int j = i;
    int cnt = 0;
    while (j < n && Character.isDigit(name.charAt(j)) && cnt < 5) {
        j++;
        cnt++;
    }

    f.head = head;
    f.num = Integer.parseInt(name.substring(i, j));
    f.no = idx;
}

}

class file implements Comparable<file>{
    int no;
    String head;
    int num;
    
    public file(int no, String head, int num){
        this.no = no;
        this.head = head;
        this.num = num;
    }
    
    public int compareTo(file o){
        if(!this.head.toUpperCase().equals(o.head.toUpperCase())){
            return this.head.compareToIgnoreCase(o.head);
        }
        if(this.num != o.num){
            return Integer.compare(this.num, o.num);
        }
        return Integer.compare(this.no, o.no); 
    }
}