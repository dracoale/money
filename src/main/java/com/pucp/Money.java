package com.pucp;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Money {
    @SerializedName("base_code")
    public String Name;
    @SerializedName("conversion_rates")

    public Map <String,Double> conversion;
    public Money(){
        conversion=new HashMap<>();
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Map<String, Double> getConversion() {
        return conversion;
    }

    public void setConversion(Map<String, Double> conversion) {
        this.conversion = conversion;
    }

    @Override
    public String toString() {
        return "Money{" +
                "Name='" + Name + '\'' +conversion.get("USD")+conversion+
                '}';
    }
}
