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
		
		int N = Integer.parseInt(br.readLine()); //�迭 ����
		int[] A = new int[N];
		Integer [] B = new Integer[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) { //A�迭 �Է�
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A); //A�迭 �������� ����
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) { //B�迭 �Է�
			B[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(B, Collections.reverseOrder()); //B�迭 �������� ����
		
		int S = 0; //S = A[0] �� B[0] + ... + A[N-1] �� B[N-1]
		for(int i=0; i<N; i++) {
			S += A[i]*B[i];
		}
		
		System.out.println(S);
	}
}
