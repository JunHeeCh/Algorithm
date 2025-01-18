import java.util.Scanner;

public class Main{
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n_0 = in.nextInt();
        int a = 1;
        while(n_0>0){
        String b = "odd";
        int n_1 = 3*n_0;
        int n_2 = (n_1+1)/2;
        if(n_0%2 == 0){
            n_2 = n_1/2;
        }
        int n_3 = 3*n_2;
        int n_4 = n_3/9;
        if(n_1%2 == 0){
            n_0 = 2*n_4;
            b="even";
        }
        else{
            n_0 = 2*n_4+1;
        }
        System.out.printf("%d. %s %d\n", a,b,n_4);
        n_0 = in.nextInt();
        a++;
        }
    }
}