package com.mauriciotogneri.trade.csv;

import com.mauriciotogneri.trade.log.Log;

import java.io.IOException;

public class CsvFile
{
    private boolean firstLine = true;
    private final Log log;

    public CsvFile(String filePath) throws IOException
    {
        this.log = new Log(filePath);
    }

    public synchronized void write(CsvLine csvLine) throws IOException
    {
        if (!firstLine)
        {
            log.writeLn("");
        }

        log.write(csvLine.toString());

        firstLine = false;
    }
}