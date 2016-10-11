package com.mauriciotogneri.trade.ticker;

import com.google.gson.JsonObject;
import com.mauriciotogneri.trade.csv.CsvFile;
import com.mauriciotogneri.trade.network.HttpRequest;

import java.io.IOException;

import okhttp3.OkHttpClient;

public class BtceHistory extends TickerHistory
{
    private final HttpRequest httpRequest;

    private static final String TICKER_URL = "https://btc-e.com/api/2/btc_usd/ticker";

    public BtceHistory(OkHttpClient client) throws IOException
    {
        super(new CsvFile("history/ticker_btce.csv"));

        this.httpRequest = new HttpRequest(client, TICKER_URL);
    }

    public Ticker ticker() throws IOException
    {
        JsonObject json = httpRequest.json();

        JsonObject jsonTicker = json.get("ticker").getAsJsonObject();
        String timestamp = jsonTicker.get("updated").getAsString();
        Double bid = jsonTicker.get("sell").getAsDouble();
        Double ask = jsonTicker.get("buy").getAsDouble();

        return new Ticker(timestamp, bid, ask);
    }
}