package at.eric;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Random r = new Random();
        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            var num = r.nextInt(1000);
            numList.add(num);
        }
        var res = getTopElements(numList, 7);

        while (!res.isEmpty()) {
            System.out.println(res.poll());
        }
    }

    public static Queue<Integer> getTopElements(List<Integer> list, int size) {
        Queue<Integer> pk = new PriorityQueue<>(Comparator.naturalOrder());

        for (int i = 0; i < list.size(); i++) {
            Integer actual = list.get(i);
            Integer pkHead = pk.peek();
            if (pk.size() < size) {
                pk.add(actual);
            } else {
                if (actual > pkHead) {
                    pk.poll();
                    pk.add(actual);
                }
            }
        }
        return pk;
    }


    public static Queue<Integer> getBottomElements(List<Integer> list, int size) {
        Queue<Integer> pk = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < list.size(); i++) {
            Integer actual = list.get(i);
            Integer pkHead = pk.peek();
            if (pk.size() < size) {
                pk.add(actual);
            } else {
                if (actual < pkHead) {
                    pk.poll();
                    pk.add(actual);
                }
            }
        }
        return pk;
    }
}






