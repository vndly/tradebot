package com.mauriciotogneri.trade.network;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpRequest
{
    private final OkHttpClient client;
    private final String url;

    public HttpRequest(OkHttpClient client, String url)
    {
        this.client = client;
        this.url = url;
    }

    public String request() throws IOException
    {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    public JsonObject json() throws IOException
    {
        return new JsonParser().parse(request()).getAsJsonObject();
    }
}