import java.util.Scanner;
public class Main {
    
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        int[] arr = new int[n];

        func(arr, 0);


        System.out.print(ans);
    }

    public static void func(int[] arr , int idx){
        if(idx == arr.length){
            if(check(arr)){
                ans++;
            }
            return;
        }
        for(int i=1; i<=4; i++){
            arr[idx] = i;
            func(arr, idx+1);
        }
    }

    public static boolean check(int[] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==1) continue;
            if(arr[i]==2){
                if(i+1 >= arr.length || arr[i+1]!=2){
                    return false;
                }
                i++;
            }
            if(arr[i]==3){
                if(i+2 >= arr.length || arr[i+1]!=3 || arr[i+2]!=3){
                    return false;
                }
                i+=2;
            }
            if(arr[i]==4){
                if(i+3 >= arr.length || arr[i+1]!=4 || arr[i+2]!=4 || arr[i+3]!= 4){
                    return false;
                }
                i+=3;
            }
        }
        return true;
    }
}