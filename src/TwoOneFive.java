/**
 * Created by lideqing@xiaomi.com on 19-12-19
 */
public class TwoOneFive {
    int[] heapData;
    int length = 0;

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        heapData = new int[k];
        for (int i = 0; i < nums.length; ++i) {
            putInHeap(nums[i]);
        }
        return heapData[0];
    }

    private void putInHeap(int num) {
        if (length < heapData.length) {
            heapData[length] = num;
            int index = length;
            ++length;
            int parent = findHead(index);
            while (index != 0 && heapData[parent] > num) {
                heapData[index] = heapData[parent];
                heapData[parent] = num;
                index = parent;
                parent = findHead(index);
            }
            heapData[index] = num;
        } else {
            int startIndex = 0;
            while (num > heapData[startIndex]) {
                heapData[startIndex] = num;
                int left = findLeft(startIndex);
                if (left >= length) {
                    break;
                }
                int right = findRight(startIndex);
                if (right >= length || heapData[left] < heapData[right]) {
                    if (heapData[left] < num) {
                        heapData[startIndex] = heapData[left];
                        startIndex = left;
                    } else {
                        heapData[startIndex] = num;
                    }
                } else {
                    if (heapData[right] < num) {
                        heapData[startIndex] = heapData[right];
                        startIndex = right;
                    } else {
                        heapData[startIndex] = num;
                    }
                }
            }
        }
    }

    private int findHead(int index) {
        return (index - 1) / 2;
    }

    private int findRight(int index) {
        return index * 2 + 2;
    }

    private int findLeft(int index) {
        return index * 2 + 1;
    }

    public static void main(String[] args) {
        TwoOneFive twoOneFive = new TwoOneFive();
        int[] nums = {3};
        System.out.println(twoOneFive.findKthLargest(nums, 1));
    }
}
