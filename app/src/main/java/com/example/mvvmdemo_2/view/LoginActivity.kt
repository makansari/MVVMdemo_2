package com.example.mvvmdemo_2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmdemo_2.R
import com.example.mvvmdemo_2.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val myViewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        binding.layoutViewmodel = myViewModel
        myViewModel.authListener = this

        progressBar.visibility = View.GONE

    }

    override fun onStarted() {
        progressBar.visibility = View.VISIBLE
        Toast.makeText(this, "Networkd Started", Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess(myresponse: LiveData<String>) {

        myresponse.observe(this, Observer {
            Toast.makeText(this, " success : " + it, Toast.LENGTH_SHORT).show()
            Log.i("mytag" , "Login Activity: " + it)
            progressBar.visibility = View.GONE
        })

    }

    override fun onFailure(msg : String) {
        Toast.makeText(this, "failure : " + msg , Toast.LENGTH_SHORT).show()

    }
}