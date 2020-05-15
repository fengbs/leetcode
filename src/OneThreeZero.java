/**
 * Created by lideqing@xiaomi.com on 20-4-24
 */
public class OneThreeZero {

    boolean visit[][];
    char[][] board;
    int row;
    int col;

    void dfs(int i, int j) {
        visit[i][j] = true;
        //up
        if (i != 0 && !visit[i - 1][j] && board[i - 1][j] != 'X') {
            dfs(i - 1, j);
        }
        //down
        if (i != row - 1 && !visit[i + 1][j] && board[i + 1][j] != 'X') {
            dfs(i + 1, j);
        }

        //left
        if (j != 0 && !visit[i][j - 1] && board[i][j - 1] != 'X') {
            dfs(i, j - 1);
        }
        //right
        if (j != col - 1 && !visit[i][j + 1] && board[i][j + 1] != 'X') {
            dfs(i, j + 1);
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        row = board.length;
        col = board[0].length;
        visit = new boolean[row][col];
        this.board = board;
        for (int i = 0; i < row; ++i) {
            if (!visit[i][0] && board[i][0] != 'X') {
                dfs(i, 0);
            }
            if (!visit[i][col - 1] && board[i][col - 1] != 'X') {
                dfs(i, col - 1);
            }
        }

        for (int i = 0; i < col; ++i) {
            if (!visit[0][i] && board[0][i] != 'X') {
                dfs(0, i);
            }
            if (!visit[row - 1][i] && board[row - 1][i] != 'X') {
                dfs(row - 1, i);
            }
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] != 'X' && visit[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        OneThreeZero oneThreeZero = new OneThreeZero();
        char board[][] = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'},
        };
        oneThreeZero.solve(board);
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
