import java.util.Scanner;

/**
 * 
 */

/**
 * @author sachin.srivastava
 * @hackerrank - https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid?h_r=next-challenge&h_v=zen
 * awesome connected cells problem with dfs
 *
 */
public class DFSMaxRegion {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getMaxRegions(grid));
        in.close();
    }
    private static int getMaxRegions(int[][] matrix){
        int maxRegion = 0;
        for(int rows = 0;rows< matrix.length;rows++){
            for(int col = 0 ; col<matrix[rows].length;col++ ){
                if(matrix[rows][col] == 1){
                    int size = getRegionSize(matrix, rows , col);
                    maxRegion = Math.max(maxRegion,size);
                }
            }
        }
        return maxRegion;
    }
    private static int getRegionSize(int[][] matrix , int rows , int cols){
        if(rows < 0 || cols < 0 || rows>= matrix.length || cols>= matrix[rows].length){
            return 0;
        }
        if(matrix[rows][cols] == 0){
            return 0;
        }
        matrix[rows][cols] = 0;//added to avoid any kind of visited array //making it 0 will keep it skipping for the next ietrations
        int size = 1;
        for(int r=rows-1; r <= rows+1; r++){
            for(int c = cols-1;c<= cols+1;c++){
                size+=getRegionSize(matrix,r,c);
            }
        }
        return size;
    }

}
