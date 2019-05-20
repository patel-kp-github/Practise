package com.example.DS.questions;

//AAAABBCDDDDD output A3B2C1D5
public class Practise1 {
	public static void main1(String[] args) {
		String output = "";
		String input = "india";
		char[] arr = input.toCharArray();
		char a = arr[0];
		String tmp = String.valueOf(a);
		output = output.concat(tmp);
		System.out.println(output + " " + a);
		
	}

	public static void main2(String[] args) {

		String input = "AAAABBCDDDDD";
		String output = "";
		int count = 0;
		char[] arr = input.toCharArray();
		char prev = input.charAt(0);
		for (int i = 0; i < arr.length; i++) {
			char next = arr[i];

			if ((String.valueOf(next)).equals(String.valueOf(prev))) {
				count++;
				if (i == arr.length - 1) {
					String tmp = String.valueOf(prev);
					output = output.concat(tmp); 
					output.concat(String.valueOf(count));
					output += count;
				}
			} else {
				String tmp = String.valueOf(prev);
				output = output.concat(tmp); 
				output.concat(String.valueOf(count));
				output += count;
				count = 1;
			}
			prev = next;
		}
		System.out.println("output:" + output);
		// AAAABBCDDDDD output A3B2C1D5
		// output:A4B2C1D5
	}
	
	
	public static void main(String[] args) {
		
		
	}
}
