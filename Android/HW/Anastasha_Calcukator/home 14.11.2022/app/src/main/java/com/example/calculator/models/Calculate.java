package com.example.calculator.models;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculate {

    private String textView;

    public String getTextView() {
        return textView;
    }

    public void setTextView(String textView) {
        this.textView = textView;
    }

    public String start(){
        String[] chars = textView.split("[\\d()]");
        String calc = textView;
        if(textView.contains("(")){
            chars = textView.split("(([-+*\\/]?[0-9]*[.,]?[0-9]){2,})");
            String char_temp = String.join("", chars);
            chars = char_temp.split("[\\d()]");
        }
        else if(textView.contains("^")){
            Pattern p = Pattern.compile("([\\d])");
            Matcher m = p.matcher(calc);
            List<String> numbers = new ArrayList<>();
            while(m.find()){
                numbers.add(m.group(1));
            }
            int i = 0;
            double res = 0;
            for (String num: numbers) {
                if(i == 1){
                    res = Math.pow(res, Double.parseDouble(num));
                }
                else{
                    res = Double.parseDouble(num);
                    i++;
                }
            }
            calc = String.valueOf(res);
            return calc;
        }

        boolean priority3 = false;
        boolean priority2 = false;
        boolean priority1 = false;

        char first = calc.charAt(0);
        if (first == '-') {
            String[] temp = new String[chars.length - 1];
            for (int i = 1; i < chars.length; i++) {
                temp[i - 1] = chars[i];
            }
            chars = temp;
        }
        if(calc.contains("(") || calc.contains(")")){
            String[] temp = new String[chars.length + 1];
            for (int i = 0; i < chars.length; i++) {
                temp[i] = chars[i];
            }
            temp[chars.length] = "(";
            chars = temp;
        }
        for (String ch : chars) {
            if(ch.equals("+") || ch.equals("-")){
                priority3 = true;
            }
            if(ch.equals("*") || ch.equals("/")){
                priority2 = true;
            }
            if(ch.equals("(")){
                priority1 = true;
            }
        }

        if (textView.length() > 1) {
            if (priority1 == true) {
                String result = setPriority1(calc);
                calc = calc.replace(calc, result);
            }
            if (priority2 == true) {
                for (String ch: chars) {
                    String result = setPriority2(calc, ch);
                    calc = calc.replace(calc, result);
                }
            }
            if (priority3 == true) {
                for (String ch: chars) {
                    String result = setPriority3(calc, ch);
                    calc = calc.replace(calc, result);
                }
            }
        }
        return calc;
    }

    public static String setPriority1(String string){
        Pattern p = Pattern.compile("(([-+*\\/]?[0-9]*[.,]?[0-9]){2,})");
        Matcher m = p.matcher(string);
        List<String> d = new ArrayList<>();
        while(m.find()){
            d.add(m.group(1));
        }

        for (String s: d) {
            String s_first = s;
            while(s.contains("*") || s.contains("/") || s.contains("+") || s.contains("-")){
                Pattern p1 = Pattern.compile("(([+-]?[0-9]*[.,]?[0-9][*\\/][0-9]*[.,]?[0-9]))");
                Matcher m1 = p1.matcher(s);
                Pattern p2 = Pattern.compile("(([+-]?[0-9]*[.,]?[0-9][+-][0-9]*[.,]?[0-9]))");
                Matcher m2 = p2.matcher(s);
                if(m1.find()){
                    String match = m1.group(1);
                    Pattern p3 = Pattern.compile("([+\\-/*])");
                    Matcher m3 = p3.matcher(match);
                    if(m3.find()){
                        String result = setPriority2(match, m3.group(1));
                        s = s.replace(match, result);
                    }
                }
                else if(m2.find()){
                    String match = m2.group(1);
                    Pattern p3 = Pattern.compile("([+\\-/*])");
                    Matcher m3 = p3.matcher(match);
                    if(m3.find()){
                        String result = setPriority3(match, m3.group(1));
                        s = s.replace(match, result);
                    }
                }
            }
            string = string.replace(s_first, s);
        }
        String[] str = string.split("[(\\()\\)]");
        String temp3 = "";
        for (String t : str) {
            temp3 += t;
        }
        string = temp3;
        return string;
    }

    public static String setPriority2(String res, String ch) {
        if (ch.equals("*")) {
            Pattern p1 = Pattern.compile("([-]?[0-9]*[.,]?[0-9]\\*[-+]?[0-9]*[.,]?[0-9])");
            Matcher m1 = p1.matcher(res);
            String[] num = res.split("[(\\()\\)]");
            res = String.join("", num);
            String number = "";
            if (m1.find()) {
                number = m1.group(1);
            }
            String[] str = number.split("\\*");
            List<String> numbers = new ArrayList<>();
            for (String n : str) {
                numbers.add(n);
            }
            int i = 0;
            double result = 0;
            for (String n : numbers) {
                if (i == 1) {
                    result = result * Double.parseDouble(n);
                } else {
                    result = Double.parseDouble(n);
                    i++;
                }
            }
            res = res.replace(number, String.valueOf(result));
        } else if (ch.equals("/")) {
            Pattern p1 = Pattern.compile("([-]?[0-9]*[.,]?[0-9]/[-+]?[0-9]*[.,]?[0-9])");
            Matcher m1 = p1.matcher(res);
            String[] num = res.split("[(\\()\\)]");
            res = String.join("", num);
            String number = "";
            if (m1.find()) {
                number = m1.group(1);
            }
            String[] str = number.split("/");
            List<String> numbers = new ArrayList<>();
            for (String n : str) {
                numbers.add(n);
            }
            int i = 0;
            double result = 0;
            for (String n : numbers) {
                if (i == 1) {
                    result = result / Double.parseDouble(n);
                } else {
                    result = Double.parseDouble(n);
                    i++;
                }
            }
            res = res.replace(number, String.valueOf(result));
        }
        return res;
    }

    public static String setPriority3(String res, String ch) {
        if (ch.equals("-")) {
            Pattern p1 = Pattern.compile("([-]?[0-9]*[.,]?[0-9]-[-+]?[0-9]*[.,]?[0-9])");
            Matcher m1 = p1.matcher(res);
            String[] num = res.split("[(\\()\\)]");
            res = String.join("", num);
            String number = "";
            if (m1.find()) {
                number = m1.group(1);
                String[] str = number.split("-");
                List<String> numbers = new ArrayList<>();
                for (String n : str) {
                    numbers.add(n);
                }
                double result = 0;
                int i = 0;
                for (String n : numbers) {
                    if (i == 1) {
                        result = result - Double.parseDouble(n);
                    } else {
                        result = Double.parseDouble(n);
                        i++;
                    }
                }
                res = res.replace(number, String.valueOf(result));
            }
        } else if (ch.equals("+")) {
            Pattern p1 = Pattern.compile("([-]?[0-9]*[.,]?[0-9]\\+[-+]?[0-9]*[.,]?[0-9])");
            Matcher m1 = p1.matcher(res);
            String[] num = res.split("[(\\()\\)]");
            res = String.join("", num);
            String number = "";
            if (m1.find()) {
                number = m1.group(1);
            }
            String[] str = number.split("\\+");
            List<String> numbers = new ArrayList<>();
            for (String n : str) {
                numbers.add(n);
            }
            double result = 0;
            int i = 0;
            for (String n : numbers) {
                if (i == 1) {
                    result = result + Double.parseDouble(n);
                } else {
                    result = Double.parseDouble(n);
                    i++;
                }
            }
            res = res.replace(number, String.valueOf(result));
        }
        return res;
    }
}
