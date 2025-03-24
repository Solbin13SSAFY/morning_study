import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
    // 일단 정렬
		Arrays.sort(arr);
		int[] dist = new int[n-1];
		int sum = 0;
    // 거리 배열을 생성
		for (int i=0;i<n-1;i++) {
			dist[i] = arr[i+1]-arr[i];
		}
    // 길이 순으로 정렬함
		Arrays.sort(dist);
		sum = arr[n-1]-arr[0];
    // 가장 긴 구간 k-1개를 제외시킴
		for (int i=n-2;i>=n-k&&i>=0;i--) {
			sum -= dist[i];
		}
		System.out.println(sum);
	}
}
