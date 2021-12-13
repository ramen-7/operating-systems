/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package os;

/**
 *
 * @author shvmt
 */
import java.util.*;
public class RoundRobin 
{
    static Scanner Sc = new Scanner(System.in);
    static int t;
    
    public int[][] burstTime(int arr[][], int tq)
    {
        int n = arr.length;
        //System.out.println("n = " + n);
        int rem_bt[] = new int[n];
        //arranging in order acc to burst time
        for(int i = 0; i < n; i++)
        {
            //System.out.println("i = " + i);
            for(int j = i+1; j < n; j++)
            {
                //System.out.println("j = " + j);
                if(arr[i][1] > arr[j][1])
                {
                    int temp_name = arr[i][0];
                    arr[i][0] = arr[j][0];
                    arr[j][0] = temp_name;
                    int t = arr[i][1];
                    arr[i][1] = arr[j][1];
                    arr[j][1] = t;
                }
            }
        }
        for(int i = 0; i < n; i++)
        {
            rem_bt[i] = arr[i][1];
            System.out.println("rem_bt element " + (i+1) + " is " + arr[i][1]);
        }
        System.out.println("tq = "+ tq);
        while(true)
        {
            boolean flag = true;
            //System.out.println("flag = " + flag);
            //System.out.println("t = " + t);
            /*
            for(int i = 0; i < n; i++)
            {
                rem_bt[i] = arr[i][1];
                System.out.println("rem_bt element " + (i+1) + " is " + arr[i][1]);
            }
            */
            for(int i = 0; i < n; i++)
            {
                //System.out.println("Entered for");
                if(rem_bt[i] > 0)
                {
                    flag = false;
                    
                    if(rem_bt[i] > tq)
                    {
                        System.out.println("rem_bt WAS " + rem_bt[i]);
                        t += tq;
                        rem_bt[i] -= tq;
                        System.out.println("rem_bt IS " + rem_bt[i]);
                    }
                    else
                    {
                        System.out.println("rem_bt WAS " + rem_bt[i]);
                        t += rem_bt[i];//total time
                        arr[i][2] = t;//completion time
                        arr[i][4] = t - arr[i][1];//wait time = t - bt
                        rem_bt[i] = 0;
                        System.out.println("rem_bt IS " + rem_bt[i]);
                    }
                }
            }
            if(flag == true)
            {
                break;
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
    
    public static void main(String args[])
    {
        
        System.out.println("Enter the number of processes.");
        int n = Sc.nextInt();
        int arr[][] = new int[n][5];
        RoundRobin obj = new RoundRobin();
        System.out.println("Enter the time quantum");
        int tq = Sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter process time for Process " + i);
            arr[i][0] = i;
            arr[i][1] = Sc.nextInt();
        }
        obj.burstTime(arr, tq);
        obj.displayArr(arr);
    }
}
