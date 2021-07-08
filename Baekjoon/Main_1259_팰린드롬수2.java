import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1259_팰린드롬수2 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String s = bf.readLine();
			int len = s.length();
			
			if (s.equals("0")) break;
			
			boolean isPalin = true;
			
			for (int i = 0; i < len / 2; i++) {
				int front = s.charAt(i);
				int back = s.charAt(len - i - 1);
				
				if (front != back) {
					isPalin = false;
					break;
				}
			}
			
			if (isPalin) System.out.println("yes");
			else System.out.println("no");
		}

	} // end of main

} // end of class
