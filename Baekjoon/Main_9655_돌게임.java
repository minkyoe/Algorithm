import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9655_돌게임 {

	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		int cnt = 0;
		
		while (N > 0) {
			if (N % 3 == 0) N -= 3;
			else N -= 1;
			++cnt;
		}
		
		if (cnt % 2 != 0) System.out.println("SK");
		else System.out.println("CY");
	} // end of main

} // end of class
