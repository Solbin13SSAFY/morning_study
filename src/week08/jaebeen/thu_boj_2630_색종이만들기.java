package boj_2630_색종이만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br;
	
	static int[][] map;
	static int n;
	
	static int white;
	static int blue;
	
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		// 전체 종이 상태를 초기화 해준다.
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		chkColor(0,0,n);
		
		System.out.println(white+"\n"+blue);
	}
	
	
	static void chkColor(int x, int y, int len) {
		boolean flag = true;
		int color = map[y][x];
		// len의 길이에 해당하는 종이인지 검사
		loop:
		for(int i=x; i<x+len; i++) {
			for(int j=y; j<y+len; j++) {
				if(color != map[j][i]) {
					flag =  false;
					break loop;
				}
			}
		}
		
		// flag값이 true이면 len의 길이에 해당하는 종이++
		// flag값이 false이면 해당 구역(시작좌표부터 len의 범위)을 4등분, len을 반으로 줄여 탐색
		if(flag) {
			if(color == 1) {
				blue++;
			} else {
				white++;
			}
		} else {
			int newLen = len/2; 
			// 2사분면
			chkColor(x,y, newLen);
			// 1사분면
			chkColor(x+newLen,y, newLen);
			// 3사분면
			chkColor(x,y+newLen, newLen);
			// 4사분면
			chkColor(x+newLen,y+newLen, newLen);
		}
	}
}
