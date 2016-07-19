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
    public String getPerfectNumber(int min,int max){
        PerfectNumber myne = new PerfectNumber();   
        int count = 1;
        int limit = max;
        String message = "";
        while(count<=limit){
            int sum = 1 + myne.recurse(count,0);
            boolean check_prime = myne.isPrime(sum);
            if(check_prime==true){
                int fval = (int)Math.pow(2, count);
                int perfect_number = fval * sum;
                if(perfect_number<=limit){
                    if(perfect_number>=min){
                        message += "Calculation is "+fval+" X "+sum+" and the Perfect Number is "+perfect_number+"\n";//Count is "+count+" and the Sum is "+sum);
                    }                    
                }else {
                    break;
                }
            }
            
            count++;
        }
        return message;
    }
    public int recurse(int count, int sum){        
        if((count!=1)&&(count>0)){
            int count_less  = count-1;
            sum = sum + (int)Math.pow(2, count)+ recurse(count_less,sum);                    
        }else{
            sum += (int)Math.pow(2, 1);
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
