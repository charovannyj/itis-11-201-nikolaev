package ru.kpfu.itis.nikolaev.net.client;

import java.util.Map;

public interface HttpClientImpl {
    String get(String url, Map<String, String> params);
    String post(String url, Map<String, String> params);
    String put(String url, Map<String, String> params);
    String delete(String url, Map<String, String> params);
}
