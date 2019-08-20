import java.util.LinkedList;
import java.util.List;

public class NineOne {
    public int numDecodings(String s) {
        if ( s.length() == 0 ) {
            return 0;
        }
        if( s.length() == 1 ) {
            if ( s.equals("0") ) {
                return 0;
            } else {
                return 1;
            }
        }
        int pre = 0 ;
        int prePre = 1;
        if ( valid(s.charAt(0),s.charAt(1)) ) {
            pre = 2;
        }
        //init
        for ( int i = 2 ; i < s.length() ; ++i ) {
            int sum = 0;
            if ( i == s.length()-1 || s.charAt(i+1) != '0') {
                sum += pre;
            }
            if (  i!= 0 && valid(s.charAt(i-1),s.charAt(i)) ) {
                   sum += prePre;
            }
            prePre = pre;
            pre = sum;
        }
        return pre;
    }

    public boolean valid( char a, char b ) {
        if ( a == '0' ) {
            return false;
        }
        int sum = 10*(a-'0') + b - '0';
        if ( sum <= 26 && sum >= 1) {
            return true;
        }
        return false;
    }

    public static void main ( String []args ) {
        NineOne nineOne = new NineOne();
        System.out.println(nineOne.numDecodings("27"));
    }
}
