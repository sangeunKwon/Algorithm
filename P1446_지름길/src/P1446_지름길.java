import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P1446_지름길 {
	static class Road implements Comparable<Road> {
		int start; //시작 위치
		int end; //도착 위치
		int len; //지름길의 길이
		
		public Road(int start, int end, int len) {
			this.start = start;
			this.end = end;
			this.len = len;
		}
		
		public int compareTo(Road road) { //지름길 시작 위치 기준으로 정렬
			return this.start > road.start ? 1 : -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int shortcut = Integer.parseInt(st.nextToken()); //지름길 개수
		int highway = Integer.parseInt(st.nextToken()); //고속도로 길이
		
		ArrayList<Road> map = new ArrayList<>();

		
		for(int i=0; i<shortcut; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			
			if(end > highway || end - start <= len) continue; //역주행이거나 지름길이 아닌 경우
			
			map.add(new Road(start, end, len));
		}
		
		Collections.sort(map);
		
		//다익스트라
		int[] distance = new int [highway+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0] = 0;
		int nowPoint = 0; //고속도로 위 현재 위치
		int nowIndex = 0; //지름길 인덱스
		
		while(nowPoint < highway) {
			if(nowIndex < map.size()) {
				Road now = map.get(nowIndex);
				if(nowPoint == now.start) { //지름길이 있는 경우
					distance[now.end] = Math.min(distance[nowPoint] + now.len, distance[now.end]);
					nowIndex++;
				} else { //지름길이 없는 경우
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
