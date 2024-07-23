package com.example.data_binding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Animal extends BaseObservable {
    String name;

    public Animal(){
    }

    public Animal(String name) {
        this.name = name;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

}
