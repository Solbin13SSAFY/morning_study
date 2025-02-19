package week04.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class thu_boj_1026_보물 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] b = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		// 문제에서 B 배열은 정렬하지 말라 했는데
		// 그냥 해버리면 되는거 아닌가?
		Arrays.sort(a);
		Arrays.sort(b);
		int sum = 0;
		for (int i=0;i<n;i++) {
			sum+=a[i]*b[n-i-1];
		}
			
		sb.append(sum);
		System.out.println(sb);
	}
}

