package com.mauriciotogneri.trade.csv;

public class CsvLine
{
    private final StringBuilder builder = new StringBuilder();
    private boolean firstElement = true;

    private static final String SEPARATOR = ",";

    public void append(String value)
    {
        if (!firstElement)
        {
            separator();
        }

        builder.append(value);

        firstElement = false;
    }

    public void append(long value)
    {
        append(String.valueOf(value));
    }

    public void append(double value)
    {
        append(String.valueOf(value));
    }

    public void append(boolean value)
    {
        append(String.valueOf(value));
    }

    public void separator()
    {
        builder.append(SEPARATOR);
    }

    public String toString()
    {
        return builder.toString();
    }
}