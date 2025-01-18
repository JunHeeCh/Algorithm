import java.util.Scanner;

public class Main{
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        while(a>0 || b>0){
            if(a>b){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        a = in.nextInt();
        b = in.nextInt();
        
        }
            
        
    }
}