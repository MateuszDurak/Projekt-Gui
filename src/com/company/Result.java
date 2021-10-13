package com.company;

import java.util.Comparator;
import java.util.Objects;

public class Result implements Comparator<Result> {
    private long sec;
    private String name;
    private int res;
    private String grid;


    public Result(String name, int res, String grid, long sec) {

        this.sec = sec;
        this.name = name;
        this.res = res;
        this.grid = grid;
    }

    @Override
    public String toString() {
        return  name + " " + res + " " + grid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(String grid) {
        this.grid = grid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return res == result.res &&
                Objects.equals(name, result.name) &&
                Objects.equals(grid, result.grid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, res, grid);
    }

    @Override
    public int compare(Result result, Result t1) {
        return 0;
    }
}
