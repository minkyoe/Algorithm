import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3052_나머지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[42];
		
		for (int i = 0; i < 10; i++) {
			int num = Integer.parseInt(bf.readLine());
			arr[num % 42] += 1;
		}
		
		int ans = 0;
		for (int i = 0; i < 42; i++) {
			if (arr[i] != 0) ans++;
		}
		
		System.out.println(ans);
	}

}
