package edu.itstep.cw20220914_analysis.comparator;

import java.util.Comparator;

public class ComparatorUserAgeDesc implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o2.getAge() - o1.getAge();
    }
}
