package edu.itstep.hw20220914.comparator.Class;

import java.util.Comparator;

public class ComparatorUserCityDesc implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o2.getAddress().getCity().compareTo(o1.getAddress().getCity());
    }
}
