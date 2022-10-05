import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
				�޸�		�ð�		�ڵ����
	BFS			280052KB	1284ms	1834B
	Dijkstra	285088KB	1356ms	1770B
*/	

public class P18352_Ư���Ÿ��ǵ���ã��_BFS {
	static boolean[] visited;
	static ArrayList<Integer>[] relation;
	static int distance;
	static ArrayList<Integer> answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int city = Integer.parseInt(st.nextToken()); //���� ����
		int road = Integer.parseInt(st.nextToken()); //���� ����
		distance = Integer.parseInt(st.nextToken()); //�Ÿ� ����
		int start = Integer.parseInt(st.nextToken()); //��� ���� ��ȣ
		
		relation = new ArrayList[city + 1];
		visited = new boolean[city + 1];
		answer = new ArrayList<>();
		
		for(int i=1; i<=city; i++) {
			relation[i] = new ArrayList<>();
		}
		
		for(int i=0; i<road; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			relation[x].add(y);
		}
		bfs(start);
		Collections.sort(answer);
		if(answer.size() == 0) {
			System.out.println("-1");
		}else {
			for(int i=0; i<answer.size(); i++) {
				System.out.println(answer.get(i));
			}
		}
	}
	
	static void bfs(int start) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {start, 1});
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i : relation[now[0]]) {
				if(!visited[i]) {
					if(now[1] == distance) {
						answer.add(i);
					}
					visited[i] = true;
					queue.add(new int[] {i, now[1]+1});
				}
			}
		}
	}
}
