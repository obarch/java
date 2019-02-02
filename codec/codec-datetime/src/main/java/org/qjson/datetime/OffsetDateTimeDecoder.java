package org.qjson.datetime;

import org.qjson.spi.Decoder;
import org.qjson.spi.DecoderSource;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

class OffsetDateTimeDecoder implements Decoder {

    private final Decoder arrDecoder;

    public OffsetDateTimeDecoder(Decoder.Provider spi) {
        this.arrDecoder = spi.decoderOf(int[].class);
    }

    @Override
    public Object decode(DecoderSource source) {
        int[] arr = (int[]) source.decodeObject(arrDecoder);
        LocalDateTime localDateTime = LocalDateTime.of(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);
        ZoneOffset offset = ZoneOffset.ofTotalSeconds(arr[7]);
        return OffsetDateTime.of(localDateTime, offset);
    }
}
