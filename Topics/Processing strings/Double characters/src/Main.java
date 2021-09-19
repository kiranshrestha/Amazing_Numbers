import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        StringBuilder stringBuilder = new StringBuilder();

        for (char ch :
                str.toCharArray()) {
            stringBuilder.append(ch).append(ch);
        }
        System.out.println(stringBuilder);
    }
}