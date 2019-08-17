public class RecursionDemo {
    public static void printPermutn(int[] arr, int index) {
        if(index == arr.length) {
            for(int i=0; i<arr.length; i++)
                System.out.print(arr[i]);
            System.out.print(" ");
        } else {
            for (int i = index; i < arr.length; i++) {
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;

                printPermutn(arr, index + 1);

                /*temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;*/
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        printPermutn(arr, 0);
    }
}
