import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11365_밀비급일 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String s = bf.readLine();
			if (s.equals("END")) break;
			
			for (int i = s.length() - 1; i >= 0; i--) {
				sb.append(s.charAt(i));
			}
			
			sb.append("\n");
		}

		System.out.println(sb);
	} // end of main

} // end of class
