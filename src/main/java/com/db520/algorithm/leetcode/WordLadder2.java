package com.db520.algorithm.leetcode;

import java.util.*;

/**
 * 126. Word Ladder II
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * @Description WordLadder2
 * @Author zhuyl
 * @Date 2019/7/16 9:49
 **/
public class WordLadder2 {

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

        System.out.println(new WordLadder2().findLadders(beginWord, endWord, wordList));
    }


    Map<String,List<String>> map;
    List<List<String>> results;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //方法一：dfs，超时

        //方法二：
        results = new ArrayList<>();
        if(wordList.size() == 0 || !wordList.contains(endWord)) return results;

        //记录最小步数
        int min = Integer.MAX_VALUE;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        map = new HashMap<String,List<String>>();
        //用来记录每个string出现的最小步数
        Map<String,Integer> ladder = new HashMap<>();

        for(String string : wordList){
            ladder.put(string,Integer.MAX_VALUE);
        }
        ladder.put(beginWord,0);

        while(!queue.isEmpty()){
            String word = queue.poll();
            int step = ladder.get(word) + 1;
            if(step > min) //如果大于最小步数，直接跳出循环
                break;

            for(int i=0;i<word.length();i++){
                StringBuilder sb = new StringBuilder(word);
                for(char c = 'a';c<='z';c++){
                    sb.setCharAt(i,c);
                    String new_word = sb.toString();
                    if(ladder.containsKey(new_word)){
                        //只有第一次遍历到的new_word才回加入到queue/map,因为step是非递减的
                        if(step > ladder.get(new_word))
                            continue;
                        else if(step < ladder.get(new_word)){
                            queue.add(new_word);
                            ladder.put(new_word,step);
                        }
                        //map中值存放word的所有前一个元素
                        if(map.containsKey(new_word))
                            map.get(new_word).add(word);
                        else{
                            List<String> list = new LinkedList<String>();
                            list.add(word);
                            map.put(new_word,list);
                        }
                        if(new_word.equals(endWord))
                            min = step;
                    }
                }
            }

        }

        // 只能用LinkedList，不能用ArrayList。原因见backTrace方法
        LinkedList<String> result = new LinkedList<String>();
        backTrace(endWord, beginWord, result);
        return results;
    }

    //dfs递归 map拼接为list
    private void backTrace(String word, String start, List<String> list) {
        if (word.equals(start)) {
            list.add(0, start);
            results.add(new ArrayList<String>(list));
            //回退一位
            list.remove(0);
            return;
        }
        // 注意：这里的list是LinkedList类型，所以插入index=0的位置，其余元素全部后移
        // 如果是ArrayList，会把0处的元素替换
        list.add(0, word);
        if (map.get(word) != null)
            for (String s : map.get(word))
                backTrace(s, start, list);
        //回退一位
        list.remove(0);
    }
}
