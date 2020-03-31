public class Wall {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    boolean usedBy(Object object) {
        if (object instanceof Animal) {
            return ((Animal) object).jump(height);
        } else if (object instanceof Robot) {
            return ((Robot) object).jump(height);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
