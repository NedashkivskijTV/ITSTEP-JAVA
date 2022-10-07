package edu.itstep.cw20220921;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main6 {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(202);
        set.add(202);
        set.add(3);
        set.add(37);
        set.add(4);
        set.add(14);
        set.add(5);

        System.out.println(set);

    }
}
