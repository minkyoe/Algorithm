import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3062_수뒤집기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int testCase = 1; testCase <= tc; testCase++) {
			int origin = Integer.parseInt(bf.readLine());
			String originStr = String.valueOf(origin);
			
			int reversed = 0;
			boolean isPal = true;
			
			for (int i = 0; i < originStr.length(); i++) {
				int now = originStr.charAt(i) - '0';
				if (now == 0) continue;
				reversed += (now * Math.pow(10, i));
			}
			
			String reversedStr = String.valueOf(origin + reversed);
			int len = reversedStr.length();
			
			for (int i = 0; i < len/2; i++) {
				if (reversedStr.charAt(i) != reversedStr.charAt(len-i-1)) {
					isPal = false;
					break;
				}
			}
			
			if (isPal) System.out.println("YES");
			else System.out.println("NO");
		} // end of tc

	} // end of main

} // end of class
