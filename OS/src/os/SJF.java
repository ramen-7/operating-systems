/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package os;

import java.util.*;
public class SJF
{ 
    public int[][] arrangeBurst(int arr[][], int n)
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
                }
            }
        }
        return arr;
    }
    
    public void displayArr(int arr[][])
    {
        System.out.println("Proc  Burst   CT     TAT    WT");
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
        SJF obj = new SJF();
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the no. of processes.");
        n = Sc.nextInt();
        int arr[][] = new int[n][5];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter process time for Process " + i);
            arr[i][0] = i;
            arr[i][1] = Sc.nextInt();
        }
        obj.arrangeBurst(arr, n);
        obj.displayArr(arr);
        obj.completionTime(arr);
        obj.displayArr(arr);
        obj.turnAroundTime(arr);
        obj.displayArr(arr);
        obj.waitTime(arr);
        obj.displayArr(arr);
    }
}

