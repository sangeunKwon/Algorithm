import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9205_���ָ��ø鼭�ɾ�� {

	static class PointXY {
		private int x, y;
		PointXY() {
			this.x = 0;
			this.y = 0;
		}
		PointXY(int x, int y){
			this.x = x;
			this.y = y;
		}
		public int getX() {
			return this.x;
		}
		public int getY() {
			return this.y;
		}
	}
	
	static int shop_cnt;
	static PointXY home;
	static PointXY festival;
	static PointXY[] shop;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //�׽�Ʈ ���̽�
		
		for(int i=0; i<T; i++) {
			shop_cnt = Integer.parseInt(br.readLine()); //������ ����
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			home = new PointXY(x, y); //����̳� �� ��ǥ ���
			
			shop = new PointXY[shop_cnt]; //������ ��ü �迭 ����
			for(int j=0; j<shop_cnt; j++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				shop[j] = new PointXY(x, y); //������ ��ǥ ���
			}
			
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			festival = new PointXY(x, y); //�� �佺Ƽ�� ��ǥ ���
			
			bfs();
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[] visited = new boolean[shop_cnt];
		int x = home.getX();
		int y = home.getY();
		queue.add(new int[] {x, y});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			if(Math.abs(now[0]-festival.getX()) + Math.abs(now[1]-festival.getY()) <= 1000) {
				sb.append("happy" + "\n");
				return;
			}
			
			for(int i=0; i<shop_cnt; i++) {
				if(!visited[i]) {
					int distance = Math.abs(now[0]-shop[i].getX()) + Math.abs(now[1]-shop[i].getY());
					if(distance <= 1000) {
						visited[i] = true;
						queue.add(new int[] {shop[i].getX(), shop[i].getY()});
					}
				}
			}
		}
		sb.append("sad" + "\n");
	}
}