import java.util.*;

class Solution {
    public String[] solution(String[] commands) {
        List<String> ans = new ArrayList<>();
        String[][] board = new String[51][51];
        List<int[]>[][] list = new ArrayList[51][51];

        for(int i=1;i<=50;i++)
            for(int j=1;j<=50;j++)
                list[i][j] = new ArrayList<>();

        for(String command : commands){
            String[] temp = command.split(" ");
            switch(temp[0]){
                case "UPDATE": {
                    if(temp.length == 4){
                        int r = Integer.parseInt(temp[1]);
                        int c = Integer.parseInt(temp[2]);
                        String value = temp[3];
                        
                            // (r,c)가 속한 그룹 전체를 BFS로 찾아서 값 변경
                        for(int[] p : getGroup(list, r, c)){
                            board[p[0]][p[1]] = value;
                        }
                        
                    } else {
                        String a = temp[1], b = temp[2];
                        for(int i=1;i<=50;i++)
                            for(int j=1;j<=50;j++)
                                if(a.equals(board[i][j])) board[i][j] = b;
                    }
                    break;
                }
                case "MERGE": {
                    int r1=Integer.parseInt(temp[1]), c1=Integer.parseInt(temp[2]);
                    int r2=Integer.parseInt(temp[3]), c2=Integer.parseInt(temp[4]);
                    if(r1==r2 && c1==c2) break;

                    String a = board[r1][c1];
                    String b = board[r2][c2];
                    String chosen = (a != null) ? a : b; // a우선, 없으면 b

                    // 두 그룹을 합치고, 그룹 전체를 chosen 값으로 동기화
                    list[r1][c1].add(new int[]{r2,c2});
                    list[r2][c2].add(new int[]{r1,c1});

                    if(chosen != null){
                        for(int[] p : getGroup(list, r1, c1)){
                            board[p[0]][p[1]] = chosen;
                        }
                    }
                    break;
                }
                case "UNMERGE": {
                    int r = Integer.parseInt(temp[1]);
                    int c = Integer.parseInt(temp[2]);

                    List<int[]> group = getGroup(list, r, c);
                    String value = board[r][c]; // 그룹에 값이 있었다면 보존할 값

                    for(int[] p : group){
                        board[p[0]][p[1]] = null;
                        list[p[0]][p[1]] = new ArrayList<>(); // 연결 완전히 끊기
                    }

                    board[r][c] = value; // 지정 셀에만 값 복원
                    break;
                }
                case "PRINT": {
                    int r = Integer.parseInt(temp[1]);
                    int c = Integer.parseInt(temp[2]);
                    ans.add(board[r][c] == null ? "EMPTY" : board[r][c]);
                    break;
                }
            }
        }

        return ans.toArray(new String[0]);
    }

    // (r,c)가 속한 전체 그룹을 BFS로 탐색
    private List<int[]> getGroup(List<int[]>[][] list, int r, int c){
        List<int[]> result = new ArrayList<>();
        boolean[][] visited = new boolean[51][51];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r,c});
        visited[r][c] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            result.add(cur);
            for(int[] next : list[cur[0]][cur[1]]){
                if(!visited[next[0]][next[1]]){
                    visited[next[0]][next[1]] = true;
                    queue.add(next);
                }
            }
        }
        return result;
    }
}