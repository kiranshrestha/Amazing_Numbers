import java.util.Scanner;

class Main {
        public static void main(String[] args) {
            // put your code here
            Scanner s = new Scanner(System.in);
            int m = s.nextInt();
            int n = s.nextInt();
            int[][] arr = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = s.nextInt();
                }
            }

            int max = arr[0][0];
            int arri = 0, arrj = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(max < arr[i][j]) {
                        max = arr[i][j];
                        arri = i;
                        arrj = j;
                    }
                }
            }
            System.out.printf("%d %d", arri, arrj);
        }
}