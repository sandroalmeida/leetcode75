package info.sandroalmeida.educative.grokking_code_interview;

public class HappyNumber {

    public static boolean isHappyNumber(int n) {
        int p1 = n;
        int p2 = sumOfSquares(n);

        while(p2 != 1) {
            p1 = sumOfSquares(p1);
            p2 = sumOfSquares(sumOfSquares(p2));
            if(p1 == p2)
                return false;
        }

        return true;
    }

    private static int sumOfSquares(int n) {
        int sum = 0;
        while(n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappyNumber(10));
    }

}
