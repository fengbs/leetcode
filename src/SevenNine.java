/**
 * Created by lideqing@xiaomi.com on 19-8-26
 */
public class SevenNine {
    private char [][] board;
    private String word;
    private boolean isUsed[][];
    private int boardCol;
    private int boardRow;
    boolean dfs ( int row , int col ,int index ) {
         if (board[row][col] != word.charAt(index)) {
             return false;
         }
         ++index;
         if ( index == word.length() ) {
             return true;
         }
         isUsed[row][col] = true;
        int newRow = row - 1;
        int newCol = col;
         if ( newRow >= 0 && !isUsed[newRow][newCol]) {
             if (dfs(newRow,newCol,index)) {
                 return true;
             }
         }
         newRow = row + 1;
         if ( newRow < boardRow && !isUsed[newRow][newCol]) {
             if (dfs(newRow,newCol,index)) {
                 return true;
             }
         }

         newRow = row;
         newCol = col -1;
         if ( newCol >=0 && !isUsed[newRow][newCol]) {
             if (dfs(newRow,newCol,index)) {
                 return true;
             }
         }
        newCol = col + 1;
        if ( newCol < boardCol && !isUsed[newRow][newCol]) {
            if (dfs(newRow,newCol,index)) {
                return true;
            }
        }
        isUsed[row][col] = false;

        return false;

    }
    public boolean exist(char[][] board, String word) {
        this.board = board;
        if ( word == null || word.equals("")) {
            return true;
        }
        if ( board == null || board.length == 0 ) {
            return false;
        }
        this.word = word;
        this.boardRow = board.length;
        this.boardCol = board[0].length;
        this.isUsed = new boolean[boardRow][boardCol];
        for ( int i = 0 ; i < board.length ; ++i ) {
            for ( int j = 0 ; j < board[i].length ; ++j ) {
                if (dfs(i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main ( String []args) {
        SevenNine sevenNine = new SevenNine();
        char [][] input = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(sevenNine.exist(input,""));
    }
}
