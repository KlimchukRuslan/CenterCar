package com.centercity.server.work;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Car {
    String car_number;
    int id_tracer;
    int prob;

    public String getCar_number() {
        return car_number;
    }

    public int getId_tracer() {
        return id_tracer;
    }

    public int getProb() {
        return prob;
    }

    public Map<Integer,Integer> getSubString(List <String> list){
        String str;
        Map <Integer, Integer> mapCar = new HashMap<>();
        int [] x = new int[6];

        for (int i = 1; i<list.size(); i++){
            int k = 0;
            str = String.valueOf(list.get(i));
            if (str.length()<11){
                x[1] = 0;
            }
            for (String retval : str.split(";")) {
                    x[k] = Integer.valueOf(retval);
                    k++;
            }
            mapCar.put(x[0], (int) Math.round(x[1]/10.0));
        }

        return mapCar;
    }

}
