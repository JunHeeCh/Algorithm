import java.util.Scanner;

public class Main{
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int Line = in.nextInt();
        for(int a = 1 ; a<=Line ; a++){
            int one = in.nextInt();
            int two = in.nextInt();
            System.out.println(one + two);
        }
        
    }
}