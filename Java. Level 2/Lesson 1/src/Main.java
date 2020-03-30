public class Main {

    /** Классы Human и Cat являются наследниками абстрактного класса Animal. Они отличаются
     * от класса Robot, тем что у них реализована переменная выносливости, которую тратит прыжок
     * или забег. Robot же может сколько угоно выполнять те действия, которые под силу ему за раз.
     * Правильная реализация заключалась бы в создании интерфейса Athlete, который бы имплементировали
     * все участники. Также можно было бы использовать интерфейс Obstacle для препятствий.
     * Использовать общий класс (абстрактный) в задании было запрещено.
     */

    public static void main(String[] args) {
        Object[] participantArray = new Object[5];
        participantArray[0] = new Cat(150, 2, 2);
        participantArray[1] = new Cat(150, 2, 7);
        participantArray[2] = new Cat("Barsik",150, 4, 3);
        participantArray[3] = new Human("Ivan", 200, 3, 19);
        participantArray[4] = new Robot(100, 2);

        Object[] track = new Object[4];
        track[0] = new RunningTrack(20);
        track[1] = new Wall(2);
        track[2] = new RunningTrack(30);
        track[3] = new Wall(3);

        for (int i = 0; i < track.length; i++) {
            int c = 0;
            for (int j = 0; j < participantArray.length; j++) {
                if (participantArray[j] != null &&
                        !(track[i] instanceof RunningTrack && ((RunningTrack) track[i]).usedBy(participantArray[j]) ||
                                track[i] instanceof Wall && ((Wall) track[i]).usedBy(participantArray[j]))) {
                    participantArray[j] = null;
                    c++;
                }
            }
            if (c == participantArray.length) break;;
        }

    }
}
