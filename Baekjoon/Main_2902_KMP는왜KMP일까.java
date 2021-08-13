import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2902_KMP는왜KMP일까 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine(), "-");
		
		while(st.hasMoreTokens()) {
			sb.append(st.nextToken().charAt(0));
		}
		
		System.out.println(sb);
	} // end of main

} // end of class
