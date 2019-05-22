package kr.co.retailtech.mybecon.testFrame;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class TemperatureManager {
     private String TAG = TemperatureManager.class.getSimpleName();
    static class Temperature{
        private int currentTemperature;
        Temperature(int degree){
            this.currentTemperature = degree;
        }
        int getDegree(){
            return this.currentTemperature;
        }
        public void setCurrentTemperature(int currentTemperature) {
            this.currentTemperature = currentTemperature;
        }
    }
    private PublishSubject<Temperature> subject = PublishSubject.create();

    public TemperatureManager(){
        subject = PublishSubject.create();
    }


    void setTemperature(Temperature temperature) {
        subject.onNext(temperature);
    }

    Observable<Temperature> updateEvent() {
        Log.d("TAG", "Subject");
        return subject.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
