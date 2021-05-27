import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		String ans = "";
		boolean open = false;
		String tmp = "";
		for (int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			
			if (now == '<') {
				open = true;
				ans += tmp;
				tmp = "";
				ans += now;
			}
			else if (now == '>') {
				ans += now;
				open = false;
			}
			else if (now == ' ') {
				ans += tmp;
				ans += ' ';
				tmp = "";
			}
			else {
				if (open) ans += now;
				else tmp = now + tmp;
			}
			
		} // end of for
		
		if (tmp.length() > 0) ans += tmp;
		
		System.out.println(ans);
	} // end of main

} // end of class
