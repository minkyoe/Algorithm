import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_10829_이진수변환 {

	private static String ans;
	private static long num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		num = Long.parseLong(bf.readLine());
		ans = "";
		recur(num);
		
		System.out.println(ans);
	} // end of main

	private static void recur(long num) {
		if (num / 2 == 1) {
			ans = "1" + (num % 2) + ans;
			return;
		}
		
		ans = (num % 2) + ans;
		recur(num / 2);
		
	}

} // end of class
