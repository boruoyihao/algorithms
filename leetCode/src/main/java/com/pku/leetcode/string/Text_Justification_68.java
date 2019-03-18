package com.pku.leetcode.string;

/**
 * Created by zhaolizhen on 18-9-12.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

 You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

 Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

 For the last line of text, it should be left justified and no extra space is inserted between words.

 Note:

 A word is defined as a character sequence consisting of non-space characters only.
 Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 The input array words contains at least one word.
 Example 1:

 Input:
 words = ["This", "is", "an", "example", "of", "text", "justification."]
 maxWidth = 16
 Output:
 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]
 Example 2:

 Input:
 words = ["What","must","be","acknowledgment","shall","be"]
 maxWidth = 16
 Output:
 [
 "What   must   be",
 "acknowledgment  ",
 "shall be        "
 ]
 Explanation: Note that the last line is "shall be    " instead of "shall     be",
 because the last line must be left-justified instead of fully-justified.
 Note that the second line is also left-justified becase it contains only one word.
 Example 3:

 Input:
 words = ["Science","is","what","we","understand","well","enough","to","explain",
 "to","a","computer.","Art","is","everything","else","we","do"]
 maxWidth = 20
 Output:
 [
 "Science  is  what we",
 "understand      well",
 "enough to explain to",
 "a  computer.  Art is",
 "everything  else  we",
 "do                  "
 ]
 */
public class Text_Justification_68 {

    public static void main(String args[]){
        Solution solution=new Solution();
        String words1[]={"This", "is", "an", "example", "of", "text", "justification."};
        String words2[]={"What","must","be","acknowledgment","shall","be"};

        String words[]={"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"};

        String words4[]={"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};

        int maxwitdth=16;
        List<String>result=solution.fullJustify(words4,maxwitdth);

        for(String str:result){
            System.out.println(str+"**"+str.length());
        }
    }

    private static class Solution{
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String>result=new ArrayList<String>();
            if(maxWidth<=0||words==null||0==words.length){
                return result;
            }

            int i=0,wordStart=0,stringLength=0;
            String[]blankArray=getBlankArray(maxWidth);
            while(i<words.length){
                if(stringLength+words[i].length()+i-wordStart<=maxWidth){
                    stringLength+=words[i].length();
                    i++;
                }else{
                    StringBuilder sb=new StringBuilder(maxWidth);

                    if(i-wordStart==1){
                        sb.append(words[wordStart]);
                        sb.append(blankArray[maxWidth-words[wordStart].length()]);
                    }else {
                        int blankcount = (maxWidth - stringLength) / (i - wordStart-1);
                        int leftcount = (maxWidth - stringLength) % (i - wordStart-1);

//                        System.out.println("wordStart="+wordStart+"i="+i+",blankcount="+blankcount+",leftcount="+leftcount+",stringlength="+stringLength);

                        for (int j = wordStart; j < wordStart+leftcount; j++) {
                            sb.append(words[j]).append(blankArray[blankcount+1]);
                        }

                        for(int j=wordStart+leftcount;j<i-1;j++){
                            sb.append(words[j]).append(blankArray[blankcount]);
                        }
                        sb.append(words[i-1]);
                    }
                    result.add(sb.toString());
                    wordStart=i;
                    stringLength=0;

                }
            }

            StringBuilder sb=new StringBuilder();
            if(i-wordStart==1){
                sb.append(words[wordStart]);
            }else {
                int j = wordStart;
                for (; j < i-1; j++){
                    sb.append(words[j]).append(blankArray[1]);
                }
                sb.append(words[j]);
            }
            sb.append(blankArray[maxWidth-sb.toString().length()]);
            result.add(sb.toString());

            return result;
        }

         String[]getBlankArray(int maxWidth){
            String blankArray[]=new String[maxWidth];

            StringBuilder sb=new StringBuilder();
            for(int i=0;i<blankArray.length;i++){
                blankArray[i]=sb.toString();
                sb.append(' ');
            }
            return blankArray;
        }

    }
}
