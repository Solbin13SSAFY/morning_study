package boj_16938_캠프준비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N; // 문제수
	static int L; // L < 난이도 합
	static int R; // 난이도 합 <= R
	static int X; // X <= 난이도 차이
	
	// 난이도 정보
	static int[] level;
	// 문제를 골랐는지 여부 확인을 위한 boolean 배열
	static boolean[] visited;
	
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		level = new int[N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			level[i] = Integer.parseInt(st.nextToken());
		}
		count = 0;
		choose(0,0);
		System.out.println(count);
	}
	
	static void choose(int idx, int size) {
		// 2문제 이상일때 가능한 조합인지 검사
		if(size >= 2) {
			
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int sum = 0;
			// 고른 것일 때 합, 최대, 최소 여부를 확인한다.
			for(int i=0; i<N; i++) {
				if(visited[i]) {
					sum += level[i];
					max = Math.max(max, level[i]);
					min = Math.min(min, level[i]);
				}
			}
			// 합이 L이상 R이하 / 최대, 최소의 차가 X이상이면 경우의 수 1 추가
			if(sum <= R && sum >= L && max-min >= X) {
				count++;
			} 
			// R을 초과하거나 N개를 모두 고른 경우라면 끝
			if(sum > R || size == N) {
				return;
			}
		}
		// 백트래킹 슛
		for(int i = idx; i<N; i++) {
			visited[i] = true;
			choose(i+1, size+1);
			visited[i] = false;
		}
	}
}
