package tasks.five.a;

import java.util.ArrayList;
import java.util.List;

/** Блокнот. Хранит дни, а в каждом дне может быть несколько записей */
public class Notepad {
    private List<Day> days = new ArrayList<>();

    public void addEntry(String date, String text) {
        Day day = findDay(date);
        if (day == null) {
            day = new Day(date);
            days.add(day);
        }
        day.addEntry(text);
    }

    public void printByDate(String date) {
        Day day = findDay(date);
        if (day == null) {
            System.out.println("На эту дату записей нет");
        } else {
            System.out.println(day);
        }
    }

    public void printAll() {
        if (days.isEmpty()) {
            System.out.println("Блокнот пуст");
        }
        for (Day day : days) {
            System.out.println(day);
        }
    }

    private Day findDay(String date) {
        for (Day day : days) {
            if (day.date.equals(date)) {
                return day;
            }
        }
        return null;
    }

    /** Внутренний класс: день со списком записей */
    private class Day {
        private String date;
        private List<Entry> entries = new ArrayList<>();

        private Day(String date) {
            this.date = date;
        }

        private void addEntry(String text) {
            entries.add(new Entry(text));
        }

        @Override
        public String toString() {
            String result = date + ":";
            for (Entry entry : entries) {
                result += "\n  " + entry;
            }
            return result;
        }
    }

    /** Внутренний класс: одна запись */
    private class Entry {
        private String text;

        private Entry(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
