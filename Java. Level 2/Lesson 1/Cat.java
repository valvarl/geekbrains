final class Cat extends Animal {
    private static int catCounter = 0;

    Cat(int stamina, int runUnit, int jumpUnit) {
        super("Cat " + Integer.toString(catCounter), stamina, runUnit, jumpUnit);
        catCounter++;
    }

    Cat(String name, int stamina, int runUnit, int jumpUnit) {
        super(name, stamina, runUnit, jumpUnit);
    }

}
