import java.util.Scanner;

/**
 * @program: algorithm
 * @description: 请解析IP地址和对应的掩码，进行分类识别。
 * 要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
 * 所有的IP地址划分为 A,B,C,D,E五类
 * A类地址1.0.0.0~126.255.255.255;  B类地址128.0.0.0~191.255.255.255;
 * C类地址192.0.0.0~223.255.255.255;  D类地址224.0.0.0~239.255.255.255；
 * E类地址240.0.0.0~255.255.255.255
 * 私网IP范围是：  10.0.0.0～10.255.255.255  172.16.0.0～172.31.255.255  192.168.0.0～192.168.255.255
 * 子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
 * 注意二进制下全是1或者全是0均为非法
 * 注意： 1. 类似于【0.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时可以忽略
 * 2. 私有IP地址和A,B,C,D,E类地址是不冲突的
 * @author: Sunbuhui7
 * @create: 2020-03-15 10:32
 **/


public class TestIP {
    private static int a = 0;
    private static int b = 0;
    private static int c = 0;
    private static int d = 0;
    private static int e = 0;
    private static int error = 0;
    private static int p = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String input = sc.next();
            String[] address = input.split("~");
            String ip = address[0];
            String mask = address[1];
            getInfo(ip, mask);
        }
        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + error + " " + p);
    }

    private static void getInfo(String ip, String mask){
        String[] ipArr = ip.split("\\.");
        String[] maskArr = mask.split("\\.");
        if(ipArr.length !=4 || maskArr.length !=4){
            error++;
            return;
        }
        int[] ipInt = new int[4];
        int[] maskInt = new int[4];
        for(int i=0; i<4; i++){
            if(ipArr[i].equals(" ") || maskArr[i].equals(" ")){
                error++;
                return;
            }
            ipInt[i] = Integer.parseInt(ipArr[i]);
            maskInt[i] = Integer.parseInt(maskArr[i]);
            if( ipInt[i]>255 || maskInt[i]>255 ){
                error++;
                return;
            }
        }
        if( checkIpMask(ipInt, maskInt) ){
            int ipInt0 = ipInt[0];
            int ipInt1 = ipInt[1];
            if( ipInt0>=1 && ipInt0<=126 ){
                a++;
                if( ipInt0==10 )
                    p++;
            }else if( ipInt0>=128 && ipInt0<=191 ){
                b++;
                if( ipInt0==172 && ipInt1>=16 && ipInt1<=31 )
                    p++;
            }else if( ipInt0>=192 && ipInt0<=223 ){
                c++;
                if(  ipInt0==192 && ipInt1==168 )
                    p++;
            }else if( ipInt0>=224 && ipInt0<=239 ){
                d++;
            }else if( ipInt0>=240 && ipInt0<=255 )
                e++;
        }
    }

    private static boolean checkIpMask(int[] ipInt, int[] maskInt){
        if( checkMask(maskInt) == false ){
            error++;
            return false;
        }
        return true;
    }

    private static boolean checkMask(int[] maskInt){
        String s = "";
        for(int i = 0; i<4; i++){
            String str = Integer.toBinaryString( maskInt[i] );
            int pad = 8-str.length();
            if(str.length()<8){
                for(int j=0; j<pad; j++)
                    str = "0"+str;
            }
            s += str;
        }
        int index = s.indexOf("0");
        String temp = s.substring(index+1);
        if(temp.contains("1")){
            return false;
        }else
            return true;
    }

}