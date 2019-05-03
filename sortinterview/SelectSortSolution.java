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
public class SelectSortSolution {
    
    public static void sort(int[] array){
        int p;
        int temp;
        int len=array.length;
        if((len==0)||(array==null)) return;
        
        for (int i =0;i<len;i++){
            p=i;
            for(int j=i+1;j<len;j++){
                if(array[p]>array[j]) p=j;
            }
            temp=array[i];
            array[i]=array[p];
            array[p]=temp;
        
        }
        
        
        
       
        
    
    }
    
    
    
    
    public static void main(String[] args){
         int[] a={11,2,3,9,23,32,7};
         sort(a);
         System.out.println(Arrays.toString(a));
    }
}
