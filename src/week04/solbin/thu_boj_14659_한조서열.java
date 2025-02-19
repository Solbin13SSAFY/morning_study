package week04.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class thu_boj_14659_한조서열 {
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
			// 자기보다 낮은 한조가 나오면 카운트 올리고 최댓값 갱신
			if (arr[i]<tmp) {
				cnt++;
				max = Math.max(max, cnt);
			} else {
				// 같거나 높은 한조가 나오면 그 한조로 갈아탐
				cnt = 0;
				tmp = arr[i];
			}
		}
		
		sb.append(max);
		System.out.println(sb);
	}
}
