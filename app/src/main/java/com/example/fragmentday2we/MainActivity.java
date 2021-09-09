package com.example.fragmentday2we;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private Button mBtnAddA,mBtnRemoveA,mBtnReplaceAWithBWithoutBackstack,mBtnReplaceAWithBackStack;
private Button mBtnAddB,mBtnRemoveB,mBtnReplaceBWithA;
private FragmentManager fragmentManager;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    fragmentManager = getSupportFragmentManager();


    }



    private void initview() {
        mBtnAddA = findViewById(R.id.btnAddA);
        mBtnAddB = findViewById(R.id.btnAddB);
        mBtnRemoveA = findViewById(R.id.btnRemoveA);
        mBtnRemoveB = findViewById(R.id.btnRemoveB);
        mBtnReplaceAWithBackStack =findViewById(R.id.btnReplaceAWithBackStack);
        mBtnReplaceAWithBWithoutBackstack =findViewById(R.id.btnReplaceAWithBWithoutBackstack);
        mBtnReplaceBWithA = findViewById(R.id.btnReplaceBWithA);
        mBtnAddA.setOnClickListener(this);
        mBtnAddB.setOnClickListener(this);
        mBtnRemoveA.setOnClickListener(this);
        mBtnRemoveB.setOnClickListener(this);
        mBtnReplaceAWithBackStack.setOnClickListener(this);
        mBtnReplaceAWithBWithoutBackstack.setOnClickListener(this);
        mBtnReplaceBWithA.setOnClickListener(this);

    }

private void addA(){
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    FragmentA fragmentA = new FragmentA();
    fragmentTransaction.add(R.id.flContainer,fragmentA,"fragmentA").commit();

}

    private void addB(){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.add(R.id.flContainer,fragmentB,"fragmentB").commit();

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnAddA:
                addA();
                break;
            case R.id.btnAddB:
                addB();
                break;
            case R.id.btnRemoveA:
                removeA();
                break;
            case R.id.btnRemoveB:
                removeB();
                break;
            case R.id.btnReplaceBWithA:
                replaceBwithA();
            case R.id.btnReplaceAWithBackStack:
                replaceAwithBackStack();
        }

    }

    private void replaceAwithBackStack() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.replace(R.id.flContainer,fragmentB,"fragmentB").addToBackStack("fragB").commit();
    }

    private void replaceBwithA() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.replace(R.id.flContainer,fragmentA,"fragmentA");
    }

    private void removeB() {
FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentByTag("fragmentB");
if (fragmentB!=null){
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.remove(fragmentB).commit();
}
    }

    private void removeA() {
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("fragmentA");
        if (fragmentA!=null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentA).commit();
        }
    }
}