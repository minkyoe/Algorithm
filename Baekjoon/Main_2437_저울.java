import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2437_저울 {

	private static int N;
	private static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		if (arr[0] != 1) System.out.println("1");
		else {
			int sum = arr[0];
			
			for (int i = 1; i < N; i++) {
				if (sum + 1 < arr[i]) {
					break;
				}
				sum += arr[i];
			}
			System.out.println(sum + 1);
		}
	} // end of main

} // end of class
