import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4948_베르트랑공준 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {

		while (true) {
			int num = Integer.parseInt(bf.readLine());
			if (num == 0)
				break;

			int a = num;
			int b = 2 * num;
			int ans = 0; // 소수 개수

			int[] isDeleted = new int[b + 1];
			isDeleted[0] = isDeleted[1] = 1;

			for (int i = 2; i <= b; i++) {
				for (int j = i + i; j <= b; j += i) {
					if (isDeleted[j] == 0) {
						isDeleted[j] = 1;
					}
				}
			}

			for (int i = a + 1; i <= b; i++) {
				if (isDeleted[i] == 0) {
					ans++;
				}
			}

			System.out.println(ans);

		} // end of while

	} // end of main
} // end of class
