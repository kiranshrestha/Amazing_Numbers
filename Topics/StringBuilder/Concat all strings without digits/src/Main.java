import java.util.Scanner;

class ConcatenateStringsProblem {


    public static String concatenateStringsWithoutDigits(String[] strings) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        // write your code with StringBuilder here
        for (String string : strings) {
            sb1.append(removeDigitsFromString(string, sb));
            sb.setLength(0);
        }
        return sb1.toString();
    }

    private static StringBuilder removeDigitsFromString(String str, StringBuilder sb) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }
        return sb;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}
