import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = ArrayInit(20, new String[]{"A", "B", "C", "D"});
        ListInfo(list);
    }

    private static void ListInfo(List<String> list){
        System.out.println(list);
        LinkedHashMap<String, Integer> map = MapGenerator(list);
        System.out.println("Uniq elements: " + map.keySet());
        System.out.println("Stats: " + map);
    }

    private static LinkedHashMap<String, Integer> MapGenerator(List<String> list){
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String str : list){
            Integer value = map.putIfAbsent(str, 1);
            if (value != null) {
                map.put(str, value + 1);
            }
        }
        return  map;
    }

    private static ArrayList<String> ArrayInit(int len, String[] str){
        ArrayList<String> list = new ArrayList<>(len);
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            list.add(str[random.nextInt(str.length)]);
        }
        return list;
    }
}
