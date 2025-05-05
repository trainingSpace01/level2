package org.example.lesson1;
import org.example.lesson1.task3.PhoneType;
import org.example.lesson1.task3.User;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class L1Main {
    public static void main(String[] args) {
        //firstTask();
        //thirdTask();
    }

    public static void thirdTask(){
        ArrayList<User> users = new ArrayList<>();
        int checkAge = 58;
        String checkName = "John";
        for (int i = 0; i < 6; i++)
            users.add(new User(i));
        users.forEach(System.out::println);
        System.out.println(users.stream().
                                        filter(x -> Objects.equals(x.getName(), checkName)).
                                        collect(Collectors.summarizingInt(User::getAge)).getSum());
        System.out.println("Anyone age > " + checkAge + " is " + users.
                                                                    stream().
                                                                    anyMatch(x -> x.getAge() > checkAge));
        System.out.println(users.stream().flatMap(x -> Stream.of(x.getName())).
                collect(Collectors.toCollection(LinkedHashSet::new)).toString());
        System.out.println(users.stream().
                collect(Collectors.toMap(User::getUniqueID, User::getName)));
        System.out.println(users.stream().
                collect(Collectors.groupingBy(User::getAge)));
        System.out.println(users.stream().
                filter(x -> x.getPhones() != null)
                .flatMap(x -> Stream.of(x.getPhones())).
                flatMap(phones -> phones.stream().flatMap(y -> Stream.of(y.getNumber()))).
                collect(Collectors.toList()));
        System.out.println(users.stream().
                filter(x -> x.getPhones().stream().anyMatch(y -> y.getPhoneType() == PhoneType.STATIONARY)).
                max(Comparator.comparingInt(User::getAge)));
    }

    public static void firstTask(){
        List<String> input = new ArrayList<>();
        input.add("Ivan 5");
        input.add("Petr 3");
        input.add("Alex 10");
        input.add("Petr 8");
        input.add("Ivan 6");
        input.add("Alex 5");
        input.add("Ivan 1");
        input.add("Petr 5");
        input.add("Alex 1");
        showWinner(input);
    }

    public static void showWinner(List<String> competitors){
        HashMap<String, Integer> championMap = new HashMap<>();
        String winnerName = null;
        String key;
        int value;
        for (String iter: competitors) {
            key = iter.split(" ")[0];
            value = Integer.parseInt(iter.split(" ")[1]);
            if (championMap.containsKey(key)) {
                championMap.replace(key, championMap.get(key) + value);
            } else {
                championMap.put(key, value);
            }
            if (winnerName == null || (championMap.get(key) > championMap.get(winnerName))) {
                winnerName = key;
            }
        }
        System.out.println(winnerName);
    }

    public static List<Post> getTop10(List<Post> posts){
        PriorityQueue<Post> postsQueue = new PriorityQueue<>();
        postsQueue.addAll(posts);
        return postsQueue.stream().toList().subList(postsQueue.size(), postsQueue.size() - 10);
    }

    public class Post implements Comparable<Post>{
        private String text;
        private Integer likesCount;

        public boolean Compare(int likesCompareTo) {
            if (this.likesCount >= likesCompareTo)
                return false;
            return true;
        }

        @Override
        public int compareTo(Post o) {
            if (this.likesCount > o.likesCount)
                return 1;
            if (this.likesCount.equals(o.likesCount))
                return 0;
            return -1;
        }
    }
}
