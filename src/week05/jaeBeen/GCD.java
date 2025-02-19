package boj_9613_GCD합;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for(int i=0; i<n; i++) {
				nums[i] = sc.nextInt();
			}
			
			long sum = 0;
			for(int i=0; i<nums.length-1; i++) {
				for(int j=i+1; j<nums.length; j++) {
					int a = nums[i];
					int b = nums[j];
					sum += gcd(a,b);
				}
			}
			System.out.println(sum);
		}
	}
	static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b,a%b);
	}
}
