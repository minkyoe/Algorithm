import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2577_숫자의개수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(bf.readLine());
		int b = Integer.parseInt(bf.readLine());
		int c = Integer.parseInt(bf.readLine());
		
		long result = a * b * c;
		String s = String.valueOf(result);
		int[] arr = new int[10];
		
		for (int i = 0; i < s.length(); i++) {
			int tmp = s.charAt(i) - '0';
			arr[tmp] += 1;
		}
		
		for (int i = 0; i <= 9; i++) {
			System.out.println(arr[i]);
		}
	} // end of main

} // end of class
