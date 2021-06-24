import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2877_4와7 {

	private static int K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(bf.readLine()) + 1;
		String binary = Integer.toBinaryString(K);
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < binary.length(); i ++) {
			if (binary.charAt(i) == '1') {
				sb.append("7");
			} else {
				sb.append("4");
			}
		}
		
		System.out.println(sb);
	} // end of main
} // end of class
