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
public class OSlabeval 
{
    static Scanner Sc = new Scanner(System.in);
    
    public float[][] roundRobin(float bt[], float at[], float tq, int n)
    {
        float CTWT[][] = new float[n][2];
        float rem_bt[] = new float[n];
        float t = at[0];
        for(int i = 0; i < n; i++)
        {
            rem_bt[i] = bt[i];
        }
        while(true)
        {
            boolean done = true;
            for(int i = 0; i < n; i++)
            {
                System.out.println("t = " + t);
                System.out.println("at[i] = " + at[i]);
                System.out.println("rem_bt[i] = " + rem_bt[i]);
                if(at[i] <= t && rem_bt[i] > tq)
                {
                    done = false;
                    t += tq;
                    rem_bt[i] -= tq;
                    System.out.println("After rem_bt[i] = " + rem_bt[i]);
                }
                else if(at[i] <= t && rem_bt[i] <= tq && rem_bt[i] > 0)
                {
                    t += rem_bt[i];
                    rem_bt[i] = 0;
                    CTWT[i][0] = t;//completion time
                    //CTWT[i][1] = t - bt[i];//wait time
                    System.out.println("2After rem_bt[i] = " + rem_bt[i]);
                    //System.out.println("Wait time for  = " + (i+1) + " is "+ CTWT[i][1]);
                }
                System.out.println("-----------");
            }
            if(done == true)
            {
                break;
            }
        }
        return CTWT;
    }
    
    public static void main(String args[])
    {
        OSlabeval obj = new OSlabeval();
        int n = Sc.nextInt();
        float tq = Sc.nextFloat();
        float WT[] = new float[n];
        float BT[] = new float[n];
        float AT[] = new float[n];
        float TAT[] = new float[n];
        float CT[] = new float[n];
        float ctwt[][] = new float[n][2];
        for(int i = 0; i < n; i++)
        {
            AT[i] = Sc.nextFloat();
        }
        for(int j = 0; j < n; j++)
        {
            BT[j] = Sc.nextFloat();
        }
        ctwt = obj.roundRobin(BT, AT, tq, n);
        float avgtat = 0;
        float avgwt = 0;
        for(int i = 0; i < n; i++)
        {
            CT[i] = ctwt[i][0];
            //WT[i] = ctwt[i][1];
            TAT[i] = CT[i] - AT[i];
            WT[i] = TAT[i] - BT[i];
            //System.out.println("TAT " + i + " is " + TAT[i]);
        }
        for(int i = 0; i < n; i++)
        {
            avgtat += TAT[i];
            avgwt += WT[i];
        }
        avgtat /= n;
        avgwt /= n;
        System.out.println(avgwt);
        System.out.println(avgtat);
    }
}
