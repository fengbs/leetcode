import java.util.Stack;

/**
 * Created by lideqing@xiaomi.com on 20-4-21
 */
public class OneFiveFive {

    class MinStack {

        private Stack<Integer> sta = new Stack<>();
        private Stack<Integer> staMin = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            sta.push(x);
            if (staMin.size() == 0 || staMin.peek() >= x) {
                staMin.push(x);
            }
        }

        public void pop() {
            int x = sta.pop();
            if (x == staMin.peek()) {
                staMin.pop();
            }
        }

        public int top() {
            return sta.peek();
        }

        public int getMin() {
            return staMin.peek();
        }
    }
}
