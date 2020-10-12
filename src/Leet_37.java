public class Leet_37 {
    public void solveSudoku(char[][] board) {
        traceback(board,0,0);
    }
    public boolean traceback(char[][] board, int r, int l) {

        if (l == board[0].length) {
            return traceback(board, r + 1, 0);
        }
        if (r == board.length) {
            return true;
        }
        int lastboard = 0;
        for (int i = r; i < board.length; i++) {
            for (int j = l; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    // 如果有预设数字，不用我们穷举
                    return traceback(board, i, j + 1);
                }
                for (char c = '1'; c <= '9'; c++) {
                    if (!isValid(board, i, j, c))
                        continue;
                    board[i][j] = c;
                    if(traceback(board, i, j + 1))
                        return true;

                    board[i][j] = '.';
                }
                return false;
            }
        }
        return false;
    }

    boolean isValid(char[][] board, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            // 判断行是否存在重复
            if (board[r][i] == n) return false;
            // 判断列是否存在重复
            if (board[i][c] == n) return false;
            // 判断 3 x 3 方框是否存在重复
            if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == n)
                return false;
        }
        return true;
    }
}
