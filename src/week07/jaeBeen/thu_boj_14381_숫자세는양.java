package boj_14381_숫자세는양;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static StringBuilder sb;
	static Set<Integer> set;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			sb = new StringBuilder();
			sb.append("Case #").append(tc).append(": ");
			set = new HashSet<>();
			
			int n = sc.nextInt();
			int next = 0;
			for(int i=1; i<=100; i++) {
				long tmp = n * i;
				
				String str = tmp + "";
				for(int j=0; j<str.length(); j++) {
					int num = Character.getNumericValue(str.charAt(j));
					set.add(num);
				}
				
				if(set.size() == 10) {
					next = i;
					break;
				}
			}
			if(next != 0) {
				sb.append(n*next);
			} else {
				sb.append("INSOMNIA");
			}
			System.out.println(sb);
		}
	}
}
