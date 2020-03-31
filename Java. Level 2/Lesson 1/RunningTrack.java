public class RunningTrack {
    private final int distance;

    public RunningTrack(int distance) {
        this.distance = distance;
    }

    boolean usedBy(Object object) {
        if (object instanceof Animal) {
            return ((Animal) object).run(distance);
        } else if (object instanceof Robot) {
            return ((Robot) object).run(distance);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
