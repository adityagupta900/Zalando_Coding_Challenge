import java.util.*;
/**
 *  Solutions to three coding questions from Zalando. 
 * 
 * @author Niall Campbell
 * @version 1.0
 */
public class Solution
{
    /**
     * Question: count the number of words in a given String. 
     */
    public static int solution(String S) 
    {
        
        //Count the number of sentences
        //Divide sentences into seperate Strings
        //Count the number of words in each String
        
        String[] sentences = S.split("[?|!|\\.]");
        
        int max = 0; //store the max number of words
        
        int numSen = sentences.length; //number of sentences
        
        //Loop through each sentence in the array and count the num of words
        for(int i = 0; i < numSen; i++)
        {
            int numWords = 0;
            
            String sen = sentences[i]; 
            
            String[] words = sen.split(" ");
            
            numWords = words.length;
            
            for(int j = 0; j < numWords; j++)
            {
                if(words[j].equals(""))
                {
                    numWords--;
                }
            }
            
            if(numWords > max)
            {
                max = numWords;   
            }
        }
        
        return max;
        
    }
    
    /**
     *  Shuffle a given digit. 
     */
    public int solution2(int A)
    {
        
        //one digit from the front and one digit from the back
        
        String val = Integer.toString(A); //convert the int to a String
        
        String shuffle = ""; //will add the shuffled values to this string
        
        int len = val.length(); //the amount of digits in the String
        
        int i = 0; //the index at the start of the String
        int j = len - 1; //the index from the back of the String
        
        while(i < j)
        {
            shuffle += val.charAt(i);
            shuffle += val.charAt(j);
            i++;
            j--;
        }
        
        //if the number of digits is odd 
        if(len % 2 != 0)
        {
            shuffle += val.charAt(i);
        }
        
        //convert the string back to an int
        int numShuffled = Integer.parseInt(shuffle);
        
        return numShuffled;
        
    }
    
    /**
     * Given an array, see how many times you can make the array be in order by removing one element. 
     */
    public static int solution3(int[] arr)
    {
        //loop through the array and take out one element at a time
        //put the other elements in another array
        //check if this array is in order
        //put the element back in and move on to the next one
        
        int len = arr.length;
        
        List<Integer> arr2 = new ArrayList<Integer>();
        
        int count = 0;
        
        for(int i = 0; i < len; i++)
        {
            arr2.add(arr[i]);
        }
        
        for(int i = 0; i < len; i++)
        {
            int temp = (int) arr2.remove(i); //returns an object so cast it to an int
            
            if(inOrderList(arr2))
            {
                count++;
            }
            
            arr2.add(i, temp); 
        }
        
        return count;
    }
    
    /**
     * Check if a linked list is in order.
     * 
     * For solution 3. 
     */
    public static boolean inOrderList(List<Integer> list)
    {
        int len = list.size();
        
        for(int i = 0; i < len-1; i++)
        {
            int a = (int) list.get(i);
            int b = (int) list.get(i + 1);
            
            if(a > b)
            {
                return false;
            }
        }
        
        
        return true;
    }
    
    
    public static void main()
    {
        System.out.print(solution("Forget your CVs! Save time. x x"));
        
        int[] arr = {1,2,4,3,5};
        System.out.println(solution3(arr));
    }
}
