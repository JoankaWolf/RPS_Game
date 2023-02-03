package com.rps;

public class Paper implements Shape {

    @Override
    public String getShapeName() {
        return "Paper";
    }

    @Override
    public String toString() {
        return getShapeName();
    }
}
