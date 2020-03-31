import java.util.Random;

public class PhoneBookTest {
    public static void main(String[] args) {
        String[] surnames = new String[]{"Ivanov", "Petrov", "Kuznetsov", "Stepanov", "Dobrolyubov"};
        PhoneBook book = PhoneBookInit(10, surnames);
        PhoneBookPrint(book, surnames);
    }

    private static PhoneBook PhoneBookInit(int records, String[] surnames){
        Random random = new Random();
        PhoneBook book = new PhoneBook();
        for (int i = 0; i < records; i++) {
            book.add(surnames[random.nextInt(surnames.length)],
                    Integer.toString(2_000_000 + random.nextInt(1_000_000)));
        }
        return book;
    }

    private static void PhoneBookPrint(PhoneBook book, String[] surnames){
        for (String s : surnames) {
            System.out.printf("%s: %s\n", s, book.get(s));
        }
    }
}
