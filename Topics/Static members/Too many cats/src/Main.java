class Cat {

    // write static and instance variables
    public static int counter = 0;

    String name;
    int age;

    public Cat(String name, int age) {
        // implement the constructor
        // do not forget to check the number of cats

        this.name = name;
        this.age = age;
        if (getNumberOfCats() >= 5) {
            System.out.println("You have too many cats");
        }
        counter++;

    }

    public static int getNumberOfCats() {
        // implement the static method
        return counter;
    }

}
