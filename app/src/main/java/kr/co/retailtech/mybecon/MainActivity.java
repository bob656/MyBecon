package kr.co.retailtech.mybecon;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final int REQUEST_CODE_LOCATION_PERMISSIONS = 123;
    public static final int REQUEST_CODE_STORAGE_PERMISSIONS = 456;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        checkPermission();
    }

    private void checkPermission() {
        // observe location
        if (!hasLocationPermission(this)) {
            requestLocationPermission(this);
        }
//        else if (!isLocationEnabled(this)) {
//            requestLocationServices();
//        }

        // storage
        if (!hasStoragePermission(this)) {
            requestStoragePermission(this);
        }
//        else if (!isLocationEnabled(this)) {
//            requestLocationServices();
//        }
    }

    public static boolean hasLocationPermission(@NonNull Context context) {
        boolean fineLocation = ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
        boolean coarseLocation = ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
        return fineLocation && coarseLocation;
    }

    public static boolean hasStoragePermission(@NonNull Context context) {
        boolean readStorage = ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        boolean writeStorage = ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        return readStorage && writeStorage;
    }

    public static void requestLocationPermission(@NonNull Activity activity) {
        Log.e(TAG, "Requesting location permission");
        ActivityCompat.requestPermissions(activity, new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        }, REQUEST_CODE_LOCATION_PERMISSIONS);
    }

    public static void requestStoragePermission(@NonNull Activity activity) {
        Log.e(TAG, "Requesting storage permission");
        ActivityCompat.requestPermissions(activity, new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        }, REQUEST_CODE_STORAGE_PERMISSIONS);
    }


}
