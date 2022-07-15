package mingyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mingyun {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //입력 단어 갯수
		String origin = ""; //원본
		String reverse = ""; //뒤집어서 쓴 문자열
		String[] ori = new String[N];
		String[] rever = new String[N];
		for(int i=0; i<ori.length; i++) {
			origin = br.readLine();
			ori[i] = origin;
			for(int j=origin.length()-1; j>=0; j--) {
				reverse = reverse + origin.charAt(j);
			}
			rever[i] = reverse;
			reverse = "";
		}
		
		String ans ="";
		FIRST:
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(ori[j].equals(rever[i])) {
					ans = ori[j];
					break FIRST;
				}
			}
		}
		
		System.out.println(ans.length() + " " + ans.charAt(ans.length()/2));
	}
}
