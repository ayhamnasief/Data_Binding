package com.example.data_binding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.data_binding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Basic Data Binding
        Person p1 = new Person(100, "Ayham", "ayham.nasief@gmail.com");
        binding.setPerson(p1);

        MyClickHandler myClickHandler = new MyClickHandler(this);
        binding.setClickEvent(myClickHandler);

        Animal animal = new Animal();
        binding.setAnimal(animal);


    }
}