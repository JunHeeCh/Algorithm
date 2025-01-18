import java.util.Scanner;

public class Main{
	public static void main(String[] args){
       Scanner in = new Scanner(System.in);
        int a =in.nextInt();
        for(int b=1;b<=a;b++){
            int eat = in.nextInt();
            int alive = in.nextInt();
            if(eat>=alive){
                System.out.println("MMM BRAINS");
            }
            else{
                System.out.println("NO BRAINS");
            }
        }
        
    }
}