package info.sandroalmeida.educative.grokking_code_interview._1_two_pointers;

public class SortColors {
    public static int[] sortColors (int[] colors) {

        int current = 0;
        int start = 0;
        int end = colors.length - 1;

        while(current <= end) {
            int value = colors[current];
            if(value == 0) {
                swap(current, start, colors);
                current++;
                start++;
            } else if(value == 1) {
                current++;
            } else {
                swap(end, current, colors);
                end--;
            }
        }
        return colors;
    }

    private static void swap(int idx1, int idx2, int[] array) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public static void main(String[] args) {
        int[] colors = {1,1,0,2,0,2,1,1,2};
        sortColors(colors);
        System.out.println("end test");
    }
}
