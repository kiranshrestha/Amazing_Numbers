import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String num = s.nextLine();
        String[] parts = { num.substring(0, 3), num.substring(3, 6) };
        char[] part1 = parts[0].toCharArray();
        char[] part2 = parts[1].toCharArray();

        int sum1 = 0;
        for (char ch :
                part1) {
            sum1 += Integer.parseInt(String.valueOf(ch));
        }
        int sum2 = 0;
        for (char ch :
                part2) {
            sum2 += Integer.parseInt(String.valueOf(ch));
        }

        if(sum1 == sum2){
            System.out.println("Lucky");
        }else {
            System.out.println("Regular");
        }
    }
}