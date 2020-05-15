/**
 * Created by lideqing@xiaomi.com on 20-3-20
 */
public class TwoFourZero {
    private int[][] martrix;
    private int target;
    private int row;
    private int col;

    private boolean doSearch(int rowStart, int rowEnd, int colStart, int colEnd) {
        if (rowStart > rowEnd || colStart > colEnd) {
            return false;
        }
        if (rowStart == rowEnd && colStart == colEnd) {
            if (martrix[rowStart][colStart] != target) {
                return false;
            }
        }
        int middleX = (rowStart + rowEnd) / 2;
        int middleY = (colStart + colEnd) / 2;
        if (martrix[middleX][middleY] == target) {
            return true;
        } else {
            if (martrix[middleX][middleY] > target) {
                return (((middleX <= 0 || middleY <= 0) ? false : doSearch(rowStart, middleX - 1, colStart, middleY - 1)) ||
                    (middleY <= 0 ? false : doSearch(middleX, rowEnd, colStart, middleY - 1)) ||
                    middleX <= 0 ? false : doSearch(rowStart, middleX - 1, middleY, colEnd));
            } else {
                return (((middleX >= row - 1 && middleY >= col - 1) ? false : doSearch(middleX + 1, rowEnd, middleY + 1, colEnd)) ||
                    (middleX >= row - 1 ? false : doSearch(middleX + 1, rowEnd, colStart, middleY)) ||
                    (middleY >= col - 1 ? false : doSearch(rowStart, middleX, middleY + 1, colEnd)));
            }
        }

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        this.martrix = matrix;
        this.target = target;
        row = matrix.length;
        col = martrix[0].length;
        return doSearch(0, matrix.length-1, 0, martrix[0].length-1);
    }

    public static void main(String[] args) {
        int[][] input = {
            {1, 4, 7, 11, 15}};
        TwoFourZero twoFourZero = new TwoFourZero();
        System.out.println(twoFourZero.searchMatrix(input, 5));
    }

}
