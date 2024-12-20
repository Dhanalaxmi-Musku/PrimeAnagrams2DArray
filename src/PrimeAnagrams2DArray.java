import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeAnagrams2DArray {
    public static void main(String[] args) {
        int range = 1000;
        List<Integer> primes = findPrimes(range);
        List<Integer> anagrams = new ArrayList<>();
        List<Integer> nonAnagrams = new ArrayList<>();

        for (int i = 0; i < primes.size(); i++) {
            boolean isAnagramFound = false;
            for (int j = i + 1; j < primes.size(); j++) {
                if (areAnagrams(primes.get(i), primes.get(j))) {
                    isAnagramFound = true;
                    if (!anagrams.contains(primes.get(i))) {
                        anagrams.add(primes.get(i));
                    }
                    if (!anagrams.contains(primes.get(j))) {
                        anagrams.add(primes.get(j));
                    }
                }
            }
            if (!isAnagramFound && !anagrams.contains(primes.get(i))) {
                nonAnagrams.add(primes.get(i));
            }
        }

        int[][] result = new int[2][];
        result[0] = convertListToArray(anagrams);
        result[1] = convertListToArray(nonAnagrams);

        System.out.println("Anagrams:");
        for (int num : result[0]) {
            System.out.print(num + " ");
        }
        System.out.println("\nNon-Anagrams:");
        for (int num : result[1]) {
            System.out.print(num + " ");
        }
    }

    private static List<Integer> findPrimes(int range) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < range; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private static boolean areAnagrams(int num1, int num2) {
        char[] arr1 = String.valueOf(num1).toCharArray();
        char[] arr2 = String.valueOf(num2).toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    private static int[] convertListToArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
