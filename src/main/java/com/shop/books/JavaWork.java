package com.shop.books;

import java.util.*;

public class JavaWork {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Set set = new HashSet();
        Map map = new HashMap();
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    //    scanner.nextDo
        scanner.close();

        if(N >= 0 && N <= 100){
            if(N%2 != 0){
                System.out.println("Weired");
            }else if(N >=2 && N <= 5){
                System.out.println("Not Weired");
            }else if( N >= 6 && N <= 20){
                System.out.println("Weired");
            } else if (N > 20){
                System.out.println("Not Weired");
            }

        }

    }
}
