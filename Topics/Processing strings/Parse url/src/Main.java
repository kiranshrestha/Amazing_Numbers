import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);

        String[] parse = s.nextLine().split("\\?");
        String[] url = parse[1].split("&");
        StringBuilder password = new StringBuilder("password : ");
        boolean passFound = false;
        for (String str :
                url) {
            String extract = str.replace("=", " : ");
            if(extract.contains("pass")){
                 password.append(extract.split(" : ")[1]);
                 passFound = true;
            }
            if(extract.charAt(extract.length() -2) == ':')
                extract += "not found";
            System.out.println(extract);
        }
        if(passFound)
            System.out.println(password);
    }
}