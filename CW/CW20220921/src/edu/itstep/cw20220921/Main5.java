package edu.itstep.cw20220921;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main5 {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();
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
