package problem21spring.util;

import java.util.stream.IntStream;

/**
 * Created by rklimemnko on 28.05.2016.
 */
public class NumberUtil {

    public static Integer amicableNumbersSum(Integer seed) {
        return IntStream.range(1, seed)
                        .filter(val -> isAmicable(val))
                        .sum();
    }
    private static Boolean isAmicable(Integer num) {
        int a = num;
        int b = getSumOfProperDivisors(a);
        return a == getSumOfProperDivisors(b);
    }
    private static Integer getSumOfProperDivisors(Integer val) {
        return IntStream.range(1, val / 2 + 1)
                        .filter(t -> val % t == 0)
                        .sum();
    }
}
