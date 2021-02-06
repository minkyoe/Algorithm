import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_13171_A {

	private static int A;
	private static int X;
	private static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		A = Integer.parseInt(bf.readLine());
		X = Integer.parseInt(bf.readLine());
		arr = new int[65];
		
		int idx = 1;
		int s = 0;
		int r = (int) Math.pow(2, s);
		while(r <= X) {
			int num = 1;
			for (int i = 0; i < r; i++) {
				num *= A;
			}
			arr[idx++] = num;
			s++;
			r = (int) Math.pow(2, s);
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		long ans = 1;
		while (s > 0 && X > 0) {
			System.out.println("s  " + s);
			System.out.println("arr[s] " + (arr[s] % 1000000007));
			ans *= (arr[s] % 1000000007);
			System.out.println("ans " + ans );
			System.out.println("------");
			X -= s;
			--s;
		}

		System.out.println(ans);
	} // end of main

} // end of class
