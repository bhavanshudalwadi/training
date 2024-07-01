package dsaPrograms.ShortestSafeRoute;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestSafeRoute {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        int shortestSafeRoute = findShortestSafeRoute(matrix);
        System.out.println("Shortest safe route length: " + shortestSafeRoute);
    }

    private static int findShortestSafeRoute(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] distance = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                distance[i][j] = Integer.MAX_VALUE;
                if (matrix[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        distance[0][0] = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[x][y] + 1;

                    if (nx == rows - 1 && ny == cols - 1) {
                        return distance[nx][ny];
                    }
                }
            }
        }

        return -1;
    }
}
