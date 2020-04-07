package OneDimensionArray;

public class AmazonTask {
    public static void main(String[] args) {
        int test1[] = { 0, 1, 0, 0 }; // 2
        int test2[] = { 0, 1, 1, 0, 1, 0 }; // 4
        int test3[] = { 1, 1, 0, 1, 1, 0, 1, 0, 1, 1 }; // 5
        int test4[] = {1, 1, 0, 1, 1, 1, 1, 0, 1, 1}; // 7
        int test5[] = {0, 1, 0, 1, 0 , 1, 1, 1, 1}; // 6
        int test6[] = {0}; // 1
        int test7[] = {1}; // 1
        int test8[] = {0, 1}; // 2
        int test9[] = {1, 1, 1}; // 3
        int test10[] = {0, 1, 0 , 0, 1, 0, 1, 1 ,1 ,1}; //6
        int test11[] = {0, 1, 0 , 0, 1, 1 ,1 ,1 , 0}; // 5
        int test12[] = {0,0,1,1,1,0,1,1,1,1,0,1,1,1,1,1,0,0}; // 10

        System.out.println(findLongestSeq(test1));
        System.out.println(findLongestSeq(test2));
        System.out.println(findLongestSeq(test3));
        System.out.println(findLongestSeq(test4));
        System.out.println(findLongestSeq(test5));
        System.out.println(findLongestSeq(test6));
        System.out.println(findLongestSeq(test7));
        System.out.println(findLongestSeq(test8));
        System.out.println(findLongestSeq(test9));
        System.out.println(findLongestSeq(test10));
        System.out.println(findLongestSeq(test11));
        System.out.println(findLongestSeq(test12));
    }
    public static int findLongestSeq(int [] input) {
        if (input.length <= 1)
            return input.length;

        int lastFirstNull = -1;
        int firstNull = -1;
        int secondNull = -1;
        int thirdNull = -1;
        int counter = 0;
        int max = 0;

        while (counter < input.length) {
            if (input[counter] == 0 && thirdNull != -1) {
                firstNull = secondNull;
                secondNull = thirdNull;
                thirdNull = counter;
            }
            if (input[counter] == 0 && firstNull != -1 && secondNull != -1 && thirdNull == -1)
                thirdNull = counter;
            if (input[counter] == 0 && firstNull != -1 && secondNull == -1)
                secondNull = counter;
            if (input[counter] == 0 && firstNull == -1)
                firstNull = counter;
            if (thirdNull == -1 && secondNull != -1 && firstNull != -1)
                max = secondNull > max ? secondNull : max;
            if (lastFirstNull != firstNull && thirdNull != -1)
                max = ((thirdNull - 1) - firstNull) > max ? ((thirdNull - 1) - firstNull) : max;
            counter++;
        }
        if (secondNull == -1)
            return input.length;
        if ((input.length - 1)- secondNull > max)
            max = (input.length - 1) - secondNull;
        if (thirdNull == -1)
            return secondNull;
        return max;
    }
}
