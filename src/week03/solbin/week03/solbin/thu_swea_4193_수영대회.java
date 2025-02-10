package week03.solbin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class thu_swea_4193_수영대회 {
	final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int n;
	private static int min;
	static int fx;
	static int fy;
	static Queue<int[]> queue;
	static int[][] arr;
	
	public static void main (String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t= 1; t<= T; t++) {
			System.out.println("#" + t + " " + run());
		}
	}
	
	private static String run() throws IOException {
		n = Integer.parseInt(br.readLine());
		min = -1; // �룄李� 遺덇��씤 寃쎌슦 -1 異쒕젰
		queue = new LinkedList<>(); // �걧 珥덇린�솕
		StringTokenizer st;
		arr = new int[n][n];
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		fx = Integer.parseInt(st.nextToken());
		fy = Integer.parseInt(st.nextToken());
		
		queue.add(new int[]{x,y,0});
		while (!queue.isEmpty()) {
			int[] item = queue.poll();
			int xx = item[0];
			int yy = item[1];
			int tt = item[2];
			
			// �룄李⑺븿
			if (xx == fx && yy == fy) {
				min=tt;
				break;
			}
			
			// �긽�븯醫뚯슦濡� ��吏곸씪 �븣 踰쎌씠 �뾾�떎硫� �떆媛꾩쓣 �뜑�븯怨� �븳移� �씠�룞
			int[] dx = new int[] {-1,1,0,0};
			int[] dy = new int[] {0,0,-1,1};
			for (int i=0;i<4;i++) {
				if (bound(xx+dx[i],yy+dy[i])) {
					//�냼�슜�룎�씠媛� �뿴由ъ� �븡�븯�쑝硫� �븳�꽩 湲곕떎由�. �떆媛꾩쓣 �뜑�븯怨� �떎�떆 �걧�뿉 異붽��븿
					if (arr[xx+dx[i]][yy+dy[i]] == 2 && tt % 3 != 2) {
						queue.add(new int[] {xx,yy,tt+1});
						continue;
					} else {
						arr[xx][yy] = 1;
						queue.add(new int[] {xx+dx[i],yy+dy[i],tt+1});
					}
				}
			}
		}
		return String.valueOf(min);
	}
	
	// �뀒�몢由щ굹 踰쎌뿉 留됲삍�뒗吏� �뙋�떒
	private static boolean bound(int x,int y) {
		return (!(x<0||x>=n||y<0||y>=n)&&arr[x][y]!=1);
	}
}