package kr.co.retailtech.mybecon.reception;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.widget.Toast;

import com.minew.beacon.BluetoothState;
import com.minew.beacon.MinewBeaconManager;
import com.minew.beacon.MinewBeaconManagerListener;

import kr.co.retailtech.mybecon.reception.pojo.BeaconInfoManager;

public class ReceptionUtil {

    private String TAG = ReceptionUtil.class.getSimpleName();

    private final Context context ;

    // 1.get MinewBeaconManager instance
    MinewBeaconManager mMinewBeaconManager = null;

    public ReceptionUtil(Context context, BeaconInfoManager bm){
        this.context = context;
        mMinewBeaconManager = MinewBeaconManager.getInstance(this.context);
        mMinewBeaconManager.setDeviceManagerDelegateListener(new MbmListener(bm));
    }

    public void startBeacon(){
        checkBluetooth();
        mMinewBeaconManager.startScan();
    }

    public void stopBeacon(){
        mMinewBeaconManager.stopScan();
    }

    // 기기에서 Ble 허용 여부 체크
    private void checkBluetooth() {
        Log.d(TAG, "checkBluetooth()");
        BluetoothState bluetoothState = mMinewBeaconManager.checkBluetoothState();
        Log.d(TAG, "bluetoothState : " + bluetoothState);

        switch (bluetoothState) {
            case BluetoothStateNotSupported:
                Log.d(TAG, "BluetoothStateNotSupported");
                Toast.makeText(context, "Not Support BLE", Toast.LENGTH_SHORT).show();
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
