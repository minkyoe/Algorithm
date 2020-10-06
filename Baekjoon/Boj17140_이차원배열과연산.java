package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_17140_이차원배열과연산 {

	private static int r;
	private static int c;
	private static int k;
	private static int rowCnt;
	private static int colCnt;
	private static int[][] map;
	private static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[101][101];
		count = new int[101]; // 한 줄에 있는 숫자의 개수 (인덱스: 숫자, 값: 개수)
		rowCnt = 3; // 행 개수
		colCnt = 3; // 열 개수

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;
		while (true) {
			if (time > 100) {
				time = -1;
				break;
			}
			if (map[r - 1][c - 1] == k)
				break;

			time++;
			// R연산
			if (rowCnt >= colCnt) {
				int colCntMax = 0;

				for (int i = 0; i < rowCnt; i++) {
					count = new int[101];
					for (int j = 0; j < colCnt; j++) {
						if (map[i][j] == 0)
							continue;
						count[map[i][j]]++;
					}

					ArrayList<Num> list = new ArrayList<Num>();
					for (int k = 1; k <= 100; k++) {
						if (count[k] == 0)
							continue;
						list.add(new Num(k, count[k]));
					}

					Collections.sort(list);
					
					int index = 0;
					Arrays.fill(map[i], 0);
					
					for (int j = 0; j < list.size(); j++) {
						if (index == 100) break;
						map[i][index++] = list.get(j).num;
						map[i][index++] = list.get(j).cnt;
						if (j == list.size() - 1) {
							map[i][index] = 0;
						}
					}

					colCntMax = colCntMax < index ? index : colCntMax;
				}

				colCnt = colCntMax;
				Arrays.fill(count, 0);
			}
			// C연산
			else {
				int rowCntMax = 0;
				for (int i = 0; i < colCnt; i++) {
					count = new int[101];
					for (int j = 0; j < rowCnt; j++) {
						if (map[j][i] == 0)
							continue;
						count[map[j][i]]++;
					}

					ArrayList<Num> list = new ArrayList<Num>();
					for (int k = 1; k <= 100; k++) {
						if (count[k] == 0)
							continue;
						list.add(new Num(k, count[k]));
					}

					Collections.sort(list);
					
					int index = 0;
					for (int k = 0; k < rowCnt; k++) {
						map[k][i] = 0;
					}
					
					for (int j = 0; j < list.size(); j++) {
						if (index == 100) break;
						map[index++][i] = list.get(j).num;
						map[index++][i] = list.get(j).cnt;
						if (j == list.size() - 1) {
							map[index][i] = 0;
						}
					}

					rowCntMax = rowCntMax < index ? index : rowCntMax;
				}

				rowCnt = rowCntMax;
			}
			
		} // end of while
		
		System.out.println(time);

	} // end of main

} // end of class

class Num implements Comparable<Num> {
	int num;
	int cnt;

	public Num() {
	}

	public Num(int num, int cnt) {
		super();
		this.num = num;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Num o) {
		if (o.cnt == this.cnt) {
			return this.num - o.num;
		}
		return this.cnt - o.cnt;
	}
}
