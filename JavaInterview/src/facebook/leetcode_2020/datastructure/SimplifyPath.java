package facebook.leetcode_2020.datastructure;

import java.util.Stack;

public class SimplifyPath {


    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";
        String ans = new SimplifyPath().simplifyPath(path);
        System.out.println(ans);
    }


    public String simplifyPath(String path) {
        if (path == null || path.trim().isEmpty()) {
            return path;
        }

        Stack<String> stack = new Stack<String>();
        String[] components = path.split("/");
        StringBuilder sb = new StringBuilder();

        for (String directory : components) {
            // current directory .
            if (directory.isEmpty() || directory.equals(".")) {
                continue;
            }
            // previous directory ..
            else if (directory.equals("..")) {
                // if stack is not empty then go to previous directory
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(directory);
            }
        }

        for (String dir : stack) {
            sb.append("/");
            sb.append(dir);
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }
}
