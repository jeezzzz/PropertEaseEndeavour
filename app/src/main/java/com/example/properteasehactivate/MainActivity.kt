package com.example.properteasehactivate

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val post: ImageView =findViewById(R.id.post)
        post.setOnClickListener{
            setContentView(R.layout.fragment_post)
        }
        val advice: ImageView =findViewById(R.id.advice)
        advice.setOnClickListener{
            setContentView(R.layout.fragment_profile)
        }
        val like: ImageView =findViewById(R.id.like)
        like.setOnClickListener{
            setContentView(R.layout.fragment_like)
        }
        val premium: ImageView =findViewById(R.id.premium)
        premium.setOnClickListener{
            setContentView(R.layout.fragment_premium)
        }
    }
}