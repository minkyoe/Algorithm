import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9093_단어뒤집기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			
			while (st.hasMoreTokens()) {
				String s = st.nextToken();
				
				for (int j = s.length()-1; j >= 0; j--) {
					sb.append(s.charAt(j));
				}
				sb.append(" ");
			}
			
			sb.append("\n");
		} // end of tc
		
		System.out.println(sb);
	} // end of main
 
} // end of class
