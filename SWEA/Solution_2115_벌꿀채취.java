package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Solution_2115_벌꿀채취 {
 
    private static int N;
    private static int M;
    private static int C;
    private static int[][] map;
    private static ArrayList<int[]> list;
    private static int ans;
    private static ArrayList<Integer> selectedA;
    private static ArrayList<Integer> selectedB;
    private static int maxA;
    private static int maxB;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
         BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= tc; testCase++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); // 벌통들의 크기
            M = Integer.parseInt(st.nextToken()); // 선택할 수 있는 벌통의 개수
            C = Integer.parseInt(st.nextToken()); // 꿀을 채취할 수 있는 최대 양 
            list = new ArrayList<int[]>();
            selectedA = new ArrayList<Integer>();
            selectedB = new ArrayList<Integer>();
            ans = 0;
            maxA = 0;
            maxB = 0;
             
             
            map = new int[N][N];
             
            for (int i = 0; i < N; i++) {
                String s = bf.readLine();
                for (int j = 0,index = 0; j < N; j++,index+=2) {
                    map[i][j] = s.charAt(index) - '0';
                }
            }
             
            dfs(0, 0, 0);
             
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(testCase).append(" ").append(ans);
            System.out.println(sb.toString());
        } // end of testCase
    } // end of main
 
    private static void dfs(int r, int c, int cnt) {
        if (cnt == 2) {
            maxA = maxB = 0;
            getMaxA(0, 0);
            getMaxB(list.size()/2, 0);
             
            int sum = maxA + maxB;
            ans = ans < sum ? sum : ans;
            return;
        }
         
        for (int nr = r; nr < N; nr++) {
ex:         for (int nc = c; nc < N; nc++) {
                if(nc+M > N) {
                    c = 0;
                    break ex;
                }
                for (int i = nc; i < nc+M; i++) {
                    list.add(new int[] {nr, i});
                }
                if (nc+M+M > N) dfs(nr+1, 0, cnt+1);
                else dfs(nr, nc+M, cnt+1);
                 
                for (int i = 0; i < M; i++) {
                    list.remove(list.size()-1);
                }
            }
        }
         
    }
 
    private static int getMaxA(int idx, int cnt) {
        if (cnt >= 1) {
            int tmp = 0;
            int sum = 0;
            for (int i = 0; i < selectedA.size(); i++) {
                tmp += selectedA.get(i);
                sum += selectedA.get(i) * selectedA.get(i);
            }
            if (tmp <= C) {
                maxA = maxA < sum ? sum : maxA;
            }
        }
         
        for (int i = idx; i < list.size()/2; i++) {
            selectedA.add(map[list.get(i)[0]][list.get(i)[1]]);
            getMaxA(i+1, cnt+1);
            selectedA.remove(selectedA.size()-1);
        }
        return 0;
    }
    private static int getMaxB(int idx, int cnt) {
        if (cnt >= 1) {
            int tmp = 0;
            int sum = 0;
            for (int i = 0; i < selectedB.size(); i++) {
                tmp += selectedB.get(i);
                sum += selectedB.get(i) * selectedB.get(i);
            }
            if (tmp <= C) {
                maxB = maxB < sum ? sum : maxB;
            }
        }
         
        for (int i = idx; i < list.size(); i++) {
            selectedB.add(map[list.get(i)[0]][list.get(i)[1]]);
            getMaxB(i+1, cnt+1);
            selectedB.remove(selectedB.size()-1);
        }
        return 0;
    }
}