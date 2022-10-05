import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P1026_treasure {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //배열 길이
		int[] A = new int[N];
		Integer [] B = new Integer[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) { //A배열 입력
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A); //A배열 오름차순 정렬
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) { //B배열 입력
			B[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(B, Collections.reverseOrder()); //B배열 내림차순 정렬
		
		int S = 0; //S = A[0] × B[0] + ... + A[N-1] × B[N-1]
		for(int i=0; i<N; i++) {
			S += A[i]*B[i];
		}
		
		System.out.println(S);
	}
}
