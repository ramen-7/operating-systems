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
public class Assignment6 
{
    static Scanner Sc = new Scanner(System.in);
    public int[] sequential(int arr[])
    {
        System.out.println("Enter the size of the file");
        int size = Sc.nextInt();
        System.out.println("Enter the starting point.");
        int start = Sc.nextInt();
        int i = start-1;
        while(size >0)
        {
            int check = (arr.length+1)-start;
            //System.out.println("check = " + check);
            if(check < size)
            {
                System.out.println("File size too big for starting point");
                return arr;
            }
            else
            {   
                if(arr[i] == 0)
                {
                    arr[i] = 1;
                    i++;
                    size--;
                }
                else
                {
                    System.out.println("Memory has not been allocated since memory slot was already full.");
                    return arr;
                }
            }
        }
        System.out.println("Memory has been allocated at:   ");
        for(int j = 0; j < arr.length; j++)
        {
            System.out.println((j+1) + " " +arr[j]);
        }
        return arr;
    }
    
    public static void main(String args[])
    {
        Assignment6 obj = new Assignment6();
        System.out.println("Enter array size:   ");
        int n = Sc.nextInt();
        int arr[] = new int[n];
        int c = 10;
        while(c != 0)
        {
            String msg = """
                    Enter:
                    0.Exit
                    1.Indexed
                    2.Linked
                    3.Indexed""";
            System.out.println(msg);
            c = Sc.nextInt();
            if(c == 1)
            {
                obj.sequential(arr);
            }
        }
    }
}
