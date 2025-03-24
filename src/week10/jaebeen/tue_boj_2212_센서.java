package boj_2212_센서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		// 집중국이 센서의 수와 같거나 많으면 0
		if(n <= k) {
			System.out.println(0);
			return;
		}
		String[] censors = br.readLine().split(" ");
		
		int[] arr = new int[censors.length];
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(censors[i]);
		}
		// 입력받은 센서를 줄을 세운다.
		Arrays.sort(arr);
		// 줄세워둔 센서들을 일직선상 바로 뒤의 센서와의 거리를 구한다.
		int[] diff = new int[arr.length-1];
		for(int i=0; i<diff.length; i++) {
			diff[i] = arr[i+1] - arr[i];
		}
		// 센서간 거리를 오름차순으로 정렬
		Arrays.sort(diff);
		
		int result = 0;
		// 센서의 수 > 집중국의 수 -> 집중국 하나가 여러개의 센서를 연결해야 할 때
		// 센서간 거리의 차이가 최소가 되는 센서들을 집중국 하나가 연결하면 최소비용임
		for(int i=0; i<n-k; i++) {
			result += diff[i];
		}
		
		System.out.println(result);
	}
}
