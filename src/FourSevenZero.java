/**
 * Created by lideqing@xiaomi.com on 20-6-6
 */
public class FourSevenZero {

    public int rand10() {
        while(true) {
            int rand = rand40();
            if (rand <= 40) {
                return rand/4;
            }
        }
    }
    public int rand40() {
        return 7*(rand7()-1) + rand7();
    }

    public int rand7() {
        return 1;
    }
}
