package edu.itstep.cw20220915.enums;

/**
 * Клас - замінник конструкції ENUM
 * - до виникнення ENUM використовувались для роботи з константними значеннями
 */
public class DayOfWeek {

    private String title;

    private DayOfWeek(String title) {
        this.title = title;
    }

    public static DayOfWeek SUNDAY = new DayOfWeek("Неділя");
    public static DayOfWeek MONDAY = new DayOfWeek("Понеділок");
    public static DayOfWeek TUESDAY = new DayOfWeek("Вівторок");
    public static DayOfWeek WEDNESDAY = new DayOfWeek("Середа");
    public static DayOfWeek THURSDAY = new DayOfWeek("Четвер");
    public static DayOfWeek FRIDAY = new DayOfWeek("П'ятниця");
    public static DayOfWeek SATURDAY = new DayOfWeek("Субота");

    @Override
    public String toString() {
//        return "DayOfWeek{" +
//                "title='" + title + '\'' +
//                '}';
        return title;
    }
}
