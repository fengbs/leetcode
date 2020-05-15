/**
 * Created by lideqing@xiaomi.com on 20-4-10
 */
public class ThreeZeroSix {
    int maxLength = 0;

    boolean dfs(String num, int start, long pre, long sum) {
        if (start == num.length()) {
            return true;
        }
        if (num.charAt(start) == '0') {
            return false;
        }
        long numSum = 0;
        for (int i = start; i < Math.min(num.length(), start + maxLength); ++i) {
            numSum = numSum * 10 + (num.charAt(i) - '0');
            if (numSum == sum) {
                return dfs(num, i + 1, sum, sum + pre);
            } else if (numSum < sum) {
                continue;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }
        boolean flag = true;
        if (num.charAt(0) == '0') {
            for (char a : num.toCharArray()) {
                if (a != '0') {
                    flag = false;
                }
            }
            if (flag) {
                return true;
            }
        }
        maxLength = num.length() / 2 + 1;
        long first = 0;
        long second;
        for (int i = 0; i < maxLength; ++i) {
            if (i != 0 && num.charAt(0) == '0') {
                break;
            }
            first = first * 10 + (num.charAt(i) - '0');
            second = 0;
            for (int j = i + 1; j < Math.min(num.length(), i + 1 + maxLength); ++j) {
                if (num.charAt(i + 1) == '0' && j > i + 1) {
                    continue;
                }
                second = second * 10 + ((num.charAt(j) - '0'));
                if (j != num.length() - 1) {
                    if (dfs(num, j + 1, second, first + second)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ThreeZeroSix threeZeroSix = new ThreeZeroSix();
        System.out.println(threeZeroSix.isAdditiveNumber("121474836472147483648"));
    }
}
