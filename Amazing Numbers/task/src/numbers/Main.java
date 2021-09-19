package numbers;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        write your code here
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to Amazing Numbers!\n");

        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be processed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- a property preceded by minus must not be present in numbers;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");

        boolean exit = false;
        do {
            System.out.println("Enter a request:");

            String allInput = s.nextLine();

            String[] allInputList = allInput.split(" ");

            try{
                long input = Long.parseLong(allInputList[0]);

                if (input != 0) {
                    NumberTest numberTest = new NumberTest(input);

                    if(NumberTest.checkForNaturalNumber(input,"first")) {
                        switch (allInputList.length){
                            case 1 : {
                                numberTest.checkNumber();
                                break;
                            }
                            case  2 : {
                                final long secondInput = Long.parseLong(allInputList[1]);
                                if(NumberTest.checkForNaturalNumber(secondInput,"second"))
                                    numberTest.checkNumbers(secondInput);
                                break;
                            }
                            case 3 : {
                                final long secondInput = Long.parseLong(allInputList[1]);
                                if(NumberTest.checkForNaturalNumber(secondInput,"second")) {
                                    final String thirdInput = allInputList[2];
                                    if(NumberTest.checkForProperty(thirdInput))
                                        numberTest.filterNumberAccordingToProperty(secondInput,thirdInput.toUpperCase(Locale.ROOT));
                                }
                                break;
                            }
                            default: {
                                final long secondInput = Long.parseLong(allInputList[1]);
                                if(NumberTest.checkForNaturalNumber(secondInput,"second")) {
                                    if(Property.checkForProperties(Arrays.copyOfRange(allInputList,2,allInputList.length))) {
                                        numberTest.filterNumberAccordingToProperties(secondInput,
                                                Arrays.copyOfRange(allInputList,2,allInputList.length));
                                    }
                                }
                            }
                            break;
                        }

                    }
                }else {
                    System.out.println("Goodbye!");
                    exit = true;
                }
            }catch (NumberFormatException e) {
                System.out.println("The first parameter should be a natural number or zero.\n");
            }

        }while (!exit);

    }
}
