package P5052_phoneNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P5052_phoneNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine()); //테스트 케이스 개수
		String[] result = new String[testCase]; //결과
		
		for(int i=0; i<testCase; i++) {
			int numberOfphone = Integer.parseInt(br.readLine()); //전화번호 개수
			String[] phoneNum = new String[numberOfphone]; //전화번호부
			for(int j=0; j<numberOfphone; j++) {
				phoneNum[j] = br.readLine(); //번호 문자열
			}
			Arrays.sort(phoneNum);
			for(int j=1; j<numberOfphone; j++) {
				if(phoneNum[j].startsWith(phoneNum[j-1]))	result[i] = "NO";
				if((!phoneNum[j].startsWith(phoneNum[j-1])) && (result[i] != "NO")) result[i] = "YES";
			}	
		}
		
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
