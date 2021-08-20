package com.centercity.server.work;

import com.centercity.server.data.CarNumber;
import com.centercity.server.gsheet.SheetsGoogle;

import javax.servlet.http.HttpServlet;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class GpsApi extends HttpServlet {

    private static final int CONNECTION_TIMEOUT = 5000;

    public static List<Car> postRequest(String dateOne, String dateTwo) throws Exception {
        File file = new File("/opt/tomcat/webapps/ROOT/WEB-INF/classes/conf.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(file));
        final List list;
        CarNumber [] carNumbers = CarNumber.values();

        List<Car> list_car = new ArrayList<>();

        ArrayList arrayList = new ArrayList();

        final URL url = new URL(properties.getProperty("mega"));
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setConnectTimeout(CONNECTION_TIMEOUT);
        con.setReadTimeout(CONNECTION_TIMEOUT);

        // collect parameters
        final Map<String, String> parameters = new HashMap<>();
        parameters.put("s", properties.getProperty("api"));
        parameters.put("c", "2");
        parameters.put("i", "0");
        parameters.put("x", new GpsApi().dateUnix(dateOne));
        parameters.put("y", new GpsApi().dateUnix(dateTwo));

        System.out.println(new GpsApi().dateUnix(dateOne));
        System.out.println(new GpsApi().dateUnix(dateTwo));

        con.setDoOutput(true);

        final DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(getParamsString(parameters));
        out.flush();
        out.close();

        list  = readInputStream(con);
        Map<Integer, Integer> carMap = new Car().getSubString(list);
        con.disconnect();

        for (int i = 1; i<=53;i++){

            Car car = new Car();
            car.car_number = String.valueOf(carNumbers[i-1]);
            car.id_tracer = Integer.valueOf(properties.getProperty(String.valueOf(i)));

            for (Map.Entry entry : carMap.entrySet()) {
                if(car.getId_tracer() == (int)entry.getKey()){
                    car.prob = (int) entry.getValue();
                    arrayList.add(car.prob);
                }
            }
            list_car.add(car);
        }

        SheetsGoogle.updateSheet(arrayList);

        System.out.println("Ok");
        return list_car;
    }


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

    public String dateUnix(String dates) throws ParseException {
        if(dates.isEmpty()){
            return "1581801222";
        }
        System.out.println(dates);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date date = dateFormat.parse(dates);
        System.out.println(date);
        long unixTime = date.getTime()/1000;
        return String.valueOf(unixTime);
    }

    public String getProbegCar(String traker, String one_time, String two_time) throws IOException {
        final URL url = new URL("http://*****/api3");
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
        parameters.put("s", "*****");
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