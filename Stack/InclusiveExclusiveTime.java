package Stack;

import java.util.Arrays;
import java.util.Stack;

public class InclusiveExclusiveTime {
    public int[] findTime(String[] input, String jobName) {
        int inclusive = 0;
        int exclusive = 0;
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;

        for (String job : input) {
            String[] jobs = job.split(",");

            if (stack.isEmpty() && !jobs[0].equals(jobName))
                continue;

            int time = Integer.parseInt(jobs[2]);
            if (stack.isEmpty())
                prevTime = time;

            if (jobs[1].equals("START")) {
                stack.push(time);
                if (stack.size() == 2)
                    exclusive += time - prevTime;
                else
                    inclusive = time - prevTime;
            } else {
                stack.pop();
                if (stack.isEmpty())
                    exclusive += time - prevTime;
                else
                    inclusive += time - prevTime;

                if (stack.isEmpty())
                    break;
            }
            prevTime = time;
        }

        return new int[]{inclusive + exclusive, exclusive};
    }

    public static void main(String[] args) {
        String[] input = {"a,START,100","b,START,150","C,START,170","C,END,200","b,END,220","a,END,230"};
        System.out.println(Arrays.toString(new InclusiveExclusiveTime().findTime(input, "a")));
    }
}
