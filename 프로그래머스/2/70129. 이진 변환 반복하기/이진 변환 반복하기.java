class Solution {
    public int[] solution(String s) {
        
        int count = 0;
		int zeros = 0;
		
		while(!s.equals("1")) {
			
			int zero = 0;
			char[] temp = s.toCharArray();
			
			for (int i = 0; i < temp.length; i++) {
				if(temp[i]=='0') {
					zero++;
				}
			}
			
			int num = temp.length-zero;
			zeros += zero;
			count++;
			zero = 0;
			s = Integer.toBinaryString(num);
			
		}

        int[] answer = {count , zeros};
        
        return answer;
    }
}