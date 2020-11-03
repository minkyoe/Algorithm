package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2564_경비원 {
	private static int W;
	private static int H;
	private static int S;
	private static ArrayList<int[]> list;
	private static int dd;
	private static int ds;
	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(bf.readLine()); // 상점 개수
		list = new ArrayList<int[]>();
		ans = 0; // 동근이의 위치와 각 상점 사이의 최단 거리의 합
		
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int[] tmp = new int[2];
			tmp[0] = Integer.parseInt(st.nextToken());
			tmp[1] = Integer.parseInt(st.nextToken());
			list.add(tmp);
		}
		
		st = new StringTokenizer(bf.readLine(), " ");
		dd = Integer.parseInt(st.nextToken()); // 동근이 위치 방향
		ds = Integer.parseInt(st.nextToken()); // 동근이 위치 거리
		
		for (int i = 0; i < list.size(); i++) {
			int sd = list.get(i)[0];
			int ss = list.get(i)[1];
			
			switch (dd) {
			case 1:
				if (sd == 2) {
					ans += Math.min(H + ds + ss, (W-ds) + (W-ss) + H);
				} else {
					if (sd == 3) ans += ss + ds;
					else if (sd == 1) ans += Math.abs(ss-ds);
					else ans += (W-ds) + ss;
				}
				break;
			case 2:
				if (sd == 1) {
					ans += Math.min(H + ds + ss, (W-ds) + (W-ss) + H);
				} else {
					if (sd == 3) ans += (H-ss) + ds;
					else if (sd == 2) ans += Math.abs(ss-ds);
					else ans += (W-ds) + (H-ss);
				}
				break;
			case 3:
				if (sd == 4) {
					ans += Math.min((H-ds) + W + (H-ss), ds + W + ss);
				} else {
					if (sd == 1) ans += ss + ds;
					else if (sd == 3) ans += Math.abs(ss-ds);
					else ans += (H-ds) + ss;
				}
				break;
			case 4:
				if (sd == 3) {
					ans += Math.min((H-ds) + W + (H-ss), ds + W + ss);
				} else {
					if (sd == 1) ans += (W-ss) + ds;
					else if (sd == 4) ans += Math.abs(ss-ds);
					else ans += (W-ds) + (H-ss);
				}
				break;
			}
			
		}
		
		System.out.println(ans);
	} // end of main
}
