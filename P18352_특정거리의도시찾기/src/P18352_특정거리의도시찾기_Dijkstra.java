import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class P18352_특정거리의도시찾기_Dijkstra {
	static ArrayList<Integer>[] relation;
	static int[] distance;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int city = Integer.parseInt(st.nextToken()); //도시 개수
		int road = Integer.parseInt(st.nextToken()); //도로 개수
		int find_distance = Integer.parseInt(st.nextToken()); //거리 정보
		int start = Integer.parseInt(st.nextToken()); //출발 도시 번호
		
		relation = new ArrayList[city + 1];
		distance = new int[city + 1];
		visited = new boolean[city + 1];
		
		for(int i=1; i<=city; i++) {
			relation[i] = new ArrayList<>();
		}
		
		for(int i=0; i<road; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			relation[x].add(y);
		}
		
		
		for(int i=1; i<=city; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		distance[start] = 0;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			if(visited[now]) continue;
			visited[now] = true;
			
			for(int i : relation[now]) {
				if(distance[i] > distance[now] + 1) {
					distance[i] = distance[now] + 1;
					queue.add(i);
				}
			}
		}
		
		int cnt = 0;
		for(int i=1; i<=city; i++) {
			if(distance[i] == find_distance) {
				System.out.println(i);
				cnt++;
			}
		}
		if(cnt == 0) System.out.println("-1");
	}
}
