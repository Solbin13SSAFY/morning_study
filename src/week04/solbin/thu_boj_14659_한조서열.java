package week04.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class thu_boj_14659_�������� {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		int cnt = 0;
		int tmp = 0;
		tmp = arr[0];
		for (int i=1;i<n;i++) {
			// �ڱ⺸�� ���� ������ ������ ī��Ʈ �ø��� �ִ� ����
			if (arr[i]<tmp) {
				cnt++;
				max = Math.max(max, cnt);
			} else {
				// ���ų� ���� ������ ������ �� ������ ����Ž
				cnt = 0;
				tmp = arr[i];
			}
		}
		
		sb.append(max);
		System.out.println(sb);
	}
}
