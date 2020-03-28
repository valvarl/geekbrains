final class Human extends Animal{
    private static int humanCounter = 0;

    Human(int stamina, int runUnit, int jumpUnit) {
        super("Human " + Integer.toString(humanCounter), stamina, runUnit, jumpUnit);
        humanCounter++;
    }

    Human(String name, int stamina, int runUnit, int jumpUnit) {
        super(name, stamina, runUnit, jumpUnit);
    }
}
