abstract class Animal {
    private String name = "Creature";
    private int stamina;
    private final int runUnit;
    private final int jumpUnit;

    Animal(String name, int stamina, int runUnit, int jumpUnit) {
        this.name = name;
        this.stamina = stamina;
        this.runUnit = runUnit;
        this.jumpUnit = jumpUnit;
    }

    private void action(int score, int unit, String action) {
        if (score < 0) throw new IllegalArgumentException();
        if (stamina > score*unit) {
            System.out.println(name + " successfully completed a " + action + ".");
            stamina -= score*unit;
        } else {
            System.out.println(name + " fell down exhausted, his stamina ended.");
            stamina = 0;
        }
    }

    boolean run(int score){
        this.action(score, runUnit, "run");
        return stamina != 0;
    }

    boolean jump(int score){
        this.action(score, jumpUnit, "jump");
        return stamina != 0;
    }

    public int getStamina() {
        return stamina;
    }
}
