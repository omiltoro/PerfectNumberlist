/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perfectnumber;

/**
 *
 * @author GT
 */
public class PerfectNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        int i = 1;
//        int j = 1;
//        int sum =0;
//        int count = 10;
//        
//        while(i<=10){
//            int p = (int)Math.pow(2, i);
//            sum = j + p;
//            System.out.println("I is "+i+" and sum is "+sum);
//            i++;
//        }  
//        int sum = (int)Math.pow(2, 5);
//        System.out.println("Sum is "+sum);
        PerfectNumber myne = new PerfectNumber();   
        int count = 1;
        int limit = 30000;
        while(count<=limit){
            int sum = 1 + myne.recurse(count,0);
            boolean check_prime = myne.isPrime(sum);
            if(check_prime==true){
                int fval = (int)Math.pow(2, count);
                int perfect_number = fval * sum;
                if(perfect_number<=limit){
                    System.out.println("Calculation is "+fval+" X "+sum+" and the Perfect Number is "+perfect_number);//Count is "+count+" and the Sum is "+sum);
                }else{
                    break;
                }
            }
            
            count++;
        }
        
        
    }
    
    public int recurse(int count, int sum){        
        if((count!=1)&&(count>0)){
            int count_less  = count-1;
            sum = sum + (int)Math.pow(2, count)+ recurse(count_less,sum);                    
//            System.out.println("Sum is "+sum);
        }else{
            sum += (int)Math.pow(2, 1);
//            System.out.println("Sum is "+sum);
        }        
        return sum;
    }
    
    public boolean isPrime(int n) {
        for(int i=2;2*i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }
    
}
