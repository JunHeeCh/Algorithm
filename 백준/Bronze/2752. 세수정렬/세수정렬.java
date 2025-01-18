import java.util.Scanner;

public class Main{
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int temp = 0;
        if(a>b){
            temp = a;
            a = b;
            b = temp;
        }
        if (b>c){
            temp = c;
            c = b;
            b = temp;
        }
        if(a>b){
            temp = a;
            a = b;
            b = temp;
        }
        
        System.out.printf("%d %d %d", a,b,c);
    }
}