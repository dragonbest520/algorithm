package com.db520.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description Compression Method
 * @Author db520 [dragonbest520@gmail.com]
 * @Date 2017/8/11 15:44
 */
public class Compression {

    public static String runLengthEncoding(String src) {
        src = src + "#";
        List<String> result = new ArrayList<String>();
        List<Character> temp = new ArrayList<Character>();
        char before = src.charAt(0);
        for (int i = 1; i < src.length(); i++) {
            if (src.charAt(i) == before) {
                temp.add(before);
            } else {
                if (temp.size() >= 3) {
                    result.add(temp.get(0) + "#" + (temp.size() + 1) + "#");
                } else {
                    if (temp.isEmpty()) {
                        result.add(String.valueOf(before));
                    } else {
                        StringBuilder temp2 = new StringBuilder();
                        temp2.append(temp.get(0));
                        for (int j = 1; j < temp.size(); j++) {
                            temp2.append(temp.get(j));
                        }
                        temp2.append(before);
                        result.add(temp2.toString());
                    }
                }
                temp = new ArrayList<Character>();
            }
            before = src.charAt(i);
        }

        StringBuilder answer = new StringBuilder(result.get(0));
        for (int i = 1; i < result.size(); i++) {
            answer.append(result.get(i));
        }
        return answer.toString();
    }

    public static String runLengthDecoding(String src) {
        char before = src.charAt(0);
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < src.length(); i++) {
            if (src.charAt(i) == '#') {
                StringBuilder temp = new StringBuilder();
                i++;
                while (src.charAt(i) != '#') {
                    temp.append(src.charAt(i));
                    i++;
                }
                int length = Integer.parseInt(temp.toString());
                for (int j = 0; j < length; j++) {
                    result.append(before);
                }
                if (i < src.length() - 1) {
                    before = src.charAt(++i);
                    if (i == src.length() - 1)
                        result.append(before);
                }
            } else {
                result.append(before);
                before = src.charAt(i);
                if (i == src.length() - 1)
                    result.append(before);
            }
        }
        return result.toString();
    }
}
