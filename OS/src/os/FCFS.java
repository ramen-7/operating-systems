package os;
/**
 *
 * @author shvmt
 */
import java.util.*;
public class FCFS
{ 
    public int[][] arrangeArrival(int arr[][], int n)
    {
        for(int i = 0; i < n; i++)
        {
            for(int j = i+1; j < n; j++)
            {
                if(arr[i][1] > arr[j][1])
                {
                    int tp = arr[i][0];
                    arr[i][0] = arr[j][0];
                    arr[j][0] = tp;
                    int t = arr[i][1];
                    arr[i][1] = arr[j][1];
                    arr[j][1] = t;
                    int t2 = arr[i][2];
                    arr[i][2] = arr[j][2];
                    arr[j][2] = t;
                }
            }
        }
        
        return arr;
    }
    
    public void displayArr(int arr[][])
    {
        System.out.println("Proc   AT    Burst   CT     TAT    WT");
        int c = arr[0].length;
        int r = arr.length;
        //System.out.println("r = " + r);
        for(int i = 0; i < r; i++)
        {
            //System.out.println("i = " + i);
            for(int j = 0;j < c; j++)
            {   
                //System.out.println("j = " + j);
                System.out.print(arr[i][j] + "      ");
            }
            System.out.println();
        }
    }
    
    public int[][] completionTime(int arr[][])
    {
        int completion = 0;
        int r = arr.length;
        for(int i = 0; i < r; i++)
        {
            completion = completion + arr[i][1];
            arr[i][2] = completion;
        }
        System.out.println("Total completion time: " + completion);
        return arr;
    }
    
    public int[][] turnAroundTime(int arr[][])
    {
        int r = arr.length;
        for(int i = 0; i < r; i++)
        {
            arr[i][3] = arr[i][2] - 0;
        }
        return arr;
    }
    
    public int[][] waitTime(int arr[][])
    {
        int r = arr.length;
        for(int i = 0; i < r; i++)
        {
            arr[i][4] = arr[i][2] - arr[i][1];
        }
        return arr;
    }
    
    public static void main(String args[])
    {
        int n;
        FCFS obj = new FCFS();
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the no. of processes.");
        n = Sc.nextInt();
        int arr[][] = new int[n][6];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter arrival time for Process " + i);
            arr[i][1] = Sc.nextInt();
            System.out.println("Enter burst time for Process " + i);
            arr[i][0] = i;
            arr[i][2] = Sc.nextInt();
        }
        obj.arrangeArrival(arr, n);
        obj.displayArr(arr);
        obj.completionTime(arr);
        obj.displayArr(arr);
        obj.turnAroundTime(arr);
        obj.displayArr(arr);
        obj.waitTime(arr);
        obj.displayArr(arr);
    }
}
