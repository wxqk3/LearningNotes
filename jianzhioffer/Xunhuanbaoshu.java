/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jianzhioffer;

/**
 *
 * @author 1
 */
public class Xunhuanbaoshu {
    
    public static int solution(int n,int m){
       //init
       boolean[] arr = new boolean[n];
       int index=0;
       int count=0;
       int len=n;
       for(int i=0;i<n;i++) arr[i]=true;
       //start
       while(n>1){
       if(arr[index]==true) {
            count++;
            if(count==3){
            arr[index]=false;
            count=0;
            n--;
            }
            
            }
            index++;
            if(index==len) index=0;
       }
       for (int i = 0; i < len; i++) {
       if (arr[i] == true)
       return i+1;
    }
       return -1;
    
}
    
    
    /**
     *
     * @param args
     */
     public static void main(String[] args){
      System.out.println(solution(3,3));
    
}
}