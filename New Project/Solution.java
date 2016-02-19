import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Random;


public class Solution 
{
    public int findKthElement(List<Integer> a, int k) 
 {
  if (a.size() < 10) 
  {
   Collections.sort(a);
   return a.get(k - 1);
  }
  
  ArrayList<Integer> medians = new ArrayList<Integer>();
  for (int i = 0; i < a.size() - a.size() % 5; i = i + 5)
   medians.add(getMedian(a.subList(i, i + 5)));
  int v = getMedian(medians);

  ArrayList<Integer> left = getPartition(a, v, true);
  ArrayList<Integer> right = getPartition(a, v, false);

  return (left.size() + 1 == k) ? v : (left.size() > k) ? findKthElement(
    left, k) : findKthElement(right, k - left.size() - 1);
 }

 public int getMedian(List<Integer> a) 
 {
  Collections.sort(a);
  return a.get(a.size() / 2);
 }

 public ArrayList<Integer> getPartition(List<Integer> a, int v,boolean isLessThan) 
 {
  ArrayList<Integer> res = new ArrayList<Integer>();
  for (int val : a)
   if (isLessThan && val < v)
    res.add(val);
   else if (!isLessThan && val > v)
    res.add(val);
  return res;
 }
 
 public static void main(String[] args) 
 {
  Solution s = new Solution();
  Scanner in = new Scanner(System.in);
  System.out.println("Enter no of elements you want to enter:\n");
  int a = in.nextInt();
    System.out.println("You entered range "+a);
    System.out.println("Putting numbers in list \n");
  Random randomGenerator = new Random();   
  List<Integer> x = Arrays.asList(randomGenerator.nextInt(a));
  System.out.println(s.findKthElement(x, 18));
  Collections.sort(x);
  System.out.println(x);
  System.out.println(x.get(17));
 }

 
}