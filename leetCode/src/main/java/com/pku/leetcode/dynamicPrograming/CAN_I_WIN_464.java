package com.pku.leetcode.dynamicPrograming;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by zhaolizhen on 17-8-13.
 */
public class CAN_I_WIN_464 {

    public static void main(String args[]){
        Solution s=new Solution();
//        System.out.println(s.canIWin(10,40));
//        System.out.println(s.canIWin(18,79));
        System.out.println(s.canIWin(10,11));
    }

    private static class Solution {
        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            if (desiredTotal<=0) return true;
            if (maxChoosableInteger*(maxChoosableInteger+1)/2<desiredTotal) return false;
            return canIWin(desiredTotal, new int[maxChoosableInteger], new HashMap<String,Boolean>());
        }
        private boolean canIWin(int total, int[] state, HashMap<String, Boolean> hashMap) {
            String curr=Arrays.toString(state);
            if (hashMap.containsKey(curr)) return hashMap.get(curr);
            for (int i=0;i<state.length;i++) {
                if (state[i]==1) {
                    continue;
                }
                state[i]=1;
                System.out.println(Arrays.toString(state)+"*"+total);
                if (total<=i+1 || !canIWin(total-(i+1), state, hashMap)) {
                    hashMap.put(curr, true);
                    state[i]=0;
                    return true;
                }
                state[i]=0;

            }
            hashMap.put(curr, false);
            return false;
        }
    }

}


