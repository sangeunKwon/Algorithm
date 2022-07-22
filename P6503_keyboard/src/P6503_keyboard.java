import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P6503_keyboard {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int m = Integer.parseInt(br.readLine());
			
			if(m==0) {
				System.out.println(sb);
				br.close();
				break;
			}
						
			String str = br.readLine();
			int max = 0; //최대 문자열 길이
			int start = -1; 
			int end = -1; 
			
			while(end-1 < str.length()) {
				int[] alpha = new int[128];
				int len = 0; //문자열 길이
				int cnt = 0; //m만큼 갔는지 비교
				
				start++;
				end = start;
				
				while(cnt <= m) {
					if(end>str.length()-1) break;
					if(cnt==m && alpha[str.charAt(end)]==0) break;
					if(alpha[str.charAt(end)] == 0) cnt++;
					alpha[str.charAt(end)]++;
					len++;
					end++;
				}
				if(max < len) max = len;
			}
			sb.append(max+"\n");
		}
	}
}
