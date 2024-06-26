import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = ",";
        String numStr = numbers;
        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterEnd);
            numStr = numbers.substring(delimiterEnd + 1);
        }
        numStr = numStr.replace("\n", delimiter);
        String[] numArray = numStr.split(delimiter);
        

       
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();
        for (String num : numArray) {
            if (!num.isEmpty()) {
                int number = Integer.parseInt(num);
                if (number < 0) {
                    negatives.add(number);
                } else {
                    sum += number;
                }

            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negative numbers not allowed " + negatives);
        }

        

        return sum;
    }

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();

        System.out.println(calculator.add("")); // Output: 0
        System.out.println(calculator.add("1")); // Output: 1
        System.out.println(calculator.add("1,5")); // Output: 6
        System.out.println(calculator.add("1\n2,3")); // Output: 6
        System.out.println(calculator.add("//;\n1;2")); // Output: 3

        try {
            System.out.println(calculator.add("1,-2,3"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Output: negative numbers not allowed [-2]
        }
    }
}
