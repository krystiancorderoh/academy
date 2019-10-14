package com.softtek.academy.java.basics.fourthdayexercises.javaInterface;

class MyCalculator implements AdvancedArithmetic{

    public int divisor_sum(int n){
        int suma=0;
        for(int i = 1;i<=n;i++){
            if(n%i == 0){
                suma+=i;
            }
            
        }
        return suma;
    }

}
