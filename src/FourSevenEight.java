import java.util.Random;

/**
 * Created by lideqing@xiaomi.com on 20-6-6
 */
public class FourSevenEight {
    private double radius;
    private double x_center;
    private double y_center;
    private Random random;
    public FourSevenEight(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        random = new Random();
    }

    public double[] randPoint() {
        double[]res = new double[2];
        if (radius == 0) {
            res[0] = x_center;
            res[1] = y_center;
            return res;
        }
        double x = 0;
        double y =0;
        while (true) {
            x = x_center - radius + 2*random.nextDouble()*radius;
            y = y_center - radius + 2*random.nextDouble()*radius ;
            if ((x-x_center)*(x-x_center) + (y-y_center)*(y-y_center) > radius*radius ) {
                continue;
            } else {
                res[0] = x;
                res[1] = y;
                return res;
            }
        }
    }
}
