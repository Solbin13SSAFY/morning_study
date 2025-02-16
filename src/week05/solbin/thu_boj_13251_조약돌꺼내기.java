package week05.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class thu_boj_13251_조약돌꺼내기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int m = Integer.parseInt(br.readLine());
		int[] arr = new int[m];
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 각 색깔의 돌맹이 갯수를 세면서 전체 갯수도 센다
		for (int i = 0 ; i < m ; i++) {
			int input = Integer.parseInt(st.nextToken());
			arr[i] = input;
			sum += input;
		}
		int k = Integer.parseInt(br.readLine());
		double res = 0;
		
		// 각 색깔별로 조약돌을 하나씩 빼면서 확률을 계산한다
		for (int i = 0; i < m; i++) {
			int num = arr[i];
			int all = sum;
			double tmp = 1;
			for (int j = 0; j < k; j++) {
				tmp *= (double) num--/all--;
			}
			res += tmp;
		}
		System.out.println(res);
	}
}


