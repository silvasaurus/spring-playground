package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class MathService {
    private int x;
    private int y;
    private String ops = "add";
    private String answer = "";
    private int[] n;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getOps() {
        return ops;
    }

    public void setOps(String ops) {
        this.ops = ops;
    }

    public String doMath() {


        if (ops.equalsIgnoreCase("add")) {
            return answer = String.format("%s + %s = %s", x, y, (x + y));
        } else if (ops.equalsIgnoreCase("multiply")) {
            return answer = String.format("%s * %s = %s", x, y, (x * y));
        } else if (ops.equalsIgnoreCase("subtract")) {
            return answer = String.format("%s - %s = %s", x, y, (x - y));
        } else if (ops.equalsIgnoreCase("divide")) {
            return answer = String.format("%s / %s = %s", x, y, (x / y));
        }

        return "INVALID INPUT";
    }

    public int[] getN(){
        return n;
    }

    public void setN(int[] n){
        this.n =n;
    }

    public String doSum(){
        int sum = 0;
        List<String> listNums = new ArrayList<>();

        for(int i = 0; i < n.length; i++){
            sum += n[i];
            listNums.add(String.valueOf(n[i]));
        }
        return String.join(" + ", listNums) + " = " + sum;

    }
}