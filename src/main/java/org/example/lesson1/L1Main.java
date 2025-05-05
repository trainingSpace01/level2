package org.example.lesson1;

import org.example.lesson1.task3.User;

import java.util.*;

public class L1Main {
    public static void main(String[] args) {
        firstTask();

    }

    public static void thirdTask(){
        ArrayList<User> users = new ArrayList<>();
        //users.add(UUID.randomUUID().toString(), "john", 15, );
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

    // Эффективно по памяти - выделений нет. Время - n Log(n).
    // Быстрее по времени(не факт): создать массив на 10 элементов и сравнивать с наименьшим каждый следующий элемент списка
    // если текущий элемент списка > наименьшего в топе - пробегаемся по топу и находим для него место
    // Как вариант запихать всё в дерево(отсортируется само), но по сути выделяем памяти ещё на такое же кол-во объектов поста
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
