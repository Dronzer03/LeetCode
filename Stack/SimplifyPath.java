package Stack;

import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        String result = "";
        String[] pathArray = path.split("/");
        Stack<String> pathStack = new Stack<>();
        for (String s : pathArray) {
            if (s.isBlank() || s.equals("."))
                continue;
            if (s.equals("..")) {
                if (!pathStack.isEmpty())
                    pathStack.pop();
                else continue;
            }
            else
                pathStack.add(s);
        }
        if (pathStack.isEmpty())
            return "/";
        while (!pathStack.isEmpty()) {
            result = "/" + pathStack.pop() + result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}
