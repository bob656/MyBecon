package kr.co.retailtech.mybecon.testFrame;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class TemperatureManager {

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

    void setTemperature(Temperature temperature) {
        subject.onNext(temperature);
    }

    Observable<Temperature> updateEvent() {
        return subject.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
