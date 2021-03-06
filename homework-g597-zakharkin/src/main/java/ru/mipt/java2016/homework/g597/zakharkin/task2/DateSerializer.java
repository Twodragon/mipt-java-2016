package ru.mipt.java2016.homework.g597.zakharkin.task2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

/**
 * Serialization strategy for Date type
 *
 * @autor Ilya Zakharkin
 * @since 31.10.16.
 */
public class DateSerializer implements Serializer<Date> {
    private DateSerializer() {
    }

    private static class InstanceHolder {
        public static final DateSerializer INSTANCE = new DateSerializer();
    }

    public static DateSerializer getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public void write(RandomAccessFile file, Date data) throws IOException {
        file.writeLong(data.getTime());
    }

    @Override
    public Date read(RandomAccessFile file) throws IOException {
        Date date = new Date(file.readLong());
        return date;
    }
}
