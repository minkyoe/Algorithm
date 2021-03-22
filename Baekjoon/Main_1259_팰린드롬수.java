import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1259_팰린드롬수 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = bf.readLine();
			if (str.equals("0")) break;
			
			boolean flag = true;
			for (int i = 0; i < str.length() / 2; i++) {
				if (str.charAt(i) != str.charAt(str.length()-i-1)) {
					flag = false;
					break;
				}
			}
			
			if (!flag) System.out.println("no");
			else System.out.println("yes");
		}
	} // end of main

} // end of class
