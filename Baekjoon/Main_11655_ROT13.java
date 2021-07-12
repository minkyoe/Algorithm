import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11655_ROT13 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if ('a' <= c && c <= 'z') {
				if (c >= 'n') {
					c -= 13;
				}
				else {
					c += 13;
				}
			}
			else if ('A' <= c && c <= 'Z') {
				if (c >= 'N') {
					c -= 13;
				}
				else {
					c += 13;
				}
			}
			
			sb.append(c);
		}
		
		System.out.println(sb);
	} // end of main

} // end of class
