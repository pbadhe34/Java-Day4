package app;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CountingTaskStream extends RecursiveTask<Integer> {

    private final TreeNode node;

    CountingTaskStream(TreeNode node) {
        this.node = node;
    }

    @Override
    protected Integer compute() {
        return node.getValue() + node.getChildren().stream()
          .map(childNode -> new CountingTaskStream(childNode).fork())
          .mapToInt(ForkJoinTask::join)
          .sum();
    }

}
