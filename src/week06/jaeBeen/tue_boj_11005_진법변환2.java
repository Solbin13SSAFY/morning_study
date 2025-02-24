package boj_11005_진법변환2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int n = sc.nextInt();
		Stack<String> stack = new Stack<>();
		while(true) {
			// 0~9 이면 그냥 붙여주고
			// 10~35 이면 알파벳으로 변환
			int s = num / n;
			int r = num % n;
			stack.add(intToStr(r));
			if(s == 0) {
				break;
			}
			
			num = num / n;
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
	static String intToStr(int n) {
		if(n <= 9) {
			return n+"";
		}
		char alphabet = (char) ('A' + (n - 10));
		return alphabet+"";
	}
}
