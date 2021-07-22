import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_6996_애너그램 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int testCase = 0; testCase < tc; testCase++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			
			StringBuilder sb = new StringBuilder();
			sb.append(str1).append(" & ").append(str2).append(" are ");
			
			if (str1.length() != str2.length()) {
				sb.append("NOT anagrams.");
			}
			else {
				boolean isSame = true;
				ArrayList<Character> list1 = new ArrayList<>();
				ArrayList<Character> list2 = new ArrayList<>();
				
				for (int i = 0; i < str1.length(); i++) {
					list1.add(str1.charAt(i));
					list2.add(str2.charAt(i));
				}
				
				Collections.sort(list1);
				Collections.sort(list2);
				
				for (int i = 0; i < list1.size(); i++) {
					if (list1.get(i) != list2.get(i)) {
						isSame = false;
						break;
					}
				}
				
				if (isSame) sb.append("anagrams.");
				else sb.append("NOT anagrams.");
			}
			
			System.out.println(sb);
		}

	} // end of main

} // end of class
