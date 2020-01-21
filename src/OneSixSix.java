import java.util.HashMap;
import java.util.Map;

/**
 * Created by lideqing@xiaomi.com on 19-12-4
 */
public class OneSixSix {
    private static final int base = 1 << 30;

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if (numerator == 0 || denominator == 0) {
            return "0";
        }
        if (isNegative(numerator, denominator)) {
            sb.append("-");
        }
        long newNumerator = numerator;
        long newDenominator = denominator;
        newNumerator = Math.abs(newNumerator);
        newDenominator = Math.abs(newDenominator);
        long integerPart = newNumerator / newDenominator;

        sb.append(integerPart);
        if (newNumerator%newDenominator==0) {
            return sb.toString();
        }
        sb.append(".");
        long num = newNumerator%newDenominator;
        Map<Long,Integer> map = new HashMap<>();
        int index = sb.length();
        while ( num != 0 && !map.containsKey(num) ) {
            map.put(num,index);
            ++index;
            num*=10;
            sb.append(num/newDenominator);
            num%=newDenominator;
        }
        if (num == 0) {
            return sb.toString();
        } else {
            return sb.substring(0,map.get(num)) +"(" + sb.substring(map.get(num),sb.length()) + ")";
        }
    }

    private boolean isNegative(int numerator, int denominator) {
        return (numerator>0&&denominator<0)||(numerator<0&&denominator>0);
    }

    public static void main (String []args) {
        OneSixSix oneSixSix = new OneSixSix();
        System.out.println(oneSixSix.fractionToDecimal(-1,-2147483648));
    }
}
