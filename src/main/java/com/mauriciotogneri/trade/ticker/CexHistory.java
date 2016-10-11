package com.mauriciotogneri.trade.ticker;

import com.google.gson.JsonObject;
import com.mauriciotogneri.trade.csv.CsvFile;
import com.mauriciotogneri.trade.network.HttpRequest;

import java.io.IOException;

import okhttp3.OkHttpClient;

public class CexHistory extends TickerHistory
{
    private final HttpRequest httpRequest;

    private static final String TICKER_URL = "https://cex.io/api/ticker/BTC/USD";

    public CexHistory(OkHttpClient client) throws IOException
    {
        super(new CsvFile("history/ticker_cex.csv"));

        this.httpRequest = new HttpRequest(client, TICKER_URL);
    }

    public Ticker ticker() throws IOException
    {
        JsonObject json = httpRequest.json();

        String timestamp = json.get("timestamp").getAsString();
        Double bid = json.get("bid").getAsDouble();
        Double ask = json.get("ask").getAsDouble();

        return new Ticker(timestamp, bid, ask);
    }
}