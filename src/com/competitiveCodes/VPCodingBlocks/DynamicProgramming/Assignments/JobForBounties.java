package com.competitiveCodes.VPCodingBlocks.DynamicProgramming.Assignments;

import java.util.Scanner;
import java.util.Stack;

public class JobForBounties {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();

        System.out.println(maxNumberofBounties(str));
    }

    private static int maxNumberofBounties(String str) {
        int result=0;
        int n=str.length();

        Stack<Integer> stk=new Stack<>();
        stk.push(-1);

        for (int i = 0; i < n; i++) {

            if(str.charAt(i) == '(')
                stk.push(i);
            else {
                stk.pop();

                if(!stk.empty())
                    result=Math.max(result,i-stk.peek());
                else
                    stk.push(i);
            }
        }

        return result;
    }
}
