import java.util.*;

public class BinarySearchAlgorithm {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        int elementsAmount = 10;
        int range = 15;
        int searchedNumber = 2;

        numbers = generateRandomNumbersWithoutRepetitions(elementsAmount, range);

        Collections.sort(numbers);

        System.out.println(Arrays.toString(numbers.toArray()));

        findIndexOfElement(numbers, searchedNumber );
    }

    private static List<Integer> generateRandomNumbersWithoutRepetitions(int elementsAmount, int range) {
        List<Integer> numbers = new ArrayList<>();
        Random rand = new Random();

        while (numbers.size() < elementsAmount) {

            int randomNumber = rand.nextInt(range);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return numbers;
    }

    private static void findIndexOfElement(List<Integer> numbers, int searchedNumber) {
        int indexOfElement = binarySearch(numbers, searchedNumber);

        if (indexOfElement == -1) {
            System.out.println("Element " + searchedNumber + " does not exist in array.");
        } else {
            System.out.println("Index of: " + searchedNumber + " is " + indexOfElement);
        }
    }

    private static int binarySearch(List<Integer> numbers, int searchedNumber) {
        int low = 0;
        int high = numbers.size()-1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = numbers.get(mid);

            if (guess == searchedNumber) {
                return mid;
            }
            if (guess > searchedNumber) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}