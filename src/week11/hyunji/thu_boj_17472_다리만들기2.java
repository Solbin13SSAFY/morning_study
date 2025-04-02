package week11.hyunji;

//각 섬마다 번호 부여하고 - 섬과 섬 사이 간선의 오름차순으로 정렬(크루스칼, 같은 섬이면 넘기기) - 최대 V-1만큼 돌면서 최단경로의 합 구하기
//다리는 방문여부 체크XX, 0은 바다, 1은 땅
//1. 연결 가능하냐? 가능하다면 s,e,cost가 어떻게 되냐? Edge타입의 list에 넣기 - 2. sort - 3. 크루스칼 => mst 합 도출

import java.util.*;

class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0}; //상하좌우
    static int[] dx = {0, 0, -1, 1};
    static List<Edge> edges = new ArrayList<>();
    static int[] p; //크루스칼 - 대표들 넣을 배열

    static class Edge {
        int s, e, cost;

        Edge(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }

    static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.cost - o2.cost; //거리 오름차순
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] num = sc.nextLine().split(" ");
        N = Integer.parseInt(num[0]); //세로
        M = Integer.parseInt(num[1]); //가로

        map = new int[N][M];
        visited = new boolean[N][M];
        for(int y=0; y<N; y++) {
            String[] input = sc.nextLine().split(" ");
            for(int x=0; x<M; x++) {
                map[y][x] = Integer.parseInt(input[x]);
            }
        } //2차원배열 입력받기

        //섬마다 번호 부여하기
        drawNum();

        //섬 개수 구하기
        int V = 0;
        for(int y=0; y<N; y++) {
            for(int x=0; x<M; x++) {
                if(map[y][x] > V) V = map[y][x];
            }
        }

        //부여된 섬 번호로 델타 탐색해서 다른 섬 만나면 s, e, cost 저장해서 edges에 넣기 => isConnect 함수 호출하기
        for(int y=0; y<N; y++) {
            for(int x=0; x<M; x++) {
                if(map[y][x] > 1) { //섬이라면
                    for(int d=0; d<4; d++) { //델타 돌면서 다른 섬과 연결 가능한지 구하고, 가능하다면 거리 계산하기
                        operateDist(y, x, d);
                    }
                }
            }
        }

        int ans = mst(V);
        System.out.println(ans);
    }

    static int mst(int V) {
        //edges -> cost로 정렬해서
        Collections.sort(edges, new EdgeComparator());

        //크루스칼 알고리즘으로 mst 구하기
        p = new int[V+1]; //섬 개수
        for(int i=0; i<=V; i++) {
            p[i] = i;
        }

        int ans = 0;
        int i = 0, pick = 0;
        while(i<edges.size() && pick<V-1) {
            Edge edge = edges.get(i);
            int px = findSet(edge.s);
            int py = findSet(edge.e);

            if(px!=py) {
                union(px, py);
                pick++;
                ans += edge.cost;
            }
            i++;
        }
        
        if(pick==V-1) return ans;
        else return -1;

    }

    static void drawNum() {
        int updateNum = 1;

        for(int y=0; y<N; y++) {
            for(int x=0; x<M; x++) {
                if(map[y][x] == 1 && !visited[y][x]) {
                    dfs(y, x, updateNum);
                    updateNum++;
                }
            }
        }
    }

    static void dfs(int y, int x, int updateNum) {
        //종료조건 - 바다면 끝내기
        if(map[y][x] != 1) return;

        visited[y][x] = true;
        map[y][x] = updateNum;

        //재귀부분
        for(int d=0; d<4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if(isValid(ny, nx) && !visited[ny][nx] && map[ny][nx] == 1) { //범위가 유효하고 현 위치가 땅이라면 dfs돌리기
                dfs(ny, nx, updateNum);
            }
        }
    }

    static void operateDist(int y, int x, int d) {
        int start = map[y][x];

        int ny = y + dy[d];
        int nx = x + dx[d];

        int len = 0;

        while(isValid(ny, nx) && map[ny][nx]==0) { 
            len++;
            ny += dy[d];
            nx += dx[d];
        }

        if(isValid(ny, nx) && map[ny][nx]!=start && len >= 2) { 
            int end = map[ny][nx];
            edges.add(new Edge(start, end, len));
        }
    }

    static void union(int y, int x) {
        p[findSet(y)] = findSet(x);
    }

    static int findSet(int x) {
        if(x!=p[x]) p[x] = findSet(p[x]);
        return p[x];
    }

    static boolean isValid(int y, int x) {
        if(y>=0 && y<N && x>=0 && x<M) return true;
        else return false;
    }
}