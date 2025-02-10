package week03.solbin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
class D4_1868_지뢰찾기
{
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static char[][] arr;
    static int[] dx = {-1,0,1,-1,1,-1,0,1};
	static int[] dy = {1,1,1,0,0,-1,-1,-1};
	static Stack<int[]> stack;
    public static void main(String args[]) throws Exception
    {
        int T = Integer.parseInt(br.readLine());
        for (int t=1;t<=T;t++) {
            System.out.print("#" + t + " ");
            int sum = 0;
            n = Integer.parseInt(br.readLine());
            arr = new char[n][n];
            stack = new Stack<>();
            for (int i=0;i<n;i++) {
            	arr[i] = br.readLine().toCharArray();
            }
            
            // 吏�猶곗� �씤�젒�븯吏� �븡��怨녹쓣 �겢由��빐�꽌 紐⑤몢 �뿰�떎
            for (int i=0;i<n;i++) {
            	for (int j=0;j<n;j++) {
            		if (!isNear(i,j) && arr[i][j] == '.') {
            			// �뒪�깮�뿉 �뜑�븯怨� DFS瑜� �떎�뻾�븿
            			stack.add(new int[] {i,j});
            			dfs();
            			sum++;
            		}
            	}
            }
            
            // 吏�猶곗� �씤�젒�븯硫댁꽌 �뿴由ъ� �븡��怨녹쓣 �꽱�떎
            for (int i=0;i<n;i++) {
            	for (int j=0;j<n;j++) {
            		if (isNear(i,j) && arr[i][j] == '.') {
            			sum++;
            		}
            	}
            }
            
            System.out.println(sum);
        }
    }
    
    static void dfs() {
    	while (!stack.isEmpty()) {
    		int[] item = stack.pop();
    		int a = item[0];
    		int b = item[1];
    		arr[a][b] = 'O';
    		if (!isNear(a,b)) {
    			for (int i=0;i<8;i++) {
    				int x = a+dx[i];
    				int y = b+dy[i];
    				if (bound(x,y) && arr[x][y]!='O') {
    					stack.add(new int[] {x,y});
    				}
    			}
    		}
    	}
    }
    
    static boolean isNear(int a, int b) {
    	boolean hasMine = false;
    	for (int i=0;i<8;i++) {
    		int x = a+dx[i];
    		int y = b+dy[i];
    		if (bound(x,y) && arr[x][y]=='*') {
    			hasMine = true;
    			break;
    		}
    	}
    	return hasMine;
    }
    
    static boolean bound(int x, int y) {
    	if (x<0||x>=n||y<0||y>=n) {
    		return false;
    	} else {
    		return true;
    	}
    }
}