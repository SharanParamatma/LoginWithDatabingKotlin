package com.india.loginkotlinmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.india.loginkotlinmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding= DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        val request= ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.loginViewModel=request

        request.user.observe(this,{
            it?.mobile?.let { it1 -> Log.d("Login", it1) }
            it?.password?.let { it1 -> Log.d("Login", it1) }

           // now you pass this data to server with coroutine and retrofit which will come next video
        })

    }
}