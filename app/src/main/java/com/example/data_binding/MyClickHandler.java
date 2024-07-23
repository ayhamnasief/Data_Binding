package com.example.data_binding;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class MyClickHandler {
    Context context;

    public MyClickHandler(Context context) {
        this.context = context;
    }
    
    public void myClickEvent(View view){
        Toast.makeText(context, "Hi Bro", Toast.LENGTH_SHORT).show();
    }
}
