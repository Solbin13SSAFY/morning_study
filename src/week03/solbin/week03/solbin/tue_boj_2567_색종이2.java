package week03.solbin;

import java.util.Scanner;
public class tue_boj_2567_색종이2 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int T=sc.nextInt();
		// 寃쎄퀎瑜� 怨좊젮�븯�뿬 �긽�븯醫뚯슦 �븳移몄뵫 �뒛由곕떎.
		boolean[][] arr = new boolean[102][102];
		int sum=0;
		for (int t=0;t<T;t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			for (int i=n;i<n+10;i++) {
				for (int j=m;j<m+10;j++) {
					arr[i][j]=true;
				}
			}
		}
		for (int i=0;i<100;i++) {
			for (int j=0;j<101;j++) {
                // 媛�濡쒕갑�뼢 �뒪罹�
				// �몮以� �븯�굹留� 1�씪 �븣 �몮�젅�뿉 1�쓣 �뜑�븳�떎.
				if (arr[j][i]^arr[j][i+1]) sum++;

                // �꽭濡쒕갑�뼢 �뒪罹�
				if (arr[i][j]^arr[i+1][j]) sum++;
			}
		}
		System.out.println(sum);
	}
}