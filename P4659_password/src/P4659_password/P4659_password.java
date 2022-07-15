package P4659_password;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class P4659_password {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) { //종료될 때까지 반복
			String pw = br.readLine();
			
			if(pw.equals("end")) break; //종료
			
			Vector<Character> PW = new Vector<Character>(); //패스워드 문자열
			boolean result = true; //결과
						
			if(!(pw.contains("a") || pw.contains("e") || pw.contains("i") || pw.contains("o") || pw.contains("u"))) {
				result = false; //모음을 포함하고 있지 않으면 불가능
			}
			
			for(int i=0; i<pw.length(); i++) {
				PW.add(pw.charAt(i));
			}
			
			for(int i=2; i<pw.length(); i++) {
				if((PW.get(i)=='a' || PW.get(i)=='e' || PW.get(i)=='i' || PW.get(i)=='o' || PW.get(i)=='u')) { //모음일때
					if((PW.get(i-1)=='a' || PW.get(i-1)=='e' || PW.get(i-1)=='i' || PW.get(i-1)=='o' || PW.get(i-1)=='u') && (PW.get(i-2)=='a' || PW.get(i-2)=='e' || PW.get(i-2)=='i' || PW.get(i-2)=='o' || PW.get(i-2)=='u')) { //모음 연속 3개면 불가능
						result = false;
						break;
					}
				}
				else { //모음이 아닐때
					if(!(PW.get(i-1)=='a' || PW.get(i-1)=='e' || PW.get(i-1)=='i' || PW.get(i-1)=='o' || PW.get(i-1)=='u') && !(PW.get(i-2)=='a' || PW.get(i-2)=='e' || PW.get(i-2)=='i' || PW.get(i-2)=='o' || PW.get(i-2)=='u')){ //자음 연속 3개면 불가능
						result = false;
						break;
					}
				}
			}
			
			for(int i=1; i<pw.length(); i++) {
				if(PW.get(i) == PW.get(i-1));{//이전 문자와 같으면 false(e와 o는 제외)
					if((PW.get(i)!='e') && (PW.get(i)!='o')) {
						result = false;
						break;
					}
				}
			}
						
			if(result) { //가능한 케이스 출력
				System.out.println("<" + pw + "> is acceptable");
			} else { //불가능한 케이스 출력
				System.out.println("<" + pw + "> is not acceptable");
			}
		}
	}
}
