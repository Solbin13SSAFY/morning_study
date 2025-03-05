package week07.solbin;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class thu_boj_15721_번데기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws Exception {
    	int a = Integer.parseInt(br.readLine());
    	int t = Integer.parseInt(br.readLine());
    	int type = Integer.parseInt(br.readLine());
    	int bun = 0;
    	int degi = 0;
    	int idx = 0;
    	int cnt = 2;
    	loop:
    	while (true) {
    		for (int i=0;i<2;i++) {
    			bun++;
    			if (check(type,t,bun,degi)) break loop;
    			idx = (idx+a+1)%a;
    			
    			degi++;
    			if (check(type,t,bun,degi)) break loop;
    			idx = (idx+a+1)%a;
    		}
    		
    		for (int i=0;i<cnt;i++) {
    			bun++;
        		if (check(type,t,bun,degi)) break loop;
        		idx = (idx+a+1)%a;
    		}
    		
    		for (int i=0;i<cnt;i++) {
    			degi++;
        		if (check(type,t,bun,degi)) break loop;
        		idx = (idx+a+1)%a;
    		}
    		cnt++;
    	}
    	sb.append(idx);
    	System.out.println(sb);
    }
    
    static boolean check(int type, int t, int bun, int degi) {
    	return (type==1&&degi==t)||(type==0&&bun==t);
    }
}
