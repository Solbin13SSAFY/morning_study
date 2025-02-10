package week03.solbin;
import java.util.Scanner;
public class tue_boj_2563_색종이 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int T=sc.nextInt();
        // 諛곗뿴濡� ��硫� �떆媛꾨났�옟�룄媛� �겕吏�留� 100x100�쑝濡� �젣�븳�뤌�엳�뼱�꽌 愿쒖갖�쓣�벏
		boolean[][] arr = new boolean[100][100];
		int sum=0;
		for (int t=0;t<T;t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			for (int i=n;i<n+10;i++) {
				for (int j=m;j<m+10;j++) {
					if (!arr[i][j]) sum++;
					arr[i][j]=true;
				}
			}
		}
		System.out.println(sum);
	}
}