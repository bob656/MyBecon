package kr.co.retailtech.mybecon.reception;

import android.util.Log;

import com.minew.beacon.BeaconValueIndex;
import com.minew.beacon.BluetoothState;
import com.minew.beacon.MinewBeacon;
import com.minew.beacon.MinewBeaconManagerListener;

import java.util.ArrayList;
import java.util.List;

import kr.co.retailtech.mybecon.reception.pojo.BeaconInfoManager;
import kr.co.retailtech.mybecon.reception.pojo.BeaconInformation;

public class MbmListener implements MinewBeaconManagerListener {
    private String TAG = MbmListener.class.getSimpleName();
    private BeaconInfoManager bm;
    public MbmListener(BeaconInfoManager bm){
        this.bm = bm;
    }
    @Override
    public void onAppearBeacons(List<MinewBeacon> list) {
//        Log.d(TAG, new StringBuffer("onAppearBeacons==>").append(list.size()).toString());
        getBeaconInformationCollect(list);
    }

    @Override
    public void onDisappearBeacons(List<MinewBeacon> list) {
//        Log.d(TAG, new StringBuffer("onDisappearBeacons==>").append(list.size()).toString());
        getBeaconInformationCollect(list);
    }

    @Override
    public void onRangeBeacons(List<MinewBeacon> list) {
//        Log.d(TAG, new StringBuffer("onRangeBeacons==>").append(list.size()).toString());
        getBeaconInformationCollect(list);

    }

    public void getBeaconInformationCollect(List<MinewBeacon> list){
        BeaconInfoManager bm = new BeaconInfoManager();
        for (MinewBeacon minewBeacon : list) {
            if(minewBeacon.getBeaconValue(BeaconValueIndex.MinewBeaconValueIndex_Name).getStringValue().contains("MiniBeacon")) {
                BeaconInformation beaconInfo = new BeaconInformation();
                beaconInfo.BeaconValueIndex_UUID = minewBeacon.getBeaconValue(BeaconValueIndex.MinewBeaconValueIndex_UUID).getStringValue();
                beaconInfo.BeaconValueIndex_Name = minewBeacon.getBeaconValue(BeaconValueIndex.MinewBeaconValueIndex_Name).getStringValue();
                beaconInfo.BeaconValueIndex_Major = minewBeacon.getBeaconValue(BeaconValueIndex.MinewBeaconValueIndex_Major).getStringValue();
                beaconInfo.BeaconValueIndex_Minor = minewBeacon.getBeaconValue(BeaconValueIndex.MinewBeaconValueIndex_Minor).getStringValue();
//                beaconInfo.BeaconValueIndex_WechatId = minewBeacon.getBeaconValue(BeaconValueIndex.MinewBeaconValue.getIntValue();
                beaconInfo.BeaconValueIndex_Mac = minewBeacon.getBeaconValue(BeaconValueIndex.MinewBeaconValueIndex_MAC).getStringValue();
                beaconInfo.BeaconValueIndex_RSSI = minewBeacon.getBeaconValue(BeaconValueIndex.MinewBeaconValueIndex_RSSI).getIntValue();
                beaconInfo.BeaconValueIndex_BatteryLevel = minewBeacon.getBeaconValue(BeaconValueIndex.MinewBeaconValueIndex_BatteryLevel).getIntValue();

                beaconInfo.BeaconValueIndex_Temperature = minewBeacon.getBeaconValue(BeaconValueIndex.MinewBeaconValueIndex_Temperature).getFloatValue();
                beaconInfo.BeaconValueIndex_Humidity = minewBeacon.getBeaconValue(BeaconValueIndex.MinewBeaconValueIndex_BatteryLevel).getFloatValue();
                beaconInfo.BeaconValueIndex_Txpower = minewBeacon.getBeaconValue(BeaconValueIndex.MinewBeaconValueIndex_TxPower).getIntValue();
                beaconInfo.BeaconValueIndex_InRange = minewBeacon.getBeaconValue(BeaconValueIndex.MinewBeaconValueIndex_InRage).isBool();
                Log.d(TAG, beaconInfo.BeaconValueIndex_Major);
                bm.setBeaconInfomation(beaconInfo);
            }
        }
    }

    @Override
    public void onUpdateState(BluetoothState bluetoothState) {
        switch (bluetoothState) {
            case BluetoothStateNotSupported:
                Log.d(TAG, "BluetoothStateNotSupported");
                break;
            case BluetoothStatePowerOff:
                Log.d(TAG, "BluetoothStatePowerOff");
                break;
            case BluetoothStatePowerOn:
                Log.d(TAG, "BluetoothStatePowerOn");
                break;
        }
    }
}
