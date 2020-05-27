package ua.phpguru.training.calculator;

public  class Calculator implements Operation{


    public Double addition(Double arg1, Double arg2){
       return arg1+arg2;
    }

    public Double subtraction(Double arg1,Double arg2){
        return arg1 - arg2;
    }

    public Double multiplication(Double arg1,Double arg2){
        if(arg2 == 0){
            throw new ArithmeticException("multiplication on 0 is dangerous :) ");
        } else
        return arg1 * arg2;
    }

    public Double divide (Double arg1,Double arg2){
        if(arg2 == 0){
            throw new ArithmeticException("divide on 0 is dangerous :) ");
        } else
        return arg1 / arg2;
    }

    public Double degree(Double arg, Double degree){
        return Math.pow(arg,degree);
    }

    public Double sqrt(Double arg){
        if(arg<0){
            throw new NegativeSqrtException();
        }else
        return Math.sqrt(arg);
    }


}
