import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1012_OrganicCabbage {
    static int[] dx = {-1, 1, 0, 0}; //상하좌우
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] map;
    static int N, M;
    static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			count = 0;
			M = Integer.parseInt(st.nextToken()); //배추밭 가로길이
			N = Integer.parseInt(st.nextToken()); //배추밭 세로길이
			int K = Integer.parseInt(st.nextToken()); //배추가 심어져 있는 위치의 개수
			
			map = new int[M][N];
			visited = new boolean[M][N];
			
			int S, E = 0;
			for(int j=0; j<K; j++) {
				st = new StringTokenizer(br.readLine());
				S = Integer.parseInt(st.nextToken());
				E = Integer.parseInt(st.nextToken());
				map[S][E] = 1;
			}
			
			for(int x=0; x<M; x++) {
				for(int y=0; y<N; y++) {
					if(map[x][y] == 1 && !visited[x][y]) {
						dfs(x, y);
						count++;
					}
				}
			}
			sb.append(count + "\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int X = x + dx[i];
			int Y = y + dy[i];
			
			if(X >= 0 && Y >= 0 && X < M && Y < N) {
				if(!visited[X][Y] && map[X][Y] == 1) {
					dfs(X, Y);
				}
			}
		}
	}
}
