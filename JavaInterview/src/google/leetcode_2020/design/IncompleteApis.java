package google.leetcode_2020.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IncompleteApis {


    class Log {
        int timestamp;
        String api;
        String eventType;
    }

    public void solution(List<Log> logs, int maxAllowed) {
        Map<String, Integer> map = new HashMap<>();
        List<String> slow = new ArrayList<>();

        for (Log log : logs) {
            if (log.eventType.equals("start")) {
                map.put(log.api, log.timestamp);
            } else {
                int start = map.get(log.api);
                if (log.timestamp - start > maxAllowed) {
                    slow.add(log.api);
                }
                map.remove(log.api);
            }
        }

        List<String> incomplete = new ArrayList<>(map.keySet());
    }
}
