import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P1446_������ {
	static class Road implements Comparable<Road> {
		int start; //���� ��ġ
		int end; //���� ��ġ
		int len; //�������� ����
		
		public Road(int start, int end, int len) {
			this.start = start;
			this.end = end;
			this.len = len;
		}
		
		public int compareTo(Road road) { //������ ���� ��ġ �������� ����
			return this.start > road.start ? 1 : -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int shortcut = Integer.parseInt(st.nextToken()); //������ ����
		int highway = Integer.parseInt(st.nextToken()); //��ӵ��� ����
		
		ArrayList<Road> map = new ArrayList<>();

		
		for(int i=0; i<shortcut; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			
			if(end > highway || end - start <= len) continue; //�������̰ų� �������� �ƴ� ���
			
			map.add(new Road(start, end, len));
		}
		
		Collections.sort(map);
		
		//���ͽ�Ʈ��
		int[] distance = new int [highway+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0] = 0;
		int nowPoint = 0; //��ӵ��� �� ���� ��ġ
		int nowIndex = 0; //������ �ε���
		
		while(nowPoint < highway) {
			if(nowIndex < map.size()) {
				Road now = map.get(nowIndex);
				if(nowPoint == now.start) { //�������� �ִ� ���
					distance[now.end] = Math.min(distance[nowPoint] + now.len, distance[now.end]);
					nowIndex++;
				} else { //�������� ���� ���
					distance[nowPoint + 1] = Math.min(distance[nowPoint + 1], distance[nowPoint] + 1);
					nowPoint++;
				}
			} else {
				distance[nowPoint + 1] = Math.min(distance[nowPoint + 1], distance[nowPoint] + 1);
				nowPoint++;
			}
		}
		System.out.println(distance[highway]);	
	}
}
