import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_13171_A {

	private static int A;
	private static int X;
	private static long[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		A = Integer.parseInt(bf.readLine());
		X = Integer.parseInt(bf.readLine());
		arr = new long[65];
		
		arr[0] = A % 1000000007;
		for (int i = 1; i < 64; i++) {
			arr[i] = ((arr[i-1] * arr[i-1]) % 1000000007); 
		}
		
//		for (int i = 0; i < 64; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println();
		
		long ans = 1;
		int count = 0;
		while (X != 0) {
			if (X%2 == 1) {
				ans = (ans * (arr[count] % 1000000007)) % 1000000007; 
			}
			X /= 2;
			count++;
		}
		System.out.println(ans);
	} // end of main

} // end of class
