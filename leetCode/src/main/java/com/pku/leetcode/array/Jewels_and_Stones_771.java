package com.pku.leetcode.array;

/**
 * Created by zhaolizhen on 19-3-19.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

 The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

 Example 1:

 Input: J = "aA", S = "aAAbbbb"
 Output: 3
 Example 2:

 Input: J = "z", S = "ZZ"
 Output: 0
 Note:

 S and J will consist of letters and have length at most 50.
 The characters in J are distinct.
 */
public class Jewels_and_Stones_771 {
    public static void main(String args[]){
        Solution solution=new Solution();
        System.out.println(solution.numJewelsInStones("aA","aAAbbbb"));
        System.out.println(solution.numJewelsInStones("z","ZZZ"));

    }

    private static class Solution {
        public int numJewelsInStones(String J, String S) {
            Set<Character> mem=new HashSet<Character>();
            for (int i=0;i<J.length();i++){
                mem.add(J.charAt(i));
            }

            int sum=0;
            for (int j=0;j<S.length();j++){
                if (mem.contains(S.charAt(j))){
                    sum++;
                }
            }
            return sum;
        }
    }
}
