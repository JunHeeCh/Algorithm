import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] temp = br.readLine().trim().toCharArray();
        
        int[] alp = new int[26];
        
        for (int i = 0; i < temp.length; i++) {
            alp[temp[i]-'a']++;
             
        }
        
        for (int i = 0; i < alp.length; i++) {
             System.out.print(alp[i]+" ");
        }
        
        
    }
}