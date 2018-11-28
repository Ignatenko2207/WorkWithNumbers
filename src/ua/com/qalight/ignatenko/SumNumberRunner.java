package ua.com.qalight.ignatenko;

import java.util.logging.Logger;

public class SumNumberRunner {

    private static Logger logger = Logger.getLogger(SumNumberRunner.class.getName());

    public static void main(String[] args) {

        Integer maxPalindrom = getMaxPalindrom(1000, 9999);

        if (maxPalindrom != null) {
            logger.info("Max value is " + maxPalindrom);
        }


//		int number = 123456;
//
//		logger.info(String.valueOf(getSumBySplit(number)));
//		logger.info(String.valueOf(getSumByDivision(number)));
    }

    private static Integer getMaxPalindrom(int min, int max) {
        Integer result = null;

        for (int i = max; i >= min; i--) {
            for (int j = max; j >= min; j--) {
                result = i*j;
                if ( resultIsPalindrom(result) ) {
                    return result;
                }
            }
        }


        return result;
    }

    private static boolean resultIsPalindrom(Integer result) {

        String intAsString = String.valueOf(result);

        StringBuilder strBuilder = new StringBuilder(intAsString);
        strBuilder.reverse();

        return intAsString.equals(strBuilder.toString());
    }

    public static Integer getSumBySplit(int number) {
        Integer result = 0;

        String intAsText = String.valueOf(number);
        char[] symbols = intAsText.toCharArray();

        for (char symbol : symbols) {
            result += Character.getNumericValue(symbol);
        }

        return result;
    }


    public static Integer getSumByDivision(int number) {
        Integer result = 0;

        while(number!=0) {

            // 123456
            // 12345
            // 1234
            // 123
            // 12
            // 1


            result += number % 10;
            number = number / 10;
        }

        int counter = 0;
        do {


            counter++;
        } while (number>0 && counter<5);

        return result;
    }
}
