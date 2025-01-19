import java.util.Scanner;

public class Main{
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        for (int b = 1; b<=a ; b++){
            int c = in.nextInt();
            int sum =0;
            for(int d = 1; d<=c ; d+=2){
                sum += d;
            }
            System.out.println(sum);
        }
    }
}