package com.centercity.server.tracker;

import com.centercity.server.work.Car;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GpsTrackerApi {

    private static final int CONNECTION_TIMEOUT = 5000;

    public static List<String> readInputStream(final HttpURLConnection con){
        List<String> list = new ArrayList<>();
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                list.add(line);
            }
            return list;
        } catch (final Exception ex) {
            ex.printStackTrace();
            return list;
       }
    }

    public static String getParamsString(final Map<String, String> params) {
        final StringBuilder result = new StringBuilder();

        params.forEach((name, value) -> {
            try {
                result.append(URLEncoder.encode(name, "UTF-8"));
                result.append('=');
                result.append(URLEncoder.encode(value, "UTF-8"));
                result.append('&');
            } catch (final UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });

        final String resultString = result.toString();

        return !resultString.isEmpty()
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }

    public String getProbegCar(String traker, String one_time, String two_time) throws IOException {
        final URL url = new URL("http://******/api3");
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setConnectTimeout(CONNECTION_TIMEOUT);
        con.setReadTimeout(CONNECTION_TIMEOUT);
        System.out.println("Дата старт - " + one_time);
        System.out.println("Дата енд - " + two_time);

        long unix1 = Long.parseLong(one_time);
        long unix2 = Long.parseLong(two_time);
        one_time = String.valueOf(unix1/1000);
        System.out.println("one_time = " + one_time);
        two_time = String.valueOf(unix2/1000);
        System.out.println("two_time = " + two_time);

        final Map<String, String> parameters = new HashMap<>();
        parameters.put("s", "******");
        parameters.put("c", "2");
        parameters.put("i", traker);
        parameters.put("x", one_time);
        parameters.put("y", two_time);

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(getParamsString(parameters));
        out.flush();
        out.close();

        List list  = readInputStream(con);
        Map<Integer, Integer> carMap = new Car().getSubString(list);
        con.disconnect();
        int probeg = 0;
        int tr = Integer.parseInt(traker);
        for (Map.Entry entry : carMap.entrySet()) {
            if(tr == (int)entry.getKey()){
                probeg = (int) entry.getValue();
            }
        }
        return String.valueOf(probeg);
    }
}