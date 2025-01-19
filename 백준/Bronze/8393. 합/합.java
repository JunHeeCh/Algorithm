import java.util.Scanner;

public class Main{
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int sum = 0;
        for(int b = a ; b>=1 ; b--){
            sum = sum + b;
        }
        System.out.print(sum);
    }
}