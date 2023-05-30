package com.siddiqui.uiassessment.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.siddiqui.uiassessment.model.UiData;

import java.util.ArrayList;
import java.util.List;

public class UiViewModel extends ViewModel {
    private MutableLiveData<UiData> mutableLiveData = new MutableLiveData<>();

    private List<MutableLiveData<String>> textViewsData;

    public List<MutableLiveData<String>> getTextViewsData() {
        if (textViewsData == null) {
            textViewsData = new ArrayList<>();
            for (int i = 0; i <= 5; i++) {
                textViewsData.add(new MutableLiveData<>());
            }
        }
        return textViewsData;
    }

    public void setUiData(UiData uiData){
        mutableLiveData.setValue(uiData);
    }
    public LiveData<UiData> getData(){
        return mutableLiveData;
    }

}
