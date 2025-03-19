import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int n;
	static int m;
	static byte[][] room;
	final static int p = (1<<8);
	
	final static int[] dx = {-1,0,1,0};
	final static int[] dy = {0,-1,0,1};
	
	static List<int[]> cctv = new ArrayList<>();
	
	static int empty;
	static int wallCnt;
	
	static int min;
	
	static Set<long[]> visited = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		// 방 상태 입력
		room = new byte[n][m];
		empty = n*m;
		wallCnt = 0;
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<m;j++) {
				byte input = Byte.parseByte(st.nextToken());
				if (input>0&&input!=6) {
					// cctv input
					cctv.add(new int[] {i,j,input});
				} else if (input==6) {
					// wall input
					wallCnt++;
					room[i][j] = 6;
				}
			}
		}
		
		min = empty - wallCnt;
		
		back(0,0);
		System.out.println(min);
	}
	
	static void back(int idx, long status) {
		if (!visited.add(new long[] {status,idx})) return;
		else if (idx==cctv.size()) {
			min = Math.min(min, empty-wallCnt-Long.bitCount(status));
//			print(status);
			return;
		}
		int[] item = cctv.get(idx);
		int x = item[0];
		int y = item[1];
		int type = item[2];
		status |= bit(x,y);
		
		long[] dir = new long[4];
		
		for (int i=0;i<4;i++) {
			int xx = x;
			int yy = y;
			long tmp = 0;
			while (bound(xx+=dx[i],yy+=dy[i])) {
				tmp |= bit(xx,yy);
			}
			dir[i] = tmp;
		}
		
		switch (type) {
		case 1:
			for (int i=0;i<4;i++) {
				back(idx+1,status|dir[i]);
			}
			break;
		case 2:
			for (int i=0;i<2;i++) {
				back(idx+1,status|dir[i]|dir[b(i+2)]);
			}
			break;
		case 3:
			for (int i=0;i<4;i++) {
				back(idx+1,status|dir[i]|dir[b(i+1)]);
			}
			break;
		case 4:
			for (int i=0;i<4;i++) {
				back(idx+1,status|dir[i]|dir[b(i+1)]|dir[b(i+2)]);
			}
			break;
		case 5:
			back(idx+1,status|dir[0]|dir[1]|dir[2]|dir[3]);
		}
	}
	
	static int b(int x) {
		return (x+4)%4;
	}
	
	static long bit(int x,int y) {
		return ((long)(1<<y)<<x*8);
	}
	
//	static void print(long x) {
//		for (int i=0;i<n;i++) {
//			int tmp = (int)(x%p);
//			for (int j=0;j<m;j++) {
//				System.out.print(((tmp&(1<<j))!=0)||room[i][j]==6?1:0);
//			}
//			System.out.println();
//			x/=p;
//		}
//		System.out.println();
//	}
	
	static boolean bound(int x,int y) {
		return x>=0&&x<n&&y>=0&&y<m&&room[x][y]!=6;
	}
}
