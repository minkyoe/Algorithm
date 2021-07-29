import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_19942_다이어트 {

	private static int N;
	private static int mp, mf, ms, mv;
	private static int[][] info;
	private static ArrayList<Integer> selected;
	private static ArrayList<Integer> ans;
	private static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

		mp = Integer.parseInt(st.nextToken());
		mf = Integer.parseInt(st.nextToken());
		ms = Integer.parseInt(st.nextToken());
		mv = Integer.parseInt(st.nextToken());
		
		info = new int[N][5];
		selected = new ArrayList<Integer>();
		ans = new ArrayList<Integer>();
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
			info[i][2] = Integer.parseInt(st.nextToken());
			info[i][3] = Integer.parseInt(st.nextToken());
			info[i][4] = Integer.parseInt(st.nextToken());
		}
		
		comb(0, 0);
		
		StringBuilder sb = new StringBuilder();
		if (min == Integer.MAX_VALUE) sb.append(-1);
		else {
			sb.append(min).append("\n");
			
			Collections.sort(ans);
			for (int i = 0; i < ans.size(); i++) {
				sb.append(ans.get(i)).append(" ");
			}
		}
		System.out.println(sb);
	} // end of main

	private static void comb(int idx, int cnt) {
		if (cnt == N) return;
		if (cnt > 0) {
			int mmp = 0;
			int mmf = 0;
			int mms = 0;
			int mmv = 0;
			int cost = 0;
			
			for (int i = 0; i < selected.size(); i++) {
				int iidx = selected.get(i);
				
				mmp += info[iidx][0];
				mmf += info[iidx][1];
				mms += info[iidx][2];
				mmv += info[iidx][3];
				cost += info[iidx][4];
			}
			if (mmp >= mp && mmf >= mf && mms >= ms && mmv >= mv) {
				if (min > cost) {
					min = cost;
					ans.clear();
					for (int i = 0; i < selected.size(); i++) {
						ans.add((selected.get(i) + 1));
					}
				}
				else if (min == cost) {
					boolean selectedFirst = true; // selected가 사전순으로 앞
					Collections.sort(selected);
					Collections.sort(ans);
					int end = Math.min(ans.size(), selected.size());
					if (ans.size() == 0) end = selected.size();
					
					for (int i = 0; i < end; i++) {
						if (selected.get(i) > ans.get(i)) {
							selectedFirst = false;
							break;
						}
					}
					
					if (selectedFirst) {
						min = cost;
						ans.clear();
						for (int i = 0; i < selected.size(); i++) {
							ans.add((selected.get(i) + 1));
						}
						
					}
				
				}
			}
		}
		
		for (int i = idx; i < N; i++) {
			selected.add(i);
			comb(i+1, cnt+1);
			selected.remove(selected.size()-1);
		}
	}

} // end of class
