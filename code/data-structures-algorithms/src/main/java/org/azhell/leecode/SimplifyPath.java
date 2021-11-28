package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 71. 简化路径
 * 路径问题一般可以使用栈来解题
 */
public class SimplifyPath {
    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        Utils.print(simplifyPath.simplifyPath("/a/./b/../../c/"));
        Utils.print(simplifyPath.simplifyPath("/../"));
        Utils.print(simplifyPath.simplifyPath("/home/"));
        Utils.print(simplifyPath.simplifyPath("/home//foo/"));
    }

    public String simplifyPath(String path) {
        // 首先处理路径中的“//”
        path = path.replace("//", "/");
        // 切割
        String[] pathArr = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String s : pathArr) {
            if (!s.isEmpty() && !".".equals(s)) {
                // "."表示当前目录，即无需操作
                if ("..".equals(s)) {// 返回上一层目录，出栈
                    if (!stack.isEmpty())
                        stack.pop();
                } else {// 其他类型都是进入，入栈
                    stack.push(s);
                }
            }
        }
        int size = stack.size();
        if (size == 0) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("/").append(stack.removeLast());
        }
        return sb.toString();
    }
}
