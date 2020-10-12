package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2304_창고다각형 {
	private static int N;
	private static ArrayList<Tower> list;
	private static long ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine()); // 기둥 개수
		list = new ArrayList<Tower>();
		ans = 0; // 총 면적 
		
		StringTokenizer tok;
		int maxH = 0;
		for (int i = 0; i < N; i++) {
			tok = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(tok.nextToken());
			int height = Integer.parseInt(tok.nextToken());
			maxH = maxH < height ? height : maxH;
			list.add(new Tower(x, height));
		}
		
		Collections.sort(list);
		
		ArrayList<Tower> maxHeight = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			if (list.get(i).height == maxH) {
				maxHeight.add(list.get(i));
			}
		}
		
		int leftX = 0;
		int rightX = 0;
		if (maxHeight.size() == 1) {
			ans += maxHeight.get(0).height;
			leftX = maxHeight.get(0).x;
			rightX = leftX;
		}
		else {
			Collections.sort(maxHeight);
			leftX = maxHeight.get(0).x;
			rightX = maxHeight.get(maxHeight.size()-1).x;
			ans += (rightX-leftX+1)*maxH;
		}
		
		// 좌측
ex:		for (int i = 0; i < list.size(); i++) {
			int height = list.get(i).height;
			int x = list.get(i).x;
			
			if (x == leftX) break;
			for (int j = i+1; j < list.size(); j++) {
				int nextHeight = list.get(j).height;
				int nextX = list.get(j).x;
				
				if (height > nextHeight) {
					continue;
					
				} else {
					if (nextX == leftX) {
						ans += (leftX - x) * height;
						break ex;
					} else {
						ans += (nextX - x) * height;
						i = j - 1;
						break;
					}
				}
				
			}
		}
		
		// 우측
ex2:	for (int i = list.size()-1; i >= 0; i--) {
			int height = list.get(i).height;
			int x = list.get(i).x;
			
			if (x == rightX) break;
			for (int j = i-1; j >= 0; j--) {
				int nextHeight = list.get(j).height;
				int nextX = list.get(j).x;
				
				if (height > nextHeight) {
					continue;
					
				} else {
					if (nextX == rightX) {
						ans += (x - rightX) * height;
						break ex2;
					} else {
						ans += (x - nextX) * height;
						i = j + 1;
						break;
					}
				}
				
			}
		}
		
		System.out.println(ans);
		
		
	} // end of main
} // end of class

class Tower implements Comparable<Tower> {
	int x;
	int height;
	
	public Tower() {
	}
	
	public Tower(int x, int height) {
		super();
		this.x = x;
		this.height = height;
	}

	@Override
	public int compareTo(Tower o) {
		return this.x - o.x;
	}
}
