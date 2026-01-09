package problems.programmers.math;

public class No389478_택배상자꺼내기 {
    class Solution1 {
        public int solution(int n, int w, int num) {
            // 1. 특정 번호(target)의 좌표(row, col)를 구하는 헬퍼 함수 정의
            int targetRow = getRow(num, w);
            int targetCol = getCol(num, w);

            // 2. 마지막 상자 n의 행 구함
            int lastRow = getRow(n, w);

            // 3. num 상자가 있는 위치의 높이를 구함
            int height = 0;
            if (lastRow % 2 == 0) {
                height = getCol(n, w) >= targetCol ? lastRow : lastRow - 1;
            } else {
                height = getCol(n, w) <= targetCol ? lastRow : lastRow - 1;
            }

            // 4. 꺼내야 하는 상자 수 = (가장 높은 행 - 현재 행 + 1)
            return height - targetRow + 1;
        }

        private int getRow(int n, int w) {
            return (n - 1) / w;
        }

        private int getCol(int n, int w) {
            int row = getRow(n, w);
            int col = (n - 1) % w;
            // 홀수 행(지그재그 반대방향)일 경우 열 인덱스를 뒤집음
            return (row % 2 == 0) ? col : (w - 1 - col);
        }
    }
}
