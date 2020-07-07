package com.example.viewmodelapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelClass extends ViewModel {


    Thread myThread;
    int count = 0;
    Boolean isInProgress;

    MutableLiveData<Integer> liveCount;

    public ViewModelClass(){

        liveCount = new MutableLiveData<>();
        isInProgress =false;
        myThread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (isInProgress) {
                    try {
                        Thread.sleep(1000);
                        count++;
                        liveCount.postValue(count);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }


    public void startCount(){
        if (!isInProgress){
            isInProgress = true;
            myThread.start();
        }
    }

    public void stopCount(){
        isInProgress = false;
    }

    public LiveData<Integer> getCount(){
        return liveCount;
    }
}
