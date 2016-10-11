package com.mauriciotogneri.trade.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Log
{
    private final BufferedWriter bufferedWriter;

    public Log(String filePath) throws IOException
    {
        bufferedWriter = bufferedWriter(filePath);
    }

    private BufferedWriter bufferedWriter(String filePath) throws IOException
    {
        BufferedWriter result = null;
        File file = new File(filePath);

        if (file.exists() || file.createNewFile())
        {
            FileWriter fileWriter = new FileWriter(file, true);
            result = new BufferedWriter(fileWriter);
        }

        return result;
    }

    public synchronized void write(String content) throws IOException
    {
        bufferedWriter.write(content);
        bufferedWriter.flush();
    }

    public synchronized void writeLn(String content) throws IOException
    {
        write(String.format("%s%n", content));
    }
}