package HashTable;

import java.util.*;

// Atlassian Interview Question
public class FileCollection {
    static class File {
        String title;
        int size;
        String collectionName;

        public File(String title, int size, String collectionName) {
            this.title = title;
            this.size = size;
            this.collectionName = collectionName;
        }
    }

    class Directory {
        String collectionName;
        Set<File> files = new HashSet<>();
        int size = 0;
    }

    public void findTopCollections(int n, List<File> fileList) {
        Map<String, Directory> directoryMap = new HashMap<>();
        Map<Directory, Integer> collectionSize = new HashMap<>();
        PriorityQueue<Directory> priorityQueue = new PriorityQueue<>((a, b) -> b.size - a.size);

        int total = 0;

        for (File file : fileList) {
            total += file.size;

            if (!file.collectionName.isEmpty()) {
                Directory directory = directoryMap.get(file.collectionName);
                if (directory == null) {
                    directory = new Directory();
                    directory.collectionName = file.collectionName;
                    priorityQueue.add(directory);
                    directoryMap.put(file.collectionName , directory);
                }
                directory.files.add(file);
                directory.size = directory.size + file.size;
            }

        }

        while (!priorityQueue.isEmpty())
            System.out.println(priorityQueue.poll().size);
    }

    public static void main(String[] args) {
        List<File> files = new ArrayList<>();

        files.add(new File("a", 5, "c1"));
        files.add(new File("b", 5, "c1"));
        files.add(new File("c", 7, "c2"));

        System.out.println();
        new FileCollection().findTopCollections(2, files);
    }
}
