package com.DesignPattern.CreationalDP;

public class FactoryMethodPattern {

    public static void main(String[] args) {


    }

    abstract class Plan{
        protected float rate;
        public float units;
        public abstract void getRate();

        public float calRate(){
            return rate*units;
        }
    }


}
