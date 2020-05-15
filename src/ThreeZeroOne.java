import java.util.*;

/**
 * Created by lideqing@xiaomi.com on 20-3-10
 */
public class ThreeZeroOne {
    private String input;
    List<String> resList = new LinkedList<>();
    List<String> rightResList = new LinkedList<>();
    Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        input = s;
        int num = 0;
        int start = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                ++num;
            } else if (s.charAt(i) == ')') {
                --num;
            }
            if (num < 0) {
                doDeletLeft(start, i);
                start = i + 1;
                num = 0;
            }
        }
        if (start != s.length()) {
            String rightStr = s.substring(start, s.length());
            num = 0;
            int end = rightStr.length();
            for (int i = rightStr.length() - 1; i >= 0; --i) {
                if (rightStr.charAt(i) == ')') {
                    ++num;
                } else if (rightStr.charAt(i) == '(') {
                    --num;
                }
                if (num < 0) {
                    doDeletRight(i, end, rightStr);
                    end = i;
                    num = 0;
                }
            }
            if (resList.size()== 0) {
                resList.add(rightStr.substring(0,end));
            } else if (end != 0) {
                List<String> temList = new LinkedList<>();
                String front = rightStr.substring(0,end);
                for (String str:resList) {
                    temList.add(front + str);
                }
                resList = temList;
            }
        }
        if (rightResList.size() == 0 && resList.size() == 0) {
            resList.add(s);
            return resList;
        } else if (rightResList.size() == 0) {
            return resList;
        } else if (resList.size() == 0) {
            return rightResList;
        } else {
            set.clear();
            for (String res : rightResList) {
                for (String res1 : resList) {
                    set.add(res + res1);
                }
            }
            resList.clear();
            resList.addAll(set);
            return resList;
        }
    }

    private void doDeletLeft(int start, int current) {
        if (rightResList.size() != 0) {
            for (String str : rightResList) {
                String temStr = str + input.substring(start, current + 1);
                for (int i = 0; i < temStr.length(); ++i) {
                    if (temStr.charAt(i) == ')') {
                        addToSet(deleteOne(temStr, i));
                    }
                }
            }
        } else {
            String temStr = input.substring(start, current + 1);
            for (int i = 0; i < temStr.length(); ++i) {
                if (temStr.charAt(i) == ')') {
                    addToSet(deleteOne(temStr, i));
                }
            }
        }
        rightResList.clear();
        rightResList.addAll(set);
        set.clear();
    }

    private void doDeletRight(int current, int end, String endStr) {
        if (resList.size() != 0) {
            for (String str : resList) {
                String temStr = endStr.substring(current, end) + str;
                for (int i = 0; i < temStr.length(); ++i) {
                    if (temStr.charAt(i) == '(') {
                        addToSet(deleteOne(temStr, i));
                    }
                }
            }
        } else {
            String temStr = endStr.substring(current, end);
            for (int i = 0; i < temStr.length(); ++i) {
                if (temStr.charAt(i) == '(') {
                    addToSet(deleteOne(temStr, i));
                }
            }
        }
        resList.clear();
        resList.addAll(set);
        set.clear();
    }

    private void addToSet(String str) {
            set.add(str);
    }

    private String deleteOne(String str, int index) {
        if (index == 0) {
            return str.substring(1, str.length());
        } else if (index == str.length() - 1) {
            return str.substring(0, str.length() - 1);
        } else {
            return str.substring(0, index) + str.substring(index + 1, str.length());
        }
    }

    public static void main(String[] args) {
        ThreeZeroOne threeZeroOne = new ThreeZeroOne();
        List<String> res = threeZeroOne.removeInvalidParentheses("a(");
        CommonUtil.printList(res);
    }
}
