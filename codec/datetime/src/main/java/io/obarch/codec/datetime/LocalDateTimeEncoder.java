package io.obarch.codec.datetime;

import io.obarch.codec.spi.Encoder;
import io.obarch.codec.spi.EncoderSink;

import java.time.LocalDateTime;

class LocalDateTimeEncoder implements Encoder {
    @Override
    public void encode(EncoderSink sink, Object val) {
        LocalDateTime localDateTime = (LocalDateTime) val;
        sink.write('[');
        sink.encodeInt(localDateTime.getYear());
        sink.write(',');
        sink.encodeInt(localDateTime.getMonthValue());
        sink.write(',');
        sink.encodeInt(localDateTime.getDayOfMonth());
        sink.write(',');
        sink.encodeInt(localDateTime.getHour());
        sink.write(',');
        sink.encodeInt(localDateTime.getMinute());
        sink.write(',');
        sink.encodeInt(localDateTime.getSecond());
        sink.write(',');
        sink.encodeInt(localDateTime.getNano());
        sink.write(']');
    }
}
