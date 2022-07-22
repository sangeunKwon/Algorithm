import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15904_UCPC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().replace(" ", "");
		int j=0;
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(Character.isUpperCase(ch)==true) {
				if(ch == 'U' && j == 0) j++;
				if(ch == 'C' && j == 1) j++;
				if(ch == 'P' && j == 2) j++;
				if(ch == 'C' && j == 3) j++;
			}
		}
		if(j == 4) System.out.println("I love UCPC");
		else System.out.println("I hate UCPC");
	}
}
