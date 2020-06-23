package amazon.oa;

import java.util.*;

public class S2 {


    public static void main(String[] args) {
        List<Character> inputList = List.of('a', 'b', 'a', 'b', 'c', 'b', 'a', 'c', 'a',
                'd', 'e', 'f', 'e', 'g', 'd', 'e', 'h', 'i', 'j', 'h', 'k', 'l', 'i', 'j');

        var ans = lengthEachScene(inputList);
        System.out.println(ans);
    }


    static List<Integer> lengthEachScene(List<Character> inputList) {
        if (inputList == null) {
            return Collections.emptyList();
        }
        List<Integer> sceneLengths = new ArrayList<>();
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < inputList.size(); i++) {
            charCount.put(inputList.get(i), i);
        }

        int left = 0;
        int right = 0;

        for (int i = 0; i < inputList.size(); i++) {
            right = Math.max(right, charCount.get(inputList.get(i)));
            if (right == i) {
                sceneLengths.add(1 + right - left);
                left = right + 1;
            }
        }
        return sceneLengths;
    }
}


// {
//         map<char, int> m;
//        for (int i = 0; i < S.size(); i++)
//        {
//        m[S[i]] = i;
//        }
//
//        vector<int> result;
//        int left = 0;
//        int right = 0;
//        for (int i = 0; i < S.size(); i++)
//        {
//        right = max(right, m[S[i]]);
//        if (right == i)
//        {
//        result.push_back(1 + right - left);
//        left = right + 1;
//        }
//        }
//        return result;
//        }
//        };