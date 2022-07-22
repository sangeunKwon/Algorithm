import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17609_palindrome {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); //문자열 갯수
		for(int i=0; i<T; i++) {
			String str = br.readLine();
			String rev = new StringBuilder(str).reverse().toString();
			
			//회문이면 0 출력
			if(str.equals(rev)) sb.append(0+"\n");
			
			else {
				int start = 0;
				int end = str.length()-1;
				
				while(start <= end) {
					String str1 = null;
					String rev1 = null;
					if(str.charAt(start) != str.charAt(end)) {
						if(str.charAt(start+1) == str.charAt(end)) {
							str1 = new StringBuilder(str).deleteCharAt(start).toString();
							rev1 = new StringBuilder(str1).reverse().toString();
							if(!str1.equals(rev1)) {
								if(str.charAt(start) == str.charAt(end-1)) {
									str1 = new StringBuilder(str).deleteCharAt(end).toString();
								}
							}
						}
						else if(str.charAt(start) == str.charAt(end-1)) {
							str1 = new StringBuilder(str).deleteCharAt(end).toString();
							rev1 = new StringBuilder(str1).reverse().toString();
							if(!str1.equals(rev1)) {
								if(str.charAt(start+1) == str.charAt(end)) {
									str1 = new StringBuilder(str).deleteCharAt(start).toString();
								}
							}
						}
						else {
							sb.append(2+"\n");
							break;
						}
						String Afrev = new StringBuilder(str1).reverse().toString();
						if(str1.equals(Afrev)) {
							sb.append(1+"\n");
							break;
						}else {
							sb.append(2+"\n");
							break;
						}
					}
					start++;
					end--;
				}
			}
		}
		System.out.println(sb);
	}
}
