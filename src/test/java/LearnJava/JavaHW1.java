package LearnJava;
public class JavaHW1 {
    public static void main (String[] args){

        String myGroup ="My group contains ";
        String pers = " persons";
        int count = 16;
        System.out.println(myGroup + count + pers);
        String space = "";
        System.out.println(space);

        int firstNumber = 8;
        int secondNumber = 2;
        System.out.println(firstNumber + secondNumber);
        String textForSum = firstNumber + " + " + secondNumber + " = ";
        System.out.println(textForSum + (firstNumber + secondNumber));
        System.out.println(space);

        int numberForMultip = 5;
        System.out.println(numberForMultip * numberForMultip);
        String textForMultip = numberForMultip + " * " + numberForMultip + " = ";
        System.out.println(textForMultip + (numberForMultip * numberForMultip));
        System.out.println(space);

        int numberForSqrt = 16;
        double d16 = Math.sqrt(numberForSqrt);
        System.out.println(d16);
        String sqrt = "sqrt(" + numberForSqrt +") = ";
        System.out.println(sqrt + d16);
        System.out.println(space);

        int firstForMin = 3;
        int secondForMin = 28;
        double min = Math.min(firstForMin, secondForMin);
        System.out.println(min);
        String textForMin = "Math.min(" + firstForMin + ", " + secondForMin + ") = ";
        System.out.println(textForMin + min);
        System.out.println(space);

        int firstForMax = 3;
        int secondForMax = 28;
        double max = Math.max(firstForMax, secondForMax);
        System.out.println(max);
        String textForMax = "Math.max(" + firstForMax + ", " + secondForMax + ") = ";
        System.out.println(textForMax + max);
        System.out.println(space);

        int numberForAbs = 16;
        double abs = Math.abs(-numberForAbs);
        String textForAbs = "Math.abs(-" + numberForAbs + ") = ";
        System.out.println(textForAbs + abs);

    }
}
