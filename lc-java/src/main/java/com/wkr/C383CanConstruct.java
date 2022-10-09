package com.wkr;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王锟
 * @Description:
 * @date 2021/12/422:13
 */
public class C383CanConstruct {
    public static void main(String[] args) {
        C383CanConstruct canConstruct = new C383CanConstruct();
        Utils.check(canConstruct.canConstruct2("a", "b")==false, "1 fail");
        Utils.check(canConstruct.canConstruct2("aa", "ab")==false, "1 fail");
        Utils.check(canConstruct.canConstruct2("aa", "aab")==true, "1 fail");

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> lmap = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            lmap.put(ransomNote.charAt(i), lmap.get(ransomNote.charAt(i))==null?1:lmap.get(ransomNote.charAt(i))+1);
        }
        Map<Character, Integer> magmap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            magmap.put(magazine.charAt(i), magmap.get(magazine.charAt(i))==null?1:magmap.get(magazine.charAt(i))+1);
        }
        for (Map.Entry<Character, Integer> entry : lmap.entrySet()) {
            if (magmap.get(entry.getKey()) == null || entry.getValue() > magmap.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }
    public boolean canConstruct2(String ransomNote, String magazine) {
        char[] mchar = new char[26];
        for (int i = 0; i < 26; i++) {
            mchar[i] = 0;
        }
        for (int i = 0; i < magazine.length(); i++) {
            mchar[magazine.charAt(i)-'a'] = (char) (mchar[magazine.charAt(i)-'a']+1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (mchar[ransomNote.charAt(i)-'a'] == 0) {
                return false;
            }
            mchar[ransomNote.charAt(i)-'a'] = (char) (mchar[ransomNote.charAt(i)-'a']-1);
        }
        return true;
    }
}
