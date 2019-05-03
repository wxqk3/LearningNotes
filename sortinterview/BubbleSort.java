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
public class BubbleSort {
      
    public static void Bubble(int[] a) {
       int temp=0;
       int len=a.length;
       for(int i=0;i<len-1;i++){
        for(int j=0;j<len-1;j++){
          if(a[j]>a[j+1]){
              temp=a[j];
              a[j]=a[j+1];
              a[j+1]=temp;
           }
         }
       }       
    }
    
    
  
    
    
    public static void main(String[] args){
    int[] array={11,2,33,4,65,9,17};
    Bubble(array);
    System.out.println(Arrays.toString(array));
    }
    
   
}
