public class Robot {
    private static int robotModel = 0;
    private final String name;
    private final int runLimit;
    private final int jumpLimit;

    public Robot(int runLimit, int jumpLimit) {
        this.name = "Model " + Integer.toString(robotModel);
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        robotModel++;
    }

    private boolean action(int score, int limit, String action) {
        if (score < 0) throw new IllegalArgumentException();
        if (limit >= score) {
            System.out.println(name + " successfully completed a " + action + ".");
            return true;
        } else {
            System.out.println(name + " can't complete a " + action + ".");
            return false;
        }
    }

    boolean run(int distance) {
        return action(distance, runLimit, "run");
    }

    boolean jump(int height) {
        return action(height, jumpLimit, "jump");
    }
}
