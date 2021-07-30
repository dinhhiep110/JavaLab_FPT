import java.util.Random;
import java.util.Scanner;

public class BubbleSort{
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter number of array:");
        int n = validateInput();
        int arr[] = new int[n];
        generateInput(arr,n);
        System.out.print("Unsorted array: ");
        display(arr);
        System.out.print("Sorted array: " );
        display(bubbleSort(arr));
    }

    public static int[] bubbleSort(int arr[]){
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - i - 1; j++){
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }    
        }     
        return arr;  
    }


    public static int validateInput(){
        while(true){
            try {
                int input = Integer.parseInt(in.nextLine());
                if(input <= 0){
                    throw new NumberFormatException();
                }
                else{
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be positive number");
                System.out.print("Enter again: ");
            }
        }
    }

    public static void generateInput(int arr[],int n){
        Random r = new Random();
        for(int i = 0;i < arr.length;i++){
            arr[i] = r.nextInt(n);
        }
    }


    public static void display(int arr[]){
        System.out.print("[");
        for(int i = 0;i < arr.length - 1;i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1] + "]");
    }

}

