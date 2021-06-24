import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10808_알파벳개수 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		int[] count = new int[26];
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int idx = (int) c - 97;
			count[idx] += 1;
		}
		
		for (int i = 0; i < 26; i++) {
			System.out.print(count[i] + " ");
		}
	} // end of main

} // end of class
