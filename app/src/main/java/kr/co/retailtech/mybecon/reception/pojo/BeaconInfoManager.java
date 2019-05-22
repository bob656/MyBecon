package kr.co.retailtech.mybecon.reception.pojo;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class BeaconInfoManager {
    private String TAG = BeaconInfoManager.class.getSimpleName();

    private Subject<BeaconInformation> subject = PublishSubject.create();

    public void setBeaconInfomation(BeaconInformation beaconInformation){
        Log.d(TAG,beaconInformation.BeaconValueIndex_Major+"H!!!");
        subject.onNext(beaconInformation);
    }

    public Observable<BeaconInformation> updateEvent() {
        return subject.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
