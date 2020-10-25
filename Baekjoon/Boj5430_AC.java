package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_5430_AC {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int testCase = 1; testCase <= tc; testCase++) {
			String p = bf.readLine();
			int n = Integer.parseInt(bf.readLine());
			
			String s = bf.readLine();
			s = s.substring(1, s.length()-1);
			
			StringTokenizer st = new StringTokenizer(s, ",");
			Deque<Integer> dq = new LinkedList<>();
			while(st.hasMoreTokens()) {
				dq.offer(Integer.parseInt(st.nextToken()));
			}
			
			boolean startFromEnd = false;
			boolean isError = false;
			
			for (int i = 0; i < p.length(); i++) {
				char c = p.charAt(i);
				if (c == 'R') {
					startFromEnd = startFromEnd ? false : true;
				} 
				else if (c == 'D') {
					if (dq.size() == 0) {
						isError = true;
						break;
					}
					if (startFromEnd) {
						dq.pollLast();
					} else {
						dq.pollFirst();
					}
				}
			}
			
			if (isError) System.out.println("error");
			else {
				StringBuilder sb = new StringBuilder();
				if (dq.isEmpty()) sb.append("[]");
				else {
					sb.append("[");
					while(!dq.isEmpty()) {
						if (startFromEnd) {
							sb.append(dq.pollLast());
						} else {
							sb.append(dq.pollFirst());
						}
						
						if (dq.size() == 0) sb.append("]");
						else sb.append(",");
					}
				}
				System.out.println(sb.toString());
			}
			
			
		} // end of tc
	} // end of main
}
