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
public class FirstFit 
{
    static Scanner Sc = new Scanner(System.in);
    public void firstFit(int memSize[], int inputSize[], int allocated[])
    {
        int n = memSize.length;
        int place[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            allocated[i] = -1;
            place[i] = -1;
        }
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter Size: ");
            inputSize[i] = Sc.nextInt();
            for(int j = 0; j < n; j++)
            {
                if(memSize[j] > inputSize[i] && allocated[j] == -1)
                {
                    System.out.println("Allocated at " + j);
                    allocated[j] = j;
                    place[i] = j;
                    break;
                }
            }
        }
        System.out.println("Process    Size     Allocated");
        for(int i = 0; i < n; i++)
        {
            if(place[i] != -1)
            {
                System.out.println(i + "       " + inputSize[i] + "       " + place[i]);
            }
            else
            {
                System.out.println(i + "       " + inputSize[i] + "       " + "Not Allocated");
            }
        }
    }
    
    public static void main(String args[])
    {
        FirstFit obj = new FirstFit();
        int memSize[] = {100, 300, 200, 500, 400, 600};
        int n = memSize.length;
        System.out.println("Memory      ID");
        for(int i = 0; i < n; i++)
        {
            System.out.println(memSize[i] + "       "+ i);
        }
        int allocated[] = new int[n];
        int input_size[] = new int[n];
        obj.firstFit(memSize, input_size, allocated);
    }
}
