package org.example.collection;

import java.util.List;

public class Util {
    public static int getSum(List<Integer> list) {
        int sum = 0;
        for(int item : list){
            sum += item;
        }

        return sum;
    }

    public static void removeLastItem(List<Integer> list) {
        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
    }
}
