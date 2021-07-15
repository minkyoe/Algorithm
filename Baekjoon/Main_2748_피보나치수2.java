import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2748_피보나치수2 {

	private static int N;
	private static long[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		arr = new long[91];
		arr[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		System.out.println(arr[N]);
	} // end of main

} // end of class
