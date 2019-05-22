package kr.co.retailtech.mybecon.data.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "BeconInfo")
public class BeconInfo {
    @PrimaryKey
    public String beaconUuid ;
    public String beconX;
    public String beconY;
    public String beconZ;
    public String beaconTxType;
    public String beaconRadius;
}
