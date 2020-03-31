import java.util.LinkedHashSet;
import java.util.TreeMap;

class PhoneBook {
    private TreeMap<String, LinkedHashSet<String>> dictionary = new TreeMap<>();

    void add(String surname, String phoneNumber){
        LinkedHashSet<String> set = dictionary.putIfAbsent(surname, new LinkedHashSet<>());
        if (set != null) { set.add(phoneNumber); }
        else { dictionary.get(surname).add(phoneNumber); }
    }

    LinkedHashSet<String> get(String surname){
        LinkedHashSet<String> set = dictionary.get(surname);
        if (set != null) return set;
        else return new LinkedHashSet<String>();
    }
}
