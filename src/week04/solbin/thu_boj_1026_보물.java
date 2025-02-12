package week04.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class thu_boj_1026_���� {
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
		
		// �������� B �迭�� �������� ���� �ߴµ�
		// �׳� �ع����� �Ǵ°� �ƴѰ�?
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

