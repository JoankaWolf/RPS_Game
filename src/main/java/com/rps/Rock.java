package com.rps;

public class Rock implements Shape{
    @Override
    public String getShapeName() {
        return "Rock";
    }

    @Override
    public String toString() {
        return getShapeName();
    }
}
