package com.example.livedatacounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val counter = MutableLiveData<Int>()//1. declare a variable type MutableLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counter.value = 0 //2. Give a value to the variable

        incrementButton.setOnClickListener(View.OnClickListener {
            counter.value = counter.value!!.plus(1)
        })

        val observer: Observer<Int> = object : Observer<Int> {
            override fun onChanged(t: Int?) {
               Log.i("MainActivity  ", "new counter = $t")
                incrementTextView.text = t.toString()
            }
        }

        counter.observe(this,observer)//3. Mix livedata with the observer


        //USING LAMDA //3
//        val observer: Observer<Int> = Observer { newValue ->
//            Log.i("MainActivity  ", "new counter = $newValue")
//        }
//
////        counter.observe(this,observer)
//        counter.observe(this,Observer { newValue ->
//            Log.i("MainActivity  ", "new counter = $newValue")
//            incrementTextView.text = newValue.toString()
//        })
    }


}
