package P4659_password;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class P4659_password {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) { //����� ������ �ݺ�
			String pw = br.readLine();
			
			if(pw.equals("end")) break; //����
			
			Vector<Character> PW = new Vector<Character>(); //�н����� ���ڿ�
			boolean result = true; //���
						
			if(!(pw.contains("a") || pw.contains("e") || pw.contains("i") || pw.contains("o") || pw.contains("u"))) {
				result = false; //������ �����ϰ� ���� ������ �Ұ���
			}
			
			for(int i=0; i<pw.length(); i++) {
				PW.add(pw.charAt(i));
			}
			
			for(int i=2; i<pw.length(); i++) {
				if((PW.get(i)=='a' || PW.get(i)=='e' || PW.get(i)=='i' || PW.get(i)=='o' || PW.get(i)=='u')) { //�����϶�
					if((PW.get(i-1)=='a' || PW.get(i-1)=='e' || PW.get(i-1)=='i' || PW.get(i-1)=='o' || PW.get(i-1)=='u') && (PW.get(i-2)=='a' || PW.get(i-2)=='e' || PW.get(i-2)=='i' || PW.get(i-2)=='o' || PW.get(i-2)=='u')) { //���� ���� 3���� �Ұ���
						result = false;
						break;
					}
				}
				else { //������ �ƴҶ�
					if(!(PW.get(i-1)=='a' || PW.get(i-1)=='e' || PW.get(i-1)=='i' || PW.get(i-1)=='o' || PW.get(i-1)=='u') && !(PW.get(i-2)=='a' || PW.get(i-2)=='e' || PW.get(i-2)=='i' || PW.get(i-2)=='o' || PW.get(i-2)=='u')){ //���� ���� 3���� �Ұ���
						result = false;
						break;
					}
				}
			}
			
			for(int i=1; i<pw.length(); i++) {
				if(PW.get(i) == PW.get(i-1));{//���� ���ڿ� ������ false(e�� o�� ����)
					if((PW.get(i)!='e') && (PW.get(i)!='o')) {
						result = false;
						break;
					}
				}
			}
						
			if(result) { //������ ���̽� ���
				System.out.println("<" + pw + "> is acceptable");
			} else { //�Ұ����� ���̽� ���
				System.out.println("<" + pw + "> is not acceptable");
			}
		}
	}
}
