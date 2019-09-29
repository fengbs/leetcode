/**
 * Created by lideqing@xiaomi.com on 19-8-27
 */
public class SevenFour {
    private int[][] matrix;
    private boolean dfs (int startX , int startY , int endX ,int endY , int target) {
        if ( startX > endX || startY > endY) {
            return false;
        }
        if (startX == endX && startY == endY ) {
            if ( matrix[startX][startY] == target ) {
                return true;
            }
            return false;
        }
        int middleX = startX + (endX - startX)/2;
        int middleY = startY + (endY - startY)/2;
        if ( matrix[middleX][middleY] == target ) {
            return true;
        } else if ( matrix[middleX][middleY] > target ) {
            if ( middleX > startX ) {
                if ( dfs( startX,startY,middleX-1, endY , target) ) {
                    return true;
                }
            }
            if ( middleY > startY ) {
                if ( dfs(middleX, startY,middleX, middleY-1 , target) ) {
                    return true;
                }
            }

        } else {
            if ( middleX < endX ) {
                if ( dfs( middleX + 1,startY,endX, endY , target) ) {
                    return true;
                }
            }
            if ( middleY < endY ) {
                if ( dfs( startX,middleY + 1,middleX, endY , target) ) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if ( matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        this.matrix = matrix;
        return dfs(0,0,matrix.length-1,matrix[0].length-1,target);
    }

    public static void main ( String []args ) {
        SevenFour sevenFour = new SevenFour();
        int [][]input = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(sevenFour.searchMatrix(input,11));
    }
}
