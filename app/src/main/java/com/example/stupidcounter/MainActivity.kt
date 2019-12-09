package com.example.stupidcounter

import CounterViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var counterViewModel:CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity","onCrate")

        //Initialised the VIewModel
        counterViewModel= ViewModelProviders.of(this)
            .get(CounterViewModel::class.java)

        counterViewModel.counter.observe(this,

            Observer {
                if(counterViewModel.counter.value==10){
                    goodJob()
                }
            }
            )


        button.setOnClickListener{
            counterViewModel.increment()
            textViewCounter.text=counterViewModel.counter.value.toString()

        }
        button2.setOnClickListener{
            counterViewModel.decrement()
            textViewCounter.text=counterViewModel.counter.value.toString()

        }
    }

    private fun goodJob() {
       Toast.makeText(applicationContext,"What a good job, hahahhahha",
           Toast.LENGTH_LONG).show()

    }

    override fun onDestroy() {
        Log.d("MainActivity","OnDestroy")
        super.onDestroy()
    }
}
