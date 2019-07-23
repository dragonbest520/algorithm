package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 140. Word Break II
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 *
 * @Description WordBreak2
 * @Author zhuyl
 * @Date 2019/7/23 10:07
 **/
public class WordBreak2 {

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        System.out.println(new WordBreak2().wordBreak(s, wordDict));
    }

    List<String> result;
    public List<String> wordBreak(String s, List<String> wordDict) {
        result = new ArrayList<String>();
        int n = s.length();
        //对每一个i都形成一个可以跳跃的点
        List<Integer>[] pointer = new List[n];
        for(int i=0;i<n;i++) pointer[i]=new ArrayList<Integer>();
        //动态规划形成跳跃点
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                //递归的保证j-1可以形成单词，大大地剪枝
                if(wordDict.contains(s.substring(j,i+1))&&(j==0||pointer[j-1].size()>0))
                    pointer[i].add(j);
            }
        }
        //从后往前的递归
        helper(pointer, s, n-1, "");
        return result;
    }

    //DFS
    public void helper(List<Integer>[] pointer, String s, int i, String pattern){
        if(i<0){
            result.add(pattern);
            return;
        }
        for(Integer item:pointer[i]){
            String nextPattern = pattern.length()==0?s.substring(item,i+1):s.substring(item,i+1)+" "+pattern;
            helper(pointer, s, item-1, nextPattern);
        }
    }

    // TLE
    public List<String> wordBreak2(String s, List<String> wordDict) {
        List<String> resultList = new ArrayList<>();
        dfs(s, wordDict, new ArrayList<>(), resultList);
        return resultList;
    }

    public void dfs(String s, List<String> wordDict, List<String> tempList, List<String> resultList) {
        if(s.length() == 0) {
            resultList.add(listToString(tempList, ' '));
        }

        for(String dict : wordDict) {
            if(dict.length() > s.length()) {
                continue;
            } else {
                if(s.substring(0, dict.length()).equals(dict)) {
                    tempList.add(dict);
                    dfs(s.substring(dict.length()), wordDict, tempList, resultList);
                    tempList.remove(tempList.size() - 1);
                } else {
                    continue;
                }
            }
        }
    }

    public String listToString(List list, char separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(separator);
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }
}
