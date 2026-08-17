package LoveBabbarTasks;

public class BitwiseOperator {
    static void main() {
//        int a = 5;  //0101
//        int b = 6;  //0110
//        System.out.println(a & b);  //0100 -> 4
//        System.out.println(a | b);  //0111 -> 7
//        System.out.println(a ^ b);  //0011 -> 3
//        System.out.println(~a);     //0101 -> flips -> 1010 -> 1 is indicating -ve -> It gives -6 -> Do 2's complement to get 6
//
//        int n = 5;
//        for (int i = 1; i<=34; i++){
//            n=n<<1;                         //Left Shift by 1 (simply every number will get multiplied by 2 until one from binary comes at the most significant bit then the number becomes -ve and after 1 shifts and no 1 is there then every number after that will get us 0. Here after 32 (cuz of int) we will get 0)
//            System.out.println(n);
//            System.out.println();
//        }
//        System.out.println(3<<2);       //3 muliplied by 2 power 2 -> 3*4 -> 12
//
//
//        int m = 100;
//        for (int i = 1; i<=10; i++){
//            m=m>>1;                         //Right Shift by 1 (simply every number will get divided by 2 until one from binary comes in last then after 1 shifts and no 1 is there then every number after that will get us 0)
//            System.out.println(m);
//            System.out.println();
//        }
//        System.out.println(16>>2);      //divided by 2 power 2 -> 16/4 -> 4



//        Even or Odd
//        Every even number will have 0 in the end in binary form.
//        Every odd number will have 1 in the end in binary form.
//        int n = 5;
//        if ((n&1)==0){
//            System.out.println("Even");
//        } else {
//            System.out.println("Odd");
//        }


//        Set Bit Count
//        int x = 5;
//        int count = 0;
//        while(x!=0){
//            if ((x&1)!=0){
//                count++;
//            }
//            x=x>>1;
//        }
//        System.out.println("Set bit count: " + count);


//        Power of 2
//        In every power of 2 like 1(2^0), 2(2^1 -> 00000001), 4(00000010), 8(00000100), 16(00001000), 32(00010000), 64(001000000), etc we will have only 1 set bit count in binary form.
//        int y = 16;
//        if ((y&(y-1))==0){
//            System.out.println("Power of 2");
//        } else {
//            System.out.println("Not a power of 2");
//        }


//        Swap two numbers using XOR
//        int i = 6;
//        int j = 5;
//        i = i^j;        //5^6
//        j = i^j;        //(5^6)^6 -> 6 will cancel each other -> 5
//        i = i^j;        //(5^6)^(5^6)^6 -> 5^6 will cancel each other -> 6
//        System.out.println(i);
//        System.out.println(j);



//        Find unique element (all other appear twice)
//        int[] arr = {4, 1, 2, 1, 2};
//        int unique = 0;
//        for (int num : arr) {
//            unique ^= num;
//        }
//        System.out.println(unique);     //4


//        Remove last set bit
//        int n =10;
//        System.out.println(n&(n-1));        //It will remove the last 1 set bit -> 8


//        Get last set bit
//        int n=10;
//        System.out.println(n&(-n));


//        Find missing number in array (using XOR)
//        int[] arr = {3, 0, 1};
//        int missing = arr.length;
//        for (int i = 0; i< arr.length; i++){
//            missing ^= i ^ arr[i];
//        }
//        System.out.println(missing);


//        Find two unique numbers (others appear twice)
//        int[] arr = {4, 1, 2, 1, 2, 5};
//        int xor = 0;
//        for (int num: arr){
//            xor ^= num;
//        }
//        int bit = xor & -xor;
//        int a = 0;
//        int b = 0;
//        for (int num: arr){
//            if ((num & bit)==0){
//                a ^= num;
//            } else {
//                b ^= num;
//            }
//        }
//        System.out.println(a);
//        System.out.println(b);


//        Check if number is power of 4
//        int n = 16;
//        boolean result = n>0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
//        System.out.println(result);


//        Convert decimal to binary manually
//        int n =13;
//        String binary = "";
//        while (n>0){
//            int remainder = n%2;
//            binary=remainder+binary;
//            n=n/2;
//        }
//        System.out.println(binary);


//        Implement fast exponentiation using bitwise
        int base = 2;
        int exp = 10;
        long result = 1;
        long b = base;
        while (exp>0){
            if ((exp&1)==1){
                result *= b;
            }
            b *= b;
            exp >>= 1;
        }
        System.out.println(result);
    }
}
