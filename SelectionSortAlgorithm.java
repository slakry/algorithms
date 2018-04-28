import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SelectionSortAlgorithm {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        int elementsAmount = 20;
        int range = 155;

        numbers = generateRandomNumbers(elementsAmount, range);
        System.out.println("Basic unsorted array " + Arrays.toString(numbers.toArray()));
        System.out.println("Start...");

        numbers = selectionSort(numbers);
        System.out.println("...end.");
        System.out.println("Array after selection sort " + Arrays.toString(numbers.toArray()));
    }

    private static List<Integer> selectionSort(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>();
        int indexOfSmallestElement = 0;

          while (numbers.size() != 0) {

            indexOfSmallestElement = findIndexOfSmallestElement(numbers);

            sortedNumbers.add(numbers.get(indexOfSmallestElement));
            System.out.println("Smallest element: " + numbers.get(indexOfSmallestElement));

            System.out.println("Sorted array: " + Arrays.toString(sortedNumbers.toArray()));

            numbers.remove(indexOfSmallestElement);
            System.out.println("Unsorted array: " + Arrays.toString(numbers.toArray()));
            System.out.println();
        }

        return sortedNumbers;
    }

    private static int findIndexOfSmallestElement(List<Integer> numbers) {
        int smallestElement = numbers.get(0);
        int indexOfSmallestElement = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < smallestElement) {
                smallestElement = numbers.get(i);
                indexOfSmallestElement = i;
            }
        }

        return indexOfSmallestElement;
    }

    private static List<Integer> generateRandomNumbers(int elementsAmount, int range) {
        List<Integer> numbers = new ArrayList<>();
        Random rand = new Random();
        int randomNumber = 0;

        while (numbers.size() < elementsAmount) {
            randomNumber = rand.nextInt(range);
            numbers.add(randomNumber);
        }

        return numbers;
    }
}