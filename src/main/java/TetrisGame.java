import java.io.IOException;
import java.util.Scanner;

public class TetrisGame {
	private static int count = 0;

	private static boolean isIdentityMatrix() {

		count++;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] != 0) {

				} else {

					return false;
				}
			}
		}

		return true;
	}

	private static boolean trySolvingTetris() {

		// I
		{
			for (int i = 0; i <= row - 3; i++) {
				for (int j = 0; j <= col - 1; j++) {
					if (matrix[i][j] == 0 && matrix[i + 1][j] == 0 && matrix[i + 2][j] == 0) {

						matrix[i][j] = 1;
						matrix[i + 1][j] = 1;
						matrix[i + 2][j] = 1;

						if (isIdentityMatrix()) {

							return true;
						}

						if (trySolvingTetris()) {

							return true;
						}
						matrix[i][j] = 0;
						matrix[i + 1][j] = 0;
						matrix[i + 2][j] = 0;
					}
				}
			}

			// |--|
			{
				for (int i = 0; i <= row - 1; i++) {
					for (int j = 0; j <= col - 3; j++) {
						if (matrix[i][j] == 0 && matrix[i][j + 1] == 0 && matrix[i][j + 2] == 0) {
							matrix[i][j] = 1;
							matrix[i][j + 1] = 1;
							matrix[i][j + 2] = 1;

							if (isIdentityMatrix()) {

								return true;
							}
							if (trySolvingTetris()) {

								return true;
							}
							matrix[i][j] = 0;
							matrix[i][j + 1] = 0;
							matrix[i][j + 2] = 0;
						}
					}
				}
			}

			// []
			for (int i = 0; i <= row - 2; i++) {
				for (int j = 0; j <= col - 2; j++) {
					if (matrix[i][j] == 0 && matrix[i + 1][j] == 0 && matrix[i][j + 1] == 0 && matrix[i + 1][j + 1] == 0) {
						matrix[i][j] = 1;
						matrix[i + 1][j] = 1;
						matrix[i][j + 1] = 1;
						matrix[i + 1][j + 1] = 1;

						if (isIdentityMatrix()) {

							return true;
						}
						if (trySolvingTetris()) {

							return true;
						}
						matrix[i][j] = 0;
						matrix[i + 1][j] = 0;
						matrix[i][j + 1] = 0;
						matrix[i + 1][j + 1] = 0;
					}
				}
			}

			{
				// T
				for (int i = 0; i <= row - 2; i++) {
					for (int j = 0; j <= col - 3; j++) {
						if (matrix[i][j] == 0 && matrix[i][j + 1] == 0 && matrix[i + 1][j + 1] == 0
								&& matrix[i][j + 2] == 0) {
							matrix[i][j] = 1;
							matrix[i][j + 1] = 1;
							matrix[i + 1][j + 1] = 1;
							matrix[i][j + 2] = 1;

							if (isIdentityMatrix()) {

								return true;
							}
							if (trySolvingTetris()) {

								return true;
							}
							matrix[i][j] = 0;
							matrix[i][j + 1] = 0;
							matrix[i + 1][j + 1] = 0;
							matrix[i][j + 2] = 0;
						}
					}
				}

				// |-
				for (int i = 0; i <= row - 3; i++) {
					for (int j = 0; j <= col - 2; j++) {
						if (matrix[i][j] == 0 && matrix[i + 1][j] == 0 && matrix[i + 1][j + 1] == 0
								&& matrix[i + 2][j] == 0) {
							matrix[i][j] = 1;
							matrix[i + 1][j] = 1;
							matrix[i + 1][j + 1] = 1;
							matrix[i + 2][j] = 1;

							if (isIdentityMatrix()) {

								return true;
							}
							if (trySolvingTetris()) {

								return true;
							}
							matrix[i][j] = 0;
							matrix[i + 1][j] = 0;
							matrix[i + 1][j + 1] = 0;
							matrix[i + 2][j] = 0;
						}
					}
				}

				// |-
				for (int i = 0; i <= row - 3; i++) {
					for (int j = 0; j <= col - 2; j++) {
						if (matrix[i][j + 1] == 0 && matrix[i + 1][j] == 0 && matrix[i + 1][j + 1] == 0
								&& matrix[i + 2][j + 1] == 0) {
							matrix[i][j + 1] = 1;
							matrix[i + 1][j] = 1;
							matrix[i + 1][j + 1] = 1;
							matrix[i + 2][j + 1] = 1;

							if (isIdentityMatrix()) {

								return true;
							}
							if (trySolvingTetris()) {

								return true;
							}
							matrix[i][j + 1] = 0;
							matrix[i + 1][j] = 0;
							matrix[i + 1][j + 1] = 0;
							matrix[i + 2][j + 1] = 0;
						}
					}
				}

				// inverted T
				for (int i = 0; i <= row - 2; i++) {
					for (int j = 0; j <= col - 3; j++) {
						if (matrix[i + 1][j] == 0 && matrix[i][j + 1] == 0 && matrix[i + 1][j + 1] == 0
								&& matrix[i + 1][j + 2] == 0) {
							matrix[i + 1][j] = 1;
							matrix[i][j + 1] = 1;
							matrix[i + 1][j + 1] = 1;
							matrix[i + 1][j + 2] = 1;

							if (isIdentityMatrix()) {

								return true;
							}
							if (trySolvingTetris()) {

								return true;
							}
							matrix[i + 1][j] = 0;
							matrix[i][j + 1] = 0;
							matrix[i + 1][j + 1] = 0;
							matrix[i + 1][j + 2] = 0;
						}
					}
				}

			}

			{
				// J
				for (int i = 0; i <= row - 2; i++) {
					for (int j = 0; j <= col - 3; j++) {
						if (matrix[i][j] == 0 && matrix[i][j + 1] == 0 && matrix[i + 1][j + 2] == 0
								&& matrix[i][j + 2] == 0) {
							matrix[i][j] = 1;
							matrix[i][j + 1] = 1;
							matrix[i + 1][j + 2] = 1;
							matrix[i][j + 2] = 1;

							if (isIdentityMatrix()) {

								return true;
							}
							if (trySolvingTetris()) {

								return true;
							}
							matrix[i][j] = 0;
							matrix[i][j + 1] = 0;
							matrix[i + 1][j + 2] = 0;
							matrix[i][j + 2] = 0;
						}
					}
				}

				// L
				for (int i = 0; i <= row - 2; i++) {
					for (int j = 0; j <= col - 3; j++) {
						if (matrix[i + 1][j] == 0 && matrix[i][j] == 0 && matrix[i + 1][j + 1] == 0
								&& matrix[i + 1][j + 2] == 0) {
							matrix[i + 1][j] = 1;
							matrix[i][j] = 1;
							matrix[i + 1][j + 1] = 1;
							matrix[i + 1][j + 2] = 1;

							if (isIdentityMatrix()) {

								return true;
							}
							if (trySolvingTetris()) {

								return true;
							}
							matrix[i + 1][j] = 0;
							matrix[i][j] = 0;
							matrix[i + 1][j + 1] = 0;
							matrix[i + 1][j + 2] = 0;
						}
					}
				}

				// Inverted 7
				for (int i = 0; i <= row - 3; i++) {
					for (int j = 0; j <= col - 2; j++) {
						if (matrix[i][j] == 0 && matrix[i + 1][j] == 0 && matrix[i][j + 1] == 0 && matrix[i + 2][j] == 0) {
							matrix[i][j] = 1;
							matrix[i + 1][j] = 1;
							matrix[i][j + 1] = 1;
							matrix[i + 2][j] = 1;

							if (isIdentityMatrix()) {

								return true;
							}
							if (trySolvingTetris()) {

								return true;
							}
							matrix[i][j] = 0;
							matrix[i + 1][j] = 0;
							matrix[i][j + 1] = 0;
							matrix[i + 2][j] = 0;
						}
					}
				}

				// Inverted L
				for (int i = 0; i <= row - 3; i++) {
					for (int j = 0; j <= col - 2; j++) {
						if (matrix[i][j + 1] == 0 && matrix[i + 2][j] == 0 && matrix[i + 1][j + 1] == 0
								&& matrix[i + 2][j + 1] == 0) {
							matrix[i][j + 1] = 1;
							matrix[i + 2][j] = 1;
							matrix[i + 1][j + 1] = 1;
							matrix[i + 2][j + 1] = 1;

							if (isIdentityMatrix()) {

								return true;
							}
							if (trySolvingTetris()) {

								return true;
							}
							matrix[i][j + 1] = 0;
							matrix[i + 2][j] = 0;
							matrix[i + 1][j + 1] = 0;
							matrix[i + 2][j + 1] = 0;
						}
					}
				}

			}

			{
				// _--
				for (int i = 0; i <= row - 2; i++) {
					for (int j = 0; j <= col - 3; j++) {
						if (matrix[i][j] == 0 && matrix[i][j + 1] == 0 && matrix[i + 1][j] == 0 && matrix[i][j + 2] == 0) {
							matrix[i][j] = 1;
							matrix[i][j + 1] = 1;
							matrix[i + 1][j] = 1;
							matrix[i][j + 2] = 1;

							if (isIdentityMatrix()) {

								return true;
							}
							if (trySolvingTetris()) {

								return true;
							}
							matrix[i][j] = 0;
							matrix[i][j + 1] = 0;
							matrix[i + 1][j] = 0;
							matrix[i][j + 2] = 0;
						}
					}
				}

				// L
				for (int i = 0; i <= row - 3; i++) {
					for (int j = 0; j <= col - 2; j++) {
						if (matrix[i][j] == 0 && matrix[i + 1][j] == 0 && matrix[i + 2][j + 1] == 0
								&& matrix[i + 2][j] == 0) {
							matrix[i][j] = 1;
							matrix[i + 1][j] = 1;
							matrix[i + 2][j + 1] = 1;
							matrix[i + 2][j] = 1;

							if (isIdentityMatrix()) {

								return true;
							}
							if (trySolvingTetris()) {

								return true;
							}
							matrix[i][j] = 0;
							matrix[i + 1][j] = 0;
							matrix[i + 2][j + 1] = 0;
							matrix[i + 2][j] = 0;
						}
					}
				}

				// 7
				for (int i = 0; i <= row - 3; i++) {
					for (int j = 0; j <= col - 2; j++) {
						if (matrix[i][j + 1] == 0 && matrix[i][j] == 0 && matrix[i + 1][j + 1] == 0
								&& matrix[i + 2][j + 1] == 0) {
							matrix[i][j + 1] = 1;
							matrix[i][j] = 1;
							matrix[i + 1][j + 1] = 1;
							matrix[i + 2][j + 1] = 1;

							if (isIdentityMatrix()) {

								return true;
							}
							if (trySolvingTetris()) {

								return true;
							}
							matrix[i][j + 1] = 0;
							matrix[i][j] = 0;
							matrix[i + 1][j + 1] = 0;
							matrix[i + 2][j + 1] = 0;
						}
					}
				}

				// __|
				for (int i = 0; i <= row - 2; i++) {
					for (int j = 0; j <= col - 3; j++) {
						if (matrix[i + 1][j] == 0 && matrix[i][j + 2] == 0 && matrix[i + 1][j + 1] == 0
								&& matrix[i + 1][j + 2] == 0) {
							matrix[i + 1][j] = 1;
							matrix[i][j + 2] = 1;
							matrix[i + 1][j + 1] = 1;
							matrix[i + 1][j + 2] = 1;

							if (isIdentityMatrix()) {

								return true;
							}
							if (trySolvingTetris()) {

								return true;
							}
							matrix[i + 1][j] = 0;
							matrix[i][j + 2] = 0;
							matrix[i + 1][j + 1] = 0;
							matrix[i + 1][j + 2] = 0;
						}
					}
				}
			}

			{

				// S
				for (int i = 0; i <= row - 3; i++) {
					for (int j = 0; j <= col - 2; j++) {
						if (matrix[i][j] == 0 && matrix[i + 1][j] == 0 && matrix[i + 1][j + 1] == 0
								&& matrix[i + 2][j + 1] == 0) {
							matrix[i][j] = 1;
							matrix[i + 1][j] = 1;
							matrix[i + 1][j + 1] = 1;
							matrix[i + 2][j + 1] = 1;

							if (isIdentityMatrix()) {

								return true;
							}
							if (trySolvingTetris()) {

								return true;
							}
							matrix[i][j] = 0;
							matrix[i + 1][j] = 0;
							matrix[i + 1][j + 1] = 0;
							matrix[i + 2][j + 1] = 0;
						}
					}
				}

				// Weird S
				for (int i = 0; i <= row - 2; i++) {
					for (int j = 0; j <= col - 3; j++) {
						if (matrix[i][j + 1] == 0 && matrix[i][j + 2] == 0 && matrix[i + 1][j] == 0
								&& matrix[i + 1][j + 1] == 0) {
							matrix[i][j + 1] = 1;
							matrix[i][j + 2] = 1;
							matrix[i + 1][j] = 1;
							matrix[i + 1][j + 1] = 1;

							if (isIdentityMatrix()) {

								return true;
							}
							if (trySolvingTetris()) {

								return true;
							}
							matrix[i][j + 1] = 0;
							matrix[i][j + 2] = 0;
							matrix[i + 1][j] = 0;
							matrix[i + 1][j + 1] = 0;
						}
					}
				}
			}

			{
				// Z
				for (int i = 0; i <= row - 2; i++) {
					for (int j = 0; j <= col - 3; j++) {
						if (matrix[i][j] == 0 && matrix[i][j + 1] == 0 && matrix[i + 1][j + 1] == 0
								&& matrix[i + 1][j + 2] == 0) {
							matrix[i][j] = 1;
							matrix[i][j + 1] = 1;
							matrix[i + 1][j + 1] = 1;
							matrix[i + 1][j + 2] = 1;

							if (isIdentityMatrix()) {

								return true;
							}
							if (trySolvingTetris()) {

								return true;
							}
							matrix[i][j] = 0;
							matrix[i][j + 1] = 0;
							matrix[i + 1][j + 1] = 0;
							matrix[i + 1][j + 2] = 0;
						}
					}
				}
				// Weird Z
				for (int i = 0; i <= row - 3; i++) {
					for (int j = 0; j <= col - 2; j++) {
						if (matrix[i][j + 1] == 0 && matrix[i + 1][j] == 0 && matrix[i + 1][j + 1] == 0
								&& matrix[i + 2][j] == 0) {
							matrix[i][j + 1] = 1;
							matrix[i + 1][j] = 1;
							matrix[i + 1][j + 1] = 1;
							matrix[i + 2][j] = 1;

							if (isIdentityMatrix()) {

								return true;
							}
							if (trySolvingTetris()) {

								return true;
							}
							matrix[i][j + 1] = 0;
							matrix[i + 1][j] = 0;
							matrix[i + 1][j + 1] = 0;
							matrix[i + 2][j] = 0;
						}
					}
				}

			}
		}
		count--;
		return false;
	}

	private static int[][] matrix; 

	private static int row = 0;
	private static int col = 0;
	public static int requiredTetriminos(int input1,int input2,int[] input3)
	{
		//Write code here
		row = input1;
		col = input2;
		int array2d[][] = new int[input1][input2];
		int array1d[] = input3;
		int localCount=0;

		if(input1<=0 || input2 <= 0)
			return 0;

		for(int i=0;i<input1;i++)

		{
			for(int j=0;j<input2;j++)

			{
				if(localCount==array1d.length) break;

				array2d[i][j]=array1d[localCount];

				localCount++;

			}

		}

		matrix = array2d;

		if (true == trySolvingTetris()) {
			return count;
		} else {
			return 0;

		}
	}
	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int output = 0;
        int ip1 = Integer.parseInt(in.nextLine().trim());
        int ip2 = Integer.parseInt(in.nextLine().trim());
        int ip3_size = 0;
        ip3_size = Integer.parseInt(in.nextLine().trim());
        int[] ip3 = new int[ip3_size];
        int ip3_item;
        for(int ip3_i = 0; ip3_i < ip3_size; ip3_i++) {
            ip3_item = Integer.parseInt(in.nextLine().trim());
            ip3[ip3_i] = ip3_item;
        }
        output = requiredTetriminos(ip1,ip2,ip3);
        System.out.println("\n");
        System.out.println(String.valueOf(output));
    }
}
