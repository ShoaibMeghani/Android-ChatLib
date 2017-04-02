package com.smeghani.chatlibexample.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.smeghani.chatlibexample.R;


/**
 * Created by smeghani on 3/21/2017.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new ChatListFragment()).commit();
    }

    public void switchFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container,fragment).commit();
    }
}
