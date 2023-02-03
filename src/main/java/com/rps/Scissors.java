package com.rps;

public class Scissors implements Shape{
    @Override
    public String getShapeName() {
        return "Scissors";
    }

    @Override
    public String toString() {
        return getShapeName();
    }
}
