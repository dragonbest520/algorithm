package com.db520.algorithm.leetcode;

import java.util.*;

/**
 * 127. Word Ladder
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * @author zhuyl
 * @version 2019-06-13
 */
public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        String beginWord2 = "a";
        String endWord2 = "c";
        List<String> wordList2 = new ArrayList<>();
        wordList2.add("a");
        wordList2.add("b");
        wordList2.add("c");

        String beginWord3 = "hot";
        String endWord3 = "dog";
        List<String> wordList3 = new ArrayList<>();
        wordList3.add("hot");
        wordList3.add("dog");

        System.out.println(new WordLadder().ladderLength(beginWord, endWord, wordList));
    }

    //BFS
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) {
            return 0;
        }
        // 此题关键是去重，还有去除和beginWord，相同的单词
        Set<String> set = new HashSet<>(wordList);
        if (set.contains(beginWord))
            set.remove(beginWord);
        Queue<String> wordQueue = new LinkedList<String>();
        int level = 1; // the start string already count for 1
        int curnum = 1;// the candidate num on current level
        int nextnum = 0;// counter for next level
        // 或者使用map记录层数
        // Map<String, Integer> map = new HashMap<String, Integer>();
        // map.put(beginWord, 1);
        wordQueue.add(beginWord);

        while (!wordQueue.isEmpty()) {
            String word = wordQueue.poll();
            curnum--;
            // int curLevel = map.get(word);
            for (int i = 0; i < word.length(); i++) {
                char[] wordunit = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    wordunit[i] = j;
                    String temp = new String(wordunit);

                    if (set.contains(temp)) {
                        if (temp.equals(endWord))
                            // return curLevel + 1;
                            return level + 1;
                        // map.put(temp, curLevel + 1);
                        nextnum++;
                        wordQueue.add(temp);
                        set.remove(temp);
                    }
                }
            }
            if (curnum == 0) {
                curnum = nextnum;
                nextnum = 0;
                level++;
            }
        }
        return 0;
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) {
            return 0;
        }
        int result = 1;

        if (wordList.contains(beginWord)) {
            wordList.remove(beginWord);
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while(!queue.contains(endWord) && !queue.isEmpty()) {
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                String beginTmp = queue.poll();

                for(Iterator<String> it = wordList.iterator();it.hasNext();){
                    String str = it.next();
                    if(compare(beginTmp, str)){
                        it.remove();
                        queue.add(str);
                        if(str.equals(endWord)) {
                            return result + 1;
                        }
                    }
                }
            }
            result++;
        }
        if(queue.isEmpty()) {
            return 0;
        }
        return result;
    }

    public boolean compare(String str1, String str2) {
        int num = 0;
        for (int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                num++;
                if(num > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
