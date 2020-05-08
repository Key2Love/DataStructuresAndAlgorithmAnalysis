package 栈;

import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer x = in.nextInt();
        if (x == null) {
            return;
        }
        if (x%2==0){
            System.out.println(pow(2,x/2)*pow(2,x/2));
        }else {
            System.out.println(2*pow(2,((x-1)/2))*pow(2,((x-1)/2)));
        }

    }
    public static long pow(int num,int cishu){
        if (cishu==0){
            return 1;
        }
        if (cishu==1){
            return num;
        }
        if (cishu%2==0){
            return pow(2,cishu  /2)*pow(2,cishu  /2);
        }else {
            return 2*pow(2,((cishu-1)/2))*pow(2,((cishu-1)/2));
        }
    }
}
