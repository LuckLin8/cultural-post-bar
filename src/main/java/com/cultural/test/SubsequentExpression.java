package com.cultural.test;

import java.util.ArrayList;
import java.util.Stack;

public class SubsequentExpression {

    public static void main(String[] args) {
        ArrayList<Character> calculationList = new ArrayList();
        Stack stack = new Stack();
        String expression = new String("1+(2*(3+4)-5*2)-3");
        for(int i=0;i<expression.length();i++){
            char item =  expression.charAt(i);
            if(Character.isDigit(item)){
                calculationList.add(item);
            }else if(item == '('){
                stack.push(item);
            }else if(item == ')'){
                char t = ' ';
                while(!stack.empty()){
                    t = (char)stack.pop();
                    if(t == '('){
                        break;
                    }
                    calculationList.add(t);
                }
            }else {
                if(!stack.empty()){
                    if(item == '*'||item =='/'){
                        if((char)stack.peek() == '*'||(char)stack.peek() == '/'){
                            char t = (char)stack.pop();
                            calculationList.add(t);
                        }
                        stack.push(item);
                    }else if(item == '+'||item =='-'){
                        if((char)stack.peek() == '+'||(char)stack.peek() == '-'){
                            char t = (char)stack.pop();
                            calculationList.add(t);
                        }else if((char)stack.peek() == '*'||(char)stack.peek() == '/'){
                            char t = (char)stack.pop();
                            calculationList.add(t);
                            if((char)stack.peek() == '+'||(char)stack.peek() == '-'){
                                t = (char)stack.pop();
                                calculationList.add(t);
                            }
                        }
                        stack.push(item);
                    }
                }else{
                    stack.push(item);
                }
            }
        }
        while(!stack.empty()){
            char t = (char)stack.pop();
            calculationList.add(t);
        }
        for(char c:calculationList){
            //System.out.println(c);
        }
        for(char c:calculationList){
            if(Character.isDigit(c)){
                stack.push(c);
            }else{
                int intNum1 = (char)stack.pop() - '0';
                int intNum2 = (char)stack.pop() - '0';
                int t = 0;
                switch (c){
                    case '+':
                        t = intNum1+intNum2;
                        stack.push(String.valueOf(t).charAt(0));
                        break;
                    case '-':
                        t = intNum1-intNum2;
                        stack.push(String.valueOf(t).charAt(0));
                        break;
                    case '*':
                        t = intNum1*intNum2;
                        stack.push(String.valueOf(t).charAt(0));
                        break;
                    case '/':
                        t = intNum1/intNum2;
                        stack.push(String.valueOf(t).charAt(0));
                        break;
                }
            }
        }
        System.out.println(stack.pop());
    }
}
