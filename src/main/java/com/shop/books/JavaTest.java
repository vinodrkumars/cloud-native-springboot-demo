package com.shop.books;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class JavaTest {
	
	public static void main(String arg[]) {

		// Create an encoder with strength 16
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		String result = encoder.encode("myPassword");
		System.out.println(result);
		System.out.println(encoder.matches("myPassword", result));

		int[] arr =  {1,36,1,36,1,1};
		int maxValue = 0;
		
		// This is solution I was suggesting 
		for(int i =0; i < arr.length; i++) {
			
			for(int j=i+1; j< arr.length-1; j++) {
				maxValue = Math.max(maxValue, ( Math.min(arr[i], arr[j]) * (j-i) ) );
			}
		}
		System.out.println("Solution-1: Max value: " + maxValue);
		
		int i = 0;
		int j = arr.length-1;
		int maxVal = 0;
		// This is solution Vijay was suggesting 
		while(i<j) {
			System.out.println(i +" " +j);
			maxVal = Math.max(maxVal,  (Math.min(arr[i], arr[j])*(j-i)));
			i++;
			j--;
		}
		System.out.println("Solution-2: Max value: " + maxVal);
	}

}
