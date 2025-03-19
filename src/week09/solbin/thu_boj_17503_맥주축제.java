import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] beer = new int[k][2];
		for (int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			beer[i][0] = Integer.parseInt(st.nextToken());
			beer[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(beer, new Comparator<int[]>() {
			@Override
			public int compare(int[]a,int[]b) {
				// 레벨 오름차순, 선호도 내림차순
				if (a[1]==b[1]) {
					return b[0]-a[0];
				} else {
					return a[1]-b[1];
				}
			}
		});
		long sum = 0;
		
		
		
		Queue<int[]> beerSet = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0]-b[0];
			}
		});
		
		for (int i=0;i<n;i++) {
			beerSet.add(beer[i]);
			sum+=beer[i][0];
		}
		
		if (sum>=m) {
			System.out.println(beer[n-1][1]);
			return;
		}
		
		for (int i=n;i<k;i++) {
			int[] first = beerSet.peek();
			if (beer[i][0]>first[0]) {
				sum+=(beer[i][0]-first[0]);
				beerSet.poll();
				beerSet.add(beer[i]);
				if (sum>=m) {
					System.out.println(beer[i][1]);
					return;
				}
			}
		}
		
		System.out.println(-1);
	}
}
