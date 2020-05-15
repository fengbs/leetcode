/**
 * Created by lideqing@xiaomi.com on 20-4-9
 */
public class ThreeOneNine {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }

    public static void main(String[] args) {
        ThreeOneNine threeOneNine = new ThreeOneNine();
        System.out.println(threeOneNine.bulbSwitch(6));
    }
}
