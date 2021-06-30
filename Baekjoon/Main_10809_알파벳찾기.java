import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10809_알파벳찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		int[] arr = new int[26];
		
		Arrays.fill(arr, -1);
		
		for (int i = 0; i < str.length(); i++) {
			int idx = str.charAt(i) - '0' - 49;
			if (arr[idx] != -1) continue;
			arr[idx] = i;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	} // end of main

} // end of class
