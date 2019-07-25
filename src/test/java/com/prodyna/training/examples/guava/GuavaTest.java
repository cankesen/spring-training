package com.prodyna.training.examples.guava;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import java.util.List;
import org.junit.Test;

public class GuavaTest {

    //conditions
    @Test(expected = IllegalArgumentException.class)
    public void checkArgument_shouldThrowException() {
        checkArgument(1 > 2);
    }

    @Test(expected = NullPointerException.class)
    public void checkNotNull_shouldThrowException() {
        checkNotNull(null);
    }

    @Test
    public void toStringHelper() {
        //Classname
        System.out.println(
                MoreObjects.toStringHelper(this).add("test", "testvalue").toString()
        );
        //Given name
        System.out.println(
                MoreObjects.toStringHelper("MyObject").add("test", "testvalue").toString()
        );
    }

    @Test
    public void comparisonWithGuava() {
        System.out.println(
                ComparisonChain.start().compare(1, 1).compare("test", "test").result()
        );
        System.out.println(
                ComparisonChain.start().compare(1, 1).compare("a", "z").result()
        );
        System.out.println(
                ComparisonChain.start().compare(1, 2).compare("test", "test").result()
        );
        System.out.println(
                ComparisonChain.start().compare(2, 1).compare("test", "test").result()
        );
    }


    @Test
    public void joinString() {
        List<String> list = Lists.newArrayList("Audi", "Porsche", null, "Bentley", "Bmw");
        String joined = Joiner.on(",").useForNull("Vw").join(list);
        System.out.println(joined);

    }

    @Test
    public void splitString() {
        String inCsv = "Audi;Porsche ;;;Bentley,Bmw";
        Iterable<String> joined = Splitter.on(";").omitEmptyStrings().trimResults().split(inCsv);
        joined.forEach(System.out::println);
    }

    @Test
    public void multiSet() {
        String inCsv = "Audi;Porsche;Porsche;;;Bentley,Bmw";
        Iterable<String> joined = Splitter.on(";").omitEmptyStrings().trimResults().split(inCsv);
        Multiset<String> multiSet = HashMultiset.create(joined);
        multiSet.forEach(entry -> System.out.println(Joiner.on("=").join(entry, multiSet.count(entry))));
    }

    @Test
    public void multiMap() {

        Multimap<String, String> multiMap = ArrayListMultimap.create();
        multiMap.put("matrix", "neo");
        multiMap.put("matrix", "murphy");
        multiMap.put("titanic", "leo");
        multiMap.put("titanic", "kate");
        System.out.println("as collection");
        multiMap.entries().forEach(System.out::println);
        System.out.println("as map");
        multiMap.asMap().entrySet().forEach(System.out::println);

    }


    @Test
    public void immutableListTest() {

        //initialize list in single line
        List<String> immutableList = ImmutableList.of("This is an", "immutable", "list");
        immutableList.stream().forEach(System.out::println);
        List<String> list = Lists.newArrayList("This is not an", "immutable", "list");

    }


}
