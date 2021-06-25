import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_2729_이진수덧셈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int testCase = 1 ; testCase <= tc ; testCase++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			
			BigInteger a = new BigInteger(st.nextToken(), 2);
			BigInteger b = new BigInteger(st.nextToken(), 2);
			BigInteger sum = a.add(b);
			
			System.out.println(sum.toString(2));
		} // end of tc

	} // end of main

} // end of class
