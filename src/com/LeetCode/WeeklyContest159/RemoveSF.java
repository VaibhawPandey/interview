package com.LeetCode.WeeklyContest159;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RemoveSF {
    public static void main(String[] args) {
        String arr[]={"/a","/a/b","/c/d","/c/d/e","/c/f"};
        List<String> subFolder=removeSubfolders(arr);

        for (String folder:subFolder)
            System.out.print(folder +" ");

        System.out.println();
    }
    public static List<String> removeSubfolders(String[] folder) {

        List<String> subFolder= new ArrayList<String>();
        for (int i=0;i<folder.length;i++)
            subFolder.add(folder[i]);

        boolean isListUpdated=true;

        return null;
        
    }
}
