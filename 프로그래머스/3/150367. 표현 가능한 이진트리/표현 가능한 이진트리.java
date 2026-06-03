class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        // 하나하나의 number를 이진트리로 만들 수 있는지 여부에 따라 
        // 가능하면 1을, 아니면 0을 넣어라 
        
        for(int i=0; i<numbers.length; i++){
            answer[i] = cal(numbers[i]);
        }
        return answer;
    }
    
    public int cal(long number){
        String st = Long.toBinaryString(number);
        
        int n = 1;
        int sum = 0;
        
        while(sum<st.length()){
            sum += n;
            n *= 2;
        }
        
        int need = sum - st.length();
        // 해당 숫자가 완전 이진 트리의 조건을 만족하느냐 
        String test = "0".repeat(need)+st; 
        // 자식이 1이면 부모는 무조건 1이어야만 한다 
        // 이거 지금 L->N->R 순서대로 작성되어 있다
        
        /*
        길이가 n일 때, n/2가 부모노드, 0~{(n/2)-1}까지는 왼쪽 노드
        {(n/2)+1}~(n-1)까지가 오른쪽 노드이다 
        */
        char[] arr = test.toCharArray();
        if(check(arr, 0, arr.length-1)){
            return 1;
        }
        return 0;
    }
    
    public boolean check(char[] arr, int left, int right){ 
        if(left==right) return true;
        
        int mid = (left+right)/2;
        int leftMid = (left+mid-1)/2;
        int rightMid = (mid+1+right)/2;
        
        if(arr[leftMid]=='1' && arr[mid]=='0') return false;
        if(arr[rightMid]=='1' && arr[mid]=='0') return false;
        
        return check(arr, left, mid-1) && check(arr, mid+1, right);
        
    }
}