/**
 * Created by lideqing@xiaomi.com on 20-3-17
 */
public class TwoEightNine {
    private static final int SIGNEL = 1;
    private static final int NEXT = 0x10;

    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                int res = compute(i ,j,row ,col,board);
                if (board[i][j] == 1) {
                    if(res == 2|| res == 3) {
                        board[i][j]+=2;
                    }
                } else {
                    if (res == 3) {
                        board[i][j]+=2;
                    }
                }
            }
        }


        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                board[i][j] = board[i][j]>>1;
            }
        }
    }

    private int compute(int x ,int y,int row ,int col,int [][]board) {
        int sum = 0;
        for (int i = x-1<0?0:x-1;i<=((x+1>=row)?row-1:x+1);++i) {
            for (int j = y-1<0?0:y-1;j<=((y+1>=col)?col-1:y+1);++j) {
                sum += board[i][j]&SIGNEL;
            }
        }
        return sum - (board[x][y]&SIGNEL);
    }

    public static void main(String[] args) {
        int [][]board = {
            {0,1,0},
            {0,0,1},
            {1,1,1},
            {0,0,0}
        };
        TwoEightNine twoEightNine = new TwoEightNine();
        twoEightNine.gameOfLife(board);
        CommonUtil.printIntArr2(board);

    }
}
