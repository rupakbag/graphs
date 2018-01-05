package com.library.graph;

import com.library.graph.SpecimenClassification.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SpecimenClassificationTest {
    @Test
    public void test1() {
        Pair p1 = new Pair("1", "2", true);
        Pair p2 = new Pair("2", "3", false);
        Pair p3 = new Pair("3", "4", false);
        Pair p4 = new Pair("4", "1", true);
        Pair p5 = new Pair("2", "4", false);
        Set<Pair> judgements = new HashSet<>();
        judgements.add(p1);
        judgements.add(p2);
        judgements.add(p3);
        judgements.add(p4);
        judgements.add(p5);
        Assert.assertEquals(false, SpecimenClassification.isConsistent(judgements));
    }

    @Test
    public void test2() {
        Pair p1 = new Pair("1", "2", true);
        Pair p2 = new Pair("2", "3", true);
        Pair p3 = new Pair("4", "5", true);
        Pair p4 = new Pair("5", "6", true);
        Pair p5 = new Pair("1", "4", false);
        Pair p6 = new Pair("2", "5", false);
        Pair p7 = new Pair("3", "6", false);
        Pair p8 = new Pair("2", "6", true);
        Set<Pair> judgements = new HashSet<>();
        judgements.add(p1);
        judgements.add(p2);
        judgements.add(p3);
        judgements.add(p4);
        judgements.add(p5);
        judgements.add(p6);
        judgements.add(p7);
        Assert.assertEquals(true, SpecimenClassification.isConsistent(judgements));
        judgements.add(p8);
        Assert.assertEquals(false, SpecimenClassification.isConsistent(judgements));
    }
}