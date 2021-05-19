package com.example.a0511;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ScannedData {
    private static String rssi;
    private static String deviceName;
    private static String deviceByteInfo;
    private  String address;
    private List<ScannedData> arrayList = new ArrayList<>();
    public ScannedData(String deviceName, String rssi, String deviceByteInfo, String address) {
        this.deviceName = deviceName;
        this.rssi = rssi;
        this.deviceByteInfo = deviceByteInfo;
        this.address = address;
    }

    public  String getAddress() {return address; }
    public static String getRssi() {
        return rssi;
    }
    public static String getDeviceByteInfo() {
        return deviceByteInfo;
    }
    public static String getDeviceName() {
        return deviceName;
    }
    @Override
    public boolean equals(@Nullable Object obj) {
        ScannedData p = (ScannedData)obj;
        return this.address.equals(p.address);
    }
    @NonNull
    @Override
    public String toString() {
        return this.address;
    }
}
