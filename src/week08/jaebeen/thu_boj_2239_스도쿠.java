package boj_2239_스도쿠;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][] map = new int[9][9];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}

		game(0, 0);
	}

	static boolean game(int x, int y) {
		// idx = 8인 행까지 채웠다면 출력한다.
		if (x == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			return true;
		}
		// 지금 행 다 채웠으면 다음 행으로
		int nx = (y == 8) ? x + 1 : x;
		// 열을 1칸씩 이동
		int ny = (y + 1) % 9;
		// 숫자가 있는 칸이면 다음칸 찾아서 이동
		if (map[x][y] != 0) {
			return game(nx, ny);
		}
		// 채워야 하는 칸이라면 1부터 9까지 숫자중에 하나 씩 넣어보자
		for (int num = 1; num <= 9; num++) {
			// 숫자 하나 넣었을 때 유효한 답안이라면
			if (chkMap(x, y, num)) {
				// 그 숫자를 넣어주고
				map[x][y] = num;
				// 다음 게임으로
				if (game(nx, ny)) {
					return true;
				}
				// 다른 숫자를 넣기 위해 비워주자
				map[x][y] = 0;
			}
		}
		// 숫자를 다 넣어봐도 답이없으면 가망없음
		return false;
	}

	static boolean chkMap(int x, int y, int num) {
		// 행과 열에 같은 수가 있는지 확인
		for (int i = 0; i < 9; i++) {
			if (map[x][i] == num || map[i][y] == num)
				return false;
		}

		// 3x3 사각형에 같은 수가 있는지 확인
		int sx = (x / 3) * 3;
		int sy = (y / 3) * 3;
		for (int i = sx; i < sx + 3; i++) {
			for (int j = sy; j < sy + 3; j++) {
				if (map[i][j] == num) {
					return false;
				}
			}
		}

		return true;
	}
}
