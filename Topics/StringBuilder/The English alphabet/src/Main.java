class EnglishAlphabet {

    public static StringBuilder createEnglishAlphabet() {
        // write your code here
        StringBuilder sb = new StringBuilder();
        char init = 'A';
        for (int i = 0; i < 26; i++) {
            sb.append(init++);
            if (i != 25) {
                sb.append(" ");
            }
        }
        return sb;
    }

    public static void main(String[] args) {
        System.out.println(createEnglishAlphabet());
    }
}
