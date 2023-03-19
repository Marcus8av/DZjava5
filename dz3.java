public class dz3 {
    private static int count = 0;   
    private static int N = 8;

    public static void main(String[] args) {
        int[][] arr = new int[N][N];    
        Queen(0, arr);    
    }

    private static void Queen(int row, int[][] arr) {
        if (row == N) {
            count++;
            System.out.println(" " + count + " Как это будет выглядеть :");
            for (int[] ints : arr) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
        } else {
            int[][] newArr = new int[N][N];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    newArr[i][j] = arr[i][j];
                }
            }
            for (int col = 0; col < N; col++) {
                if (newQueen(row, col, newArr)) {
                    for (int c = 0; c < N; c++) {
                        newArr[row][c] = 0;
                    }
                    newArr[row][col] = 1;
                    Queen(row + 1, newArr);
                }
            }
        }
    }

    private static boolean newQueen(int row, int col, int[][] newArr) {
        for (int r = row - 1; r >= 0; r--) {
            if (newArr[r][col] == 1) {
                return false;
            }
        }
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (newArr[r][c] == 1) {
                return false;
            }
        }
        for (int r = row - 1, c = col + 1; r >= 0 && c < N; r--, c++) {
            if (newArr[r][c] == 1) {
                return false;
            }
        }
        return true;
    }

}
