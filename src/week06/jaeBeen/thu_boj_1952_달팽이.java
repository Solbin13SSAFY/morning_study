package boj_1952_달팽이;

import java.util.Scanner;

public class Main {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] map;
	static int m;
	static int n;
	static int nowD = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		map = new boolean[m][n];
		int x = 0;
		int y = 0;
		map[y][x] = true;
		int count = 0;
		for(int i=0; i<m*n; i++) {
			int xx = x + dx[nowD]; 
			int yy = y + dy[nowD]; 
			
			if(i != (m*n)-1) {
				if(chkD(xx,yy)) {
					x = xx;
					y = yy;
				} else {
					count++;
					x += dx[nowD];
					y += dy[nowD];
				}
				map[y][x] = true;
			}
		}
		System.out.println(count);
	}
	static boolean chkD(int x, int y) {
		if(x<0||x>=n||y<0||y>=m || map[y][x]) {
			nowD = (nowD+1)%4;
			return false;
		}
		return true;
	}
}
