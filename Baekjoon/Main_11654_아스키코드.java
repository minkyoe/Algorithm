import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11654_아스키코드 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char c = bf.readLine().charAt(0);
		System.out.println((int) c);
	}
}
