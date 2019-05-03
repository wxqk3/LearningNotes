/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortinterview;

import java.util.Arrays;

/**
 *
 * @author 1
 */
public class quickSortSolution {
    
   public static void sort(int arr[],int low,int high) {
       int l=low;
       int h=high;
       int p=arr[low];
       
       while(l<h){
        while(l<h && arr[h]>p)
           h--;
        if(l<h){
        arr[l]=arr[h];
        l++;
        }
        
        while(l<h&&arr[l]<=p)
            l++;
        if(l<h){
        arr[h]=arr[l];
        h--;
        }
       }
       arr[l]=p;
       if(l-1>low)sort(arr,low,l-1);
       if(h+1<high)sort(arr,h+1,high);
   }
    
    
    
    public static void main(String[] args){
    int[] arr={6,2,7,3,8,9};
    sort(arr,0,arr.length-1);
    System.out.println(Arrays.toString(arr));
    
    }
}
