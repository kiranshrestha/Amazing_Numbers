import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        char[] chars = input.toCharArray();
        char nxtChr = chars[0];
        nxtChr++;
        boolean inOrder = true;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != nxtChr) {
                inOrder = false;
                break;
            }
            nxtChr = chars[i];
            nxtChr++;
        }
        System.out.println(inOrder);
    }
}