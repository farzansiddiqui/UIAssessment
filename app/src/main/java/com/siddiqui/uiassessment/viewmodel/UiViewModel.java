package com.siddiqui.uiassessment.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.siddiqui.uiassessment.model.UiData;

public class UiViewModel extends ViewModel {
    private MutableLiveData<UiData> mutableLiveData = new MutableLiveData<>();

    public void setUiData(UiData uiData){
        mutableLiveData.setValue(uiData);
    }
    public LiveData<UiData> getData(){
        return mutableLiveData;
    }
}
