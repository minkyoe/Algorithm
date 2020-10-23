package Programmers;
import java.util.*;

class Solution {
    static ArrayList<String> list = new ArrayList<String>();
    static boolean[] visited;
    static String route;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        route = "";
        
        for (int i=0; i<tickets.length; i++) {
            String start = tickets[i][0];
            String end = tickets[i][1];
            if ("ICN".equals(start)) {
                visited[i] = true;
                route += start + ",";
                dfs(tickets, end, 1);
                visited[i] = false;
                route = "";
            }
        }
        Collections.sort(list);
        String str = list.get(0);
        StringTokenizer st = new StringTokenizer(str, ",");
        answer = new String[st.countTokens()];
        
        for (int i =0; i<answer.length; i++) {
            answer[i] = st.nextToken();
        }
        return answer;
    }
    public void dfs(String[][] tcs, String dest, int count) {
        route += dest + ",";
        if (count == tcs.length) {
            list.add(route);
            return;
        }
        
        for (int i=0; i<tcs.length; i++) {
            String start = tcs[i][0];
            String end = tcs[i][1];
            
            if (dest.equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(tcs, end, count+1);
                visited[i] = false;
                route = route.substring(0, route.length()-4);
            }
           
        }
    }
}