/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortinterview;

/**
 *
 * @author 1
 */
public class BinSearch {
    
    public static int Bin(int[]arr,int low,int high,int key){
    if(key<arr[low]||key>arr[high]||low>high) return low;
    
    int mid =(low+high)/2;
    
    if (key==arr[mid]) return mid;
    else if (key<arr[mid]) return Bin(arr,low,mid-1,key);
    else  return Bin(arr,mid+1,high,key);
    }
    
    
    
    
    
    
    
    public static void main(String[] args){
    int[] arr={11,13,14,15,16,19};
    int len=arr.length;
    System.out.println(Bin(arr,0,len-1,19));
    }
}
