package com.company;

import java.util.Comparator;

public class ResultPorownanie implements Comparator<Result> {
    @Override
    public int compare(Result r1, Result r2) {

        int a = Integer.compare(r1.getRes(), r2.getRes());

        return a == 0 ? ((r1.getName()).compareTo(r2.getName())) : -a;
    }
}
