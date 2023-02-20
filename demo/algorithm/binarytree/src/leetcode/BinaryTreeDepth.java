package leetcode;

import java.util.*;
import java.util.concurrent.*;

/**
 * leetcode
 *
 * @author honor-ljp
 * 2023/1/28 15:52
 */
public class BinaryTreeDepth {
    public static FutureTask task() {
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000);
                System.out.println("子线程执行中-----" + Thread.currentThread().getName());
                return "成功了！";
            }
        });
        return futureTask;
    }

    public synchronized static void main(String[] args) throws InterruptedException, ExecutionException {
        BinaryTreeDepth tree = new BinaryTreeDepth();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 6, 5000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue(200), new ThreadPoolExecutor.CallerRunsPolicy()) {

            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("真正执行开始， 您好！ " + t.getName());
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行结束！ ");
            }
        };
        threadPoolExecutor.submit(task());
        List<FutureTask> task = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            FutureTask futureTask = new FutureTask(new Callable() {
                @Override
                public Object call() throws Exception {
                    Thread.sleep(1000);
                    System.out.println("子线程执行中-----" + Thread.currentThread().getName());
                    return "成功了！";
                }
            });
            Thread thread = new Thread(futureTask);
            thread.start();
            task.add(futureTask);
        }

        //Future<?> submit = threadPoolExecutor.submit(futureTask);
        for (int i = 0; i < task.size(); i++) {
            System.out.println("task.get(i) = " + task.get(i).get());
        }
        /*FutureTask<String> task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        });

        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode21 = new TreeNode(4);
        TreeNode treeNode22 = new TreeNode(6);
        TreeNode treeNode31 = new TreeNode(1);
        TreeNode treeNode32 = new TreeNode(2);
        TreeNode treeNode33 = new TreeNode(7);
        TreeNode treeNode34 = new TreeNode(8);
        treeNode.left = treeNode21;
        treeNode.right = treeNode22;
        treeNode21.left = treeNode31;
        treeNode21.right = treeNode32;
        treeNode22.left = treeNode33;
        treeNode22.right = treeNode34;
        int max = maxDepth(treeNode);
        System.out.println("max = " + max);*/

    }
    public synchronized static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        int lMax = 0;
        int rMax = 0;
        if (root.left != null) {
            lMax = maxDepth(root.left);
        }
        if (root.right != null) {
            rMax = maxDepth(root.right);
        }
        max = lMax > rMax ? lMax + 1 : rMax + 1;
        return max;
    }
}
