package com.pku.leetcode.hash;

/**
 * Created by zhaolizhen on 18-4-8.
 */

import java.util.*;

/**
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

 Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

 Example 1:
 Input: [1,3,2,2,5,2,3,7]
 Output: 5
 Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 Note: The length of the input array will not exceed 20,000.
 */
public class Longest_Harmonious_Subsequence_594 {

    public static void main(String args[]){
//        int nums[]={1,3,2,2,5,2,3,7};
        int nums[]={3,2,2,2,2,2,2,2};

        Solution solution=new Solution();
        System.out.println(solution.findLHS(nums));
    }

    //Accepted but not perfact
    private static class Solution1 {
        public int findLHS(int[] nums) {
            if(null==nums||0==nums.length){
                return 0;
            }

            Map<Integer,Integer> mem=new HashMap<Integer,Integer>();
            for(int no:nums){
                if(!mem.containsKey(no)){
                    mem.put(no,1);
                }else{
                    mem.put(no,mem.get(no)+1);
                }
            }

            List<Integer> list=new ArrayList(mem.keySet());
            Collections.sort(list);

            int result=0;
            for(int i=1;i<list.size();i++){
                if(list.get(i)-list.get(i-1)==1){
                    result=Math.max(result,mem.get(list.get(i))+mem.get(list.get(i-1)));
                }
            }
            return result;
        }
    }

    private static class Solution2 {
        public int findLHS(int[] nums) {
            if(null==nums||0==nums.length){
                return 0;
            }

            int result=0;

            Map<Integer,Integer> mem=new HashMap<Integer,Integer>();
            for(int no:nums){
                if(!mem.containsKey(no)){
                    mem.put(no,1);
                }else{
                    mem.put(no,mem.get(no)+1);
                }

            }

            for(int no:nums){
                if(mem.get(no-1)!=null) {
                    result = Math.max(result, mem.get(no - 1)+mem.get(no));
                }
                if(mem.get(no+1)!=null) {
                    result = Math.max(result, mem.get(no + 1)+mem.get(no));
                }

            }
            return result;
        }
    }

    private static class Solution {
        public int findLHS(int[] nums) {
            HashMap < Integer, Integer > map = new HashMap < Integer,Integer> ();
            int res = 0;
            for (int num: nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (map.containsKey(num + 1))
                    res = Math.max(res, map.get(num) + map.get(num + 1));
                if (map.containsKey(num - 1))
                    res = Math.max(res, map.get(num) + map.get(num - 1));
            }
            return res;
        }
    }

}
