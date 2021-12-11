package com.bentozord.validator;

import java.util.ArrayDeque;
import java.util.Deque;

class ParenthesesValidator {

    public static Boolean validateParentheses(String input) {
        if (input.length() % 2 != 0) return false; //uneven can't be valid

        Deque<Character> deque = new ArrayDeque<>();

        for (Character c : input.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') deque.push(c);
            else if (c == '}' && !deque.isEmpty() && deque.peek() == '{') deque.pop(); //peek() could produce NPE without isEmpty check
            else if (c == ')' && !deque.isEmpty() && deque.peek() == '(') deque.pop();
            else if (c == ']' && !deque.isEmpty() && deque.peek() == '[') deque.pop();
            else deque.push(c); //when double closing
        }

        return deque.isEmpty();
    }
}
