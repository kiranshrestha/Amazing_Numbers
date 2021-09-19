import java.util.Locale;

public class Main {

    public static void main(String[] args) {
    // write your program here
        int count = 0;
        for (Secret s:
             Secret.values()) {
            if(s.name().toLowerCase(Locale.ROOT).contains("star")) {
                count++;
            }
        }
        System.out.println(count);
    }
}

// sample enum for inspiration
/*   enum Secret {
    STAR, CRASH, START, // ...
}*/
