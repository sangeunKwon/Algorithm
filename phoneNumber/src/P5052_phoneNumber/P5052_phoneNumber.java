package P5052_phoneNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P5052_phoneNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine()); //�׽�Ʈ ���̽� ����
		String[] result = new String[testCase]; //���
		
		for(int i=0; i<testCase; i++) {
			int numberOfphone = Integer.parseInt(br.readLine()); //��ȭ��ȣ ����
			String[] phoneNum = new String[numberOfphone]; //��ȭ��ȣ��
			for(int j=0; j<numberOfphone; j++) {
				phoneNum[j] = br.readLine(); //��ȣ ���ڿ�
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
