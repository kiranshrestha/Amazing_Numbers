package numbers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

class NumberTest {

    long num;
    String numStr;
    StringBuilder sb = new StringBuilder();
    DecimalFormat df = new DecimalFormat("###,###,###,###,###,###,###,###");

    public NumberTest(long num) {
        this.num = num;
        this.numStr = String.valueOf(num);
    }


    private boolean checkForBuzzNumber() {
        boolean divBy7 = checkForDivideBy7();

        boolean endWith7 = checkForEndWith7();

        return divBy7 || endWith7;

    }

    private boolean checkForEndWith7() {

        return numStr.charAt(numStr.length()-1) == '7';
    }

    private boolean checkForDivideBy7() {
        return num % 7 == 0;
    }

    public static boolean checkForNaturalNumber(long num, String name) {
        if(num <1){
            System.out.printf("The %s parameter should be a natural number%s.\n\n",name, name.equals("first") ? " or zero" : "");
            return false;
        }else
            return true;
    }

    public static boolean checkForProperty(String prop){
        if(Property.isExist(prop)) {
            return true;
        }else{
            System.out.printf("The property [%s] is wrong.\n" +
                    "Available properties:\n" +
                    "[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]\n", prop);
            return false;
        }
    }

    private boolean checkForEvenNumber() {
        return (num % 2 == 0);
    }

    private boolean checkForDuckNumber() {
        return String.valueOf(num).contains("0");
    }

    public void checkNumber() {
        final boolean isEven = checkForEvenNumber();
        final boolean isHappy = checkForHappyNumber();
        System.out.printf("Properties of %s\n" +
                "        even: %b\n" +
                "         odd: %b\n" +
                "        buzz: %b\n" +
                "        duck: %b\n" +
                "      gapful: %b\n" +
                "         spy: %b\n" +
                " palindromic: %b\n" +
                "      square: %b\n" +
                "       sunny: %b\n" +
                "     jumping: %b\n" +
                "       happy: %b\n" +
                "         sad: %b\n",
                df.format(num),
                isEven,
                !isEven,
                checkForBuzzNumber(),
                checkForDuckNumber(),
                checkForGapFull(),
                checkForSpyNumber(),
                checkForPalindrom(),
                checkForSquareNumber(),
                checkForSunnyNumber(),
                checkForJumpingNumber(),
                isHappy,
                !isHappy
                );
    }

    // Utility method to return sum of square of
// digit of n
    static int numSquareSum(long n)
    {
        int squareSum = 0;
        while (n!= 0)
        {
            squareSum += (n % 10) * (n % 10);
            n /= 10;
        }
        return squareSum;
    }

    //  method return true if n is Happy number
    boolean checkForHappyNumber()
    {
        long slow, fast;

        //  initialize slow and fast by n
        slow = fast = num;
        do
        {
            //  move slow number
            // by one iteration
            slow = numSquareSum(slow);

            //  move fast number
            // by two iteration
            fast = numSquareSum(numSquareSum(fast));

        }
        while (slow != fast);

        //  if both number meet at 1,
        // then return true
        return (slow == 1);
    }

    public void checkNumbers(long numTill){
        for (int i = 0; i < numTill; i++) {
            printResult();
            incrementNum();
        }
    }

    private void printResult() {
        sb.append(df.format(num)).append(" is ");
        if (checkForEvenNumber()) {
            sb.append("even");
        }
        else {
            sb.append("odd");
        }
        if (checkForBuzzNumber()) {
            sb.append(", buzz");
        }
        if (checkForDuckNumber()) {
            sb.append(", duck");
        }
        if (checkForGapFull()) {
            sb.append(", gapful");
        }
        if (checkForSpyNumber()) {
            sb.append(", spy");
        }
        if (checkForPalindrom()) {
            sb.append(", palindromic");
        }
        if (checkForSunnyNumber()) {
            sb.append(", sunny");
        }
        if (checkForSquareNumber()) {
            sb.append(", square");
        }
        if (checkForJumpingNumber()) {
            sb.append(", jumping");
        }
        if (checkForHappyNumber()) {
            sb.append(", happy");
        } else {
            sb.append(", sad");
        }

        System.out.println(sb);
        sb.setLength(0);
    }

    private void incrementNum() {
        num++;
        numStr = String.valueOf(num);
    }

    public void filterNumberAccordingToProperty(long numTill, String property) {
        int count = 0;
        do {
            if(isPropertySatisfy(property)) {
                printResult();
                count++;
            }
            incrementNum();
        }while (numTill > count);
    }

    public void filterNumberAccordingToProperties(long numTill, String[] properties) {
        int count = 0;
        do {
            int satisfiedCount =0;
            for (String property : properties) {
                if (isPropertySatisfy(property)) {
                    satisfiedCount++;
                }
                if (satisfiedCount == properties.length) {
                    printResult();
                    count++;
                }
            }

            incrementNum();
        }while (numTill > count);
    }

    private boolean isPropertySatisfy(String property) {
        boolean isNegative = false;
        property = property.toUpperCase(Locale.ROOT);
        if(property.contains("-"))
        {
            property = property.replace("-","");
            isNegative = true;
        }
        var prop = Property.valueOf(property);
        switch (prop){
            case ODD: return isNegative == checkForEvenNumber();
            case EVEN: return isNegative != checkForEvenNumber();
            case BUZZ: return isNegative != checkForBuzzNumber();
            case DUCK: return isNegative != checkForDuckNumber();
            case SPY: return isNegative != checkForSpyNumber();
            case GAPFUL: return isNegative != checkForGapFull();
            case PALINDROMIC: return isNegative != checkForPalindrom();
            case SQUARE: return isNegative != checkForSquareNumber();
            case SUNNY: return isNegative != checkForSunnyNumber();
            case JUMPING: return isNegative != checkForJumpingNumber();
            case HAPPY: return isNegative != checkForHappyNumber();
            case SAD: return isNegative == checkForHappyNumber();
        }
        return false;
    }

    private boolean checkForSpyNumber() {
        int sum = 0;
        int prod = 1;
        for (int i = 0; i < numStr.length(); i++) {
            int capVal = Integer.parseInt(String.format("%c",numStr.charAt(i)));
            sum += capVal;
            prod *= capVal;
        }
        return sum == prod;
    }

    private boolean checkForGapFull() {
        if(numStr.length()>=3){
            int divisor = Integer.parseInt(String.format("%s%s", numStr.charAt(0), numStr.charAt(numStr.length()-1)));
            return num % divisor == 0;
        }
        return false;
    }

    private boolean checkForPalindrom() {
        boolean isPalindrome = true;
        for (int i = 0 , j = numStr.length()-1 ; i <=numStr.length()/2; i++, j--) {
            if (numStr.charAt(i) != numStr.charAt(j)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    private boolean checkForSquareNumber() {
        final double sqrt = Math.sqrt(num);
        return Math.floor(sqrt) == sqrt;
    }

    private boolean checkForSunnyNumber() {
        final double sqrt = Math.sqrt(num + 1);
        return Math.floor(sqrt) == sqrt;
    }

    private boolean checkForJumpingNumber() {
        int num = Integer.parseInt(String.valueOf(numStr.charAt(0)));
        for (int i = 1; i < numStr.length(); i++) {
            int numCheck = Integer.parseInt(String.valueOf(numStr.charAt(i)));
            if((numCheck + 1) == num || (numCheck -1) == num) {
                num = numCheck;
            }else {
                return false;
            }
        }
        return true;
    }

}

enum Property {
    BUZZ("buzz"),
    DUCK("duck"),
    PALINDROMIC("palindromic"),
    GAPFUL("gapful"),
    SPY("spy"),
    EVEN("even"),
    ODD("odd"),
    SUNNY("sunny"),
    SQUARE("square"),
    JUMPING("jumping"),
    HAPPY("happy"),
    SAD("sad");
    String prop;

    Property(String prop) {
        this.prop = prop;
    }

    public static Boolean isExist(String propStr) {
        if(propStr.isBlank()) {
            return false;
        }

        for(Property item : Property.values()) {
            if(propStr.toLowerCase(Locale.ROOT).replace("-","").equals(item.prop)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkForProperties(String[] prop){
        ArrayList<String> notAvailable = new ArrayList<>();

        if (!arePropertiesAvailable(prop, notAvailable)) {
            return false;
        }else {
            return !isPropertyMutuallyExclusive(prop);
        }
    }

    private static boolean isPropertyMutuallyExclusive(String[] prop) {
        if ((Arrays.asList(prop).contains("square") && Arrays.asList(prop).contains("sunny")) ||
                (Arrays.asList(prop).contains("-square") && Arrays.asList(prop).contains("square")) ||
                (Arrays.asList(prop).contains("-square") && Arrays.asList(prop).contains("-sunny")) ||
                (Arrays.asList(prop).contains("-sunny") && Arrays.asList(prop).contains("sunny"))
        ) {
            System.out.printf("The request contains mutually exclusive properties: [%s, %s]\n" +
                    "There are no numbers with these properties.\n", "SQUARE", "SUNNY");
            return true;
        }
        if (Arrays.asList(prop).contains("odd") && Arrays.asList(prop).contains("even") ||
                (Arrays.asList(prop).contains("odd") && Arrays.asList(prop).contains("-odd")) ||
                (Arrays.asList(prop).contains("-odd") && Arrays.asList(prop).contains("-even")) ||
                (Arrays.asList(prop).contains("even") && Arrays.asList(prop).contains("-even"))
        ) {
            System.out.printf("The request contains mutually exclusive properties: [%s, %s]\n" +
                    "There are no numbers with these properties.\n", "ODD", "EVEN");
            return true;
        }
        if (Arrays.asList(prop).contains("spy") && Arrays.asList(prop).contains("duck") ||
                (Arrays.asList(prop).contains("spy") && Arrays.asList(prop).contains("-spy")) ||
                (Arrays.asList(prop).contains("-spy") && Arrays.asList(prop).contains("-duck")) ||
                (Arrays.asList(prop).contains("duck") && Arrays.asList(prop).contains("-duck"))
        ) {
            System.out.printf("The request contains mutually exclusive properties: [%s, %s]\n" +
                    "There are no numbers with these properties.\n", "SPY", "DUCK");
            return true;
        }
        if (Arrays.asList(prop).contains("happy") && Arrays.asList(prop).contains("sad") ||
                (Arrays.asList(prop).contains("-happy") && Arrays.asList(prop).contains("-sad")) ||
                (Arrays.asList(prop).contains("-happy") && Arrays.asList(prop).contains("happy")) ||
                (Arrays.asList(prop).contains("sad") && Arrays.asList(prop).contains("-sad"))
        ) {
            System.out.printf("The request contains mutually exclusive properties: [%s, %s]\n" +
                    "There are no numbers with these properties.\n", "HAPPY", "SAD");
            return true;
        }

        return false;
    }

    private static boolean arePropertiesAvailable(String[] prop, ArrayList<String> notAvailable) {
        for (String p : prop) {
            if(!isExist(p))
                notAvailable.add(p);
        }

        switch (notAvailable.size()) {
            case 0 : return true;
            case 1 : {
                System.out.printf("The property [%s] is wrong.\n" +
                        "Available properties:\n" +
                        "[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]\n", notAvailable.get(0).toUpperCase(Locale.ROOT));
                return false;
            }
            default: {
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < notAvailable.size(); i++) {
                    if (i == notAvailable.size() - 1) {
                        sb.append(notAvailable.get(i));
                    } else {
                        sb.append(notAvailable.get(i)).append(", ");
                    }
                }

                System.out.printf("The properties [%s] are wrong.\n" +
                        "Available properties:\n" +
                        "[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]\n", sb);
                return false;
            }
        }

    }
}

