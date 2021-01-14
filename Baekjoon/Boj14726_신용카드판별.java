import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14726_신용카드판별 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int i = 1; i <= tc; i++) {
			String s = bf.readLine();
			int ans = 0;
			
			for (int j = s.length()-1; j >= 0; j--) {
				int n = s.charAt(j) - '0';
				if ((j-s.length()+2) % 2 == 0) { // 짝수라면
					n *= 2;
					int sum = 0;
					if (n >= 10) {
						String tmp = String.valueOf(n);
						for (int k = 0; k < tmp.length(); k++) {
							sum += tmp.charAt(k) - '0';
						}
						n = sum;
					} 
					if (j > 0) s = s.substring(0, j) + String.valueOf(sum) + s.substring(j+1);
					else s = String.valueOf(n) + s.substring(1);
				}
			}
			
			for (int j = 0; j < s.length(); j++) {
				ans += s.charAt(j) - '0';
			}
			
			if (ans % 10 == 0) System.out.println("T");
			else System.out.println("F");
		} // end of testCase
	} // end of main

} 
