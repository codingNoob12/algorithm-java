package problems.programmers.shortestpath;

import java.util.LinkedList;
import java.util.Queue;

public class No1844_게임맵최단거리 {

    class Solution1 {
        static final int NOT_VISITED = 0, WALL = 0;
        static final int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

        public int solution(int[][] maps) {
            int n = maps.length - 1, m = maps[0].length - 1;
            int[][] visited = new int[n + 1][m + 1];

            Queue<Position> q = new LinkedList<>();
            q.add(new Position(0, 0));
            visited[0][0] = 1;
            while (!q.isEmpty()) {
                Position current = q.poll();
                int x = current.x, y = current.y;
                
                for (int i = 0; i < dx.length; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (isInvalid(n, m, nx, ny) || visited[nx][ny] != NOT_VISITED || maps[nx][ny] == WALL) {
                        continue;
                    }
                    visited[nx][ny] = visited[x][y] + 1;
                    q.add(new Position(nx, ny));
                }
            }

            return visited[n][m] != 0 ? visited[n][m] : -1;
        }

        private boolean isInvalid(int n, int m, int nx, int ny) {
            return nx < 0 || nx > n || ny < 0 || ny > m;
        }

        static class Position {
            int x;
            int y;
            
            public Position(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
