package kr.co.retailtech.mybecon.reception.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BeaconInformation {
    @SerializedName("BeaconValueIndex_UUID")
    @Expose
    public String BeaconValueIndex_UUID;

    @SerializedName("BeaconValueIndex_Name")
    @Expose
    public String BeaconValueIndex_Name;

    @SerializedName("BeaconValueIndex_Major")
    @Expose
    public String BeaconValueIndex_Major;

    @SerializedName("BeaconValueIndex_Minor")
    @Expose
    public String BeaconValueIndex_Minor;

    @SerializedName("BeaconValueIndex_WechatId")
    @Expose
    public Integer BeaconValueIndex_WechatId;

    @SerializedName("BeaconValueIndex_Mac")
    @Expose
    public String BeaconValueIndex_Mac;

    @SerializedName("BeaconValueIndex_RSSI")
    @Expose
    public Integer BeaconValueIndex_RSSI;

    @SerializedName("BeaconValueIndex_BatteryLevel")
    @Expose
    public Integer BeaconValueIndex_BatteryLevel;

    @SerializedName("BeaconValueIndex_Temperature")
    @Expose
    public Float BeaconValueIndex_Temperature;

    @SerializedName("BeaconValueIndex_Humidity")
    @Expose
    public Float BeaconValueIndex_Humidity;

    @SerializedName("BeaconValueIndex_Txpower")
    @Expose
    public Integer BeaconValueIndex_Txpower;

    @SerializedName("BeaconValueIndex_InRange")
    @Expose
    public Boolean BeaconValueIndex_InRange;

    @SerializedName("BeaconValueIndex_Connectable")
    @Expose
    public Boolean BeaconValueIndex_Connectable;

}
