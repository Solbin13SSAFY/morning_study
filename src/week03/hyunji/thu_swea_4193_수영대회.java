package hyunji;

import java.io.*;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;
 
class entry { //어느좌표에 몇초걸리는지 데이터 담아두기
    int y;
    int x;
    int time;
 
    public entry(int y, int x, int time) {
        this.y = y;
        this.x = x;
        this.time = time;
    }
}
 
class entryComparator implements Comparator<entry> {
    @Override
    public int compare(entry e1, entry e2) {
        return e1.time - e2.time;
    }
}
 
public class thu_swea_4193_수영대회 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=0; tc<T; tc++) {
            int N = sc.nextInt();
            int[][] pool = new int[N][N];
            for(int y=0; y<N; y++) {
                for (int x=0; x<N; x++) {
                    pool[y][x] = sc.nextInt();
                }
            }
            int start_y = sc.nextInt();
            int start_x = sc.nextInt();
            int end_y = sc.nextInt();
            int end_x = sc.nextInt();
 
            int time = movingTime(pool, N, start_y, start_x, end_y, end_x);
 
            System.out.println("#" + (tc+1) + " " + time);
        }
    }
 
    public static int movingTime(int[][] pool, int N, int start_y, int start_x, int end_y, int end_x) {
        boolean[][] visited = new boolean[N][N];
        for(int y=0; y<N; y++) {
            for(int x=0; x<N; x++) {
                visited[y][x]=false;
            }
        }
 
        PriorityQueue<entry> queue = new PriorityQueue<>(1, new entryComparator());
         
        entry startEntry = new entry(start_y, start_x, 0);
 
        queue.add(startEntry);
 
        int[] dy = {-1,0,1,0};
        int[] dx = {0,1,0,-1};
 
        while(!queue.isEmpty()) {
            entry topEntry = queue.poll();
 
            int currentY = topEntry.y;
            int currentX = topEntry.x;
            int currentTime = topEntry.time;
 
            if (currentY == end_y && currentX == end_x) {
                return currentTime;
            }
 
            if(visited[currentY][currentX])
                continue;
             
            visited[currentY][currentX] = true;
 
            for(int i=0; i<4; i++) {
                int nextY = currentY + dy[i];
                int nextX = currentX + dx[i];
 
                if (isValidPos(nextY, nextX, N)) {
                    if (!visited[nextY][nextX] && pool[nextY][nextX] != 1) {
                        entry newEntry = new entry(-1,-1,-1);
                        if(pool[nextY][nextX] == 0) { // 지나갈수있는길
                            newEntry.y = nextY;
                            newEntry.x = nextX;
                            newEntry.time = currentTime + 1;
                             
                        }
                        else { // 소용돌이
                            int delay = 3 - currentTime % 3;
                            newEntry.y = nextY;
                            newEntry.x = nextX;
                            newEntry.time = currentTime + delay;
                        }
                        queue.add(newEntry);
                    }
                }
            }
        }
 
        return -1;
    }
 
    public static boolean isValidPos(int y, int x, int N) {
        if (y < 0 || x < 0 || y >= N || x >= N) return false;
        else return true;
    }
}