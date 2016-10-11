package com.mauriciotogneri.trade;

import com.mauriciotogneri.trade.ticker.BtceHistory;
import com.mauriciotogneri.trade.ticker.CexHistory;
import com.mauriciotogneri.trade.ticker.TickerHistory;

import okhttp3.OkHttpClient;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Main main = new Main();
        main.start();
    }

    private void start() throws Exception
    {
        TickerHistory cexHistory = new CexHistory(new OkHttpClient());
        TickerHistory btceHistory = new BtceHistory(new OkHttpClient());

        while (true)
        {
            try
            {
                cexHistory.process();
                btceHistory.process();
            }
            catch (Exception e)
            {
                // ignore
                e.printStackTrace();
            }

            try
            {
                Thread.sleep(2000);
            }
            catch (Exception e)
            {
                // ignore
            }
        }
    }
}