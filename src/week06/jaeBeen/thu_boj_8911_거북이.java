package boj_8911_거북이;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int nowD = 0;
	
	static int minX;
	static int maxX;
	static int minY;
	static int maxY;
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			char[] arr = br.readLine().toCharArray();
			minX = 0;
			maxX = 0;
			minY = 0;
			maxY = 0;
			int x = 0;
			int y = 0;
			for(int j=0; j<arr.length; j++) {
				char c = arr[j];
				
				switch(c) {
					case 'F' :
						x += dx[nowD];
						y += dy[nowD];
						chkMinMax(x, y);
						break;
						
					case 'B' :
						x -= dx[nowD];
						y -= dy[nowD];
						chkMinMax(x, y);
						break;
						
					case 'L' :
						nowD = (nowD+3)%4;
						break;
					case 'R' :
						nowD = (nowD+1)%4;
						break;
				}
				
				
			}
			// x, y의 최대 최소값에 해당하는 범위의 사각형 넓이
			System.out.println((maxX-minX) * (maxY-minY));
			
		}
	}
	static void chkMinMax(int x, int y) {
		if(minX > x) {
			minX = x;
		} else if(x > maxX) {
			maxX = x;
		}
		
		if(minY > y) {
			minY = y;
		} else if(y > maxY) {
			maxY = y;
		}
	}
}
