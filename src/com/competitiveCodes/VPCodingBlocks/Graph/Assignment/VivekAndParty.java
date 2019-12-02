package com.competitiveCodes.VPCodingBlocks.Graph.Assignment;


import java.util.*;

public class VivekAndParty {

    static int V;
    static LinkedList<Character> adj[];
    static List<String> outputList;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String output="";
        int count=1;
        outputList = new ArrayList<>();
        String line = null;

        while (scanner.hasNextLine()){
            output = "Case #" +count +": Vivek should drink beverages in this order: ";
            int n = scanner.nextInt();
            V = n;
            adj = new LinkedList[26];

            for (int i = 0; i < 26; i++)
                adj[i] = new LinkedList<>();

            Character v[] = new Character[n];
            for (int i = 0; i < n; i++)
                v[i] = scanner.next().charAt(0);


            int e = scanner.nextInt();
            //scanner.nextLine();
            for (int i = 0; i < e; i++) {
                Character src = scanner.next().charAt(0), dest = scanner.next().charAt(0);
                adj[src - 'a'].add(dest);
                //scanner.nextLine();
            }

            //scanner.nextLine();

            int indegree[] = new int[26];
            for (int i = 0; i < V; i++) {
                Iterator<Character> itr = adj[v[i] - 'a'].listIterator();

                while (itr.hasNext()) {
                    char c = itr.next();
                    indegree[c - 'a']++;
                }
            }

       /* for (int i = 0; i < V; i++)
            System.out.println(v[i] +"--" +indegree[v[i]-'a']);*/

            System.out.println("");
            HashSet<Character> hashSet = new HashSet<>();

            for (int i = 0; i < V; i++) {
                int position = v[i] - 'a';
                if (indegree[position] <= 0) {
                    if (hashSet.contains(v[i]))
                        hashSet.remove(v[i]);
                    output += v[i] + " ";
                } else
                    hashSet.add(v[i]);

                Iterator<Character> itr = adj[position].listIterator();

                while (itr.hasNext()) {
                    char c = itr.next();
                    indegree[c - 'a']--;

                }
            }

            while (!hashSet.isEmpty()) {
                char c = hashSet.iterator().next();
                int position = c - 'a';
                if (indegree[position] == 0) {
                    hashSet.remove(c);
                    output += c + " ";
                }
                Iterator<Character> itr = adj[position].listIterator();

                while (itr.hasNext()) {
                    char d = itr.next();
                    indegree[d - 'a']--;
                }

            }

            outputList.add(output.trim() +".");

            count++;

            scanner.nextLine();

        }

        for (String testCasesOutput:outputList) {
            System.out.println(testCasesOutput);
        }








    }
}
