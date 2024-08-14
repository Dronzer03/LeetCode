package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class LinkedListIntersection {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;

        Map<String, String> graph = new HashMap<>();
        List<List<String>> inputList = new ArrayList<>();
        while ((line = in.readLine()) != null) {
            String[] splitted = line.split("->");
            if (splitted.length == 2) {
                graph.put(splitted[0], splitted[1]);
            } else {
                List<String> current = new ArrayList();
                String[] spt = line.split(",");
                for (String s : spt)
                    current.add(s);
                inputList.add(current);
            }
        }

        for (List<String> currList : inputList) {
            traverse(graph, currList);
        }
    }

    public static void traverse(Map<String, String> graph, List<String> inputList) {
        Set<String> visitedNodes = new HashSet<>();

        for (String head : inputList) {
            Set<String> currentListNodes = new HashSet<>();
            String currentNode = head;

            while (currentNode != null) {
                if (currentListNodes.contains(currentNode)) {
                    System.out.println("Error Thrown!");
                    return;// Cycle detected
                }

                if (visitedNodes.contains(currentNode)) {
                    System.out.println("True");
                    return;
                }

                currentListNodes.add(currentNode);

                currentNode = graph.get(currentNode);
            }

            visitedNodes.addAll(currentListNodes);
        }
        System.out.println("False");
    }

}
