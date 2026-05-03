import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        // Please write your code here.
        int[] num = new int[n];
        func(num, k, 0);
    }

    public static void func(int[] num, int k, int idx){
        if(idx == num.length){
            for(int i=0; i<num.length; i++){
                System.out.print(num[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=1; i<=k; i++){
            num[idx] = i;
            func(num, k, idx+1);
        }
    }
}