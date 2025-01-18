import java.util.Scanner;

public class Main{
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = 0;
        if(a%400==0){
            b=1;
        }
        else if(a%4==0 && a%100!=0){
            b=1;
        }
        System.out.print(b);
    }
}