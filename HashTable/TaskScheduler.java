package HashTable;

// LC - 621
// https://leetcode.com/problems/task-scheduler
public class TaskScheduler {
    // My code
    // Didn't work 62/71 passed
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        int tasksCompleted = 0;
        int time = 0;

        while (tasksCompleted != tasks.length) {
            int interval = n + 1;
            for (int index = 0; index < 26; index++) {
                if (freq[index] > 0) {
                    tasksCompleted++;
                    time++;
                    interval--;
                    freq[index]--;
                    if (interval == 0)
                        break;
                }
            }
            if (interval > 0 && tasksCompleted != tasks.length) {
                time += interval;
            }
        }

        return time;
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        System.out.println(new TaskScheduler().leastInterval(tasks, 3));
    }
}
