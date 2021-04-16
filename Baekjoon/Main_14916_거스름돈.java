import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14916_거스름돈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int ans = 0;
		while (n > 0) {
			if (n == 1 || n == 3) {
				ans = -1;
				break;
			}
			if (n % 5 == 0) {
				ans += (n / 5);
				break;
			}
			n -= 2;
			++ans;
		}
		
		System.out.println(ans);
	} // end of main

} // end of class
