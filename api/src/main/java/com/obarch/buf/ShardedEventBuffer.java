package com.obarch.buf;


import com.obarch.Event;

import java.util.List;
import java.util.function.Predicate;

public class ShardedEventBuffer implements EventBuffer {

    @Override
    public void accept(Event event) {
    }

    @Override
    public List<Event> execute(Predicate<Event> predicate, long from, int limit) {
        return null;
    }
}
