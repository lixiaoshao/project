package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * leetcode
 *
 * @author honor-ljp
 * 2023/1/29 14:16
 */
public class Test {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer,
                Integer>(4,0.75f,true) {
            {
                put(10, 10);
                put(9, 9);
                put(20, 20);
                put(1, 1);
            }
            @Override
            // 覆写了删除策略的方法，我们设定当节点个数大于 3 时，就开始删除头节点
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > 3;
            }
        };
    }
}
