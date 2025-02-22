package boj_1193_분수찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		int i = 1;
		for(;n>0;i++) {
			n-=i;
		}
		if((i&1)==0) {
			sb.append(1-n).append("/").append(i+n-1);
		} else {
			sb.append(i+n-1).append("/").append(1-n);
		}
		System.out.println(sb);
	}
}
