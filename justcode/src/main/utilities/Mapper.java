package main.utilities;

import java.util.function.*;

public class Mapper<K> {

    public final BiFunction<K, Integer, Integer> mapper;

    public Mapper(final int amt) {
        this.mapper = (k,v) -> (v==null) ? amt : v+amt;
    }


}
