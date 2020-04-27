package facebook.leetcode_2020.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    public static void main(String[] args) {
        String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        GroupShiftedStrings g = new GroupShiftedStrings();
        System.out.println(g.groupStrings(strings));
    }

    // Time: O(n);n = strings
    public List<List<String>> groupStrings(String[] strings) {
        if (strings == null || strings.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> patternGroups = new HashMap<>();
        for (String str : strings) {

            // Step 1. find pattern
            String pattern = getPattern(str);

            // Step 2. Put into map by pattern
            patternGroups.putIfAbsent(pattern, new ArrayList<>());
            patternGroups.get(pattern).add(str);
        }
        return new ArrayList<>(patternGroups.values());
    }

    private String getPattern(String string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < string.length(); i++) {
            int diff = string.charAt(i) - string.charAt(i - 1);
            sb.append(diff < 0 ? diff + 26 : diff);
            sb.append(",");
        }
        return sb.toString();
    }
}
