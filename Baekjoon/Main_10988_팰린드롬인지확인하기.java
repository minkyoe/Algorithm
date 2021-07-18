import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10988_팰린드롬인지확인하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		int len = str.length();
		boolean isPal = true;
		
		for (int i = 0; i < len / 2; i++) {
			char a = str.charAt(i);
			char b = str.charAt(len - i - 1);
			
			if (a != b) {
				isPal = false;
				break;
			}
		}
		
		if (isPal) System.out.println(1);
		else System.out.println(0);
	} // end of main

} // end of class
