package com.mauriciotogneri.trade.ticker;

import com.mauriciotogneri.trade.csv.CsvFile;

import java.io.IOException;

public abstract class TickerHistory
{
    private final CsvFile historyLog;

    protected TickerHistory(CsvFile historyLog)
    {
        this.historyLog = historyLog;
    }

    public void process() throws IOException
    {
        Ticker ticker = ticker();

        historyLog.write(ticker.csv());
    }

    public abstract Ticker ticker() throws IOException;
}