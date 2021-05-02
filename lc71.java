package com.csu.wuyitoyibai;

import java.util.Stack;

//力扣71 简化路径
public class lc71 {
    class Solution {
        public String simplifyPath(String path) {
            //使用栈的数据结构实现:
            // 存储路径
            Stack<String> stack = new Stack<>();

            // 分隔
            String[] array = path.split("/");
            for (String str : array) {
                // 忽略
                if (str.equals("") || str.equals(".")) {
                    continue;
                }

                // 后退
                if (str.equals("..")) {
                    // 判断是否为空，不为空，才需要回退
                    if (!stack.empty()) {
                        stack.pop();
                    }
                    // 无论stack空不空，都需要结束
                    continue;
                }
                stack.push(str);
            }

            StringBuilder sb = new StringBuilder();
            for (String str : stack) {
                sb.append("/").append(str);
            }
            if (sb.length() == 0) {
                sb.append("/");
            }
            return sb.toString();
        }
    }
}
