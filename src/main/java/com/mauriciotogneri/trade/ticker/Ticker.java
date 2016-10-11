package com.mauriciotogneri.trade.ticker;

import com.mauriciotogneri.trade.csv.CsvLine;
import com.mauriciotogneri.trade.utils.NumberUtils;

public class Ticker
{
    private final String timestamp;
    private final Double bid;
    private final Double ask;
    private final Double spread;
    private final Double avg;

    public Ticker(String timestamp, Double bid, Double ask)
    {
        this.timestamp = timestamp;
        this.bid = bid;
        this.ask = ask;
        this.spread = NumberUtils.round(ask - bid);
        this.avg = (bid + ask) / 2;
    }

    public CsvLine csv()
    {
        CsvLine line = new CsvLine();
        line.append(timestamp);
        line.append(bid);
        line.append(ask);
        line.append(spread);
        line.append(avg);

        return line;
    }
}