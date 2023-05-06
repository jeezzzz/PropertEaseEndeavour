package com.example.properteasehactivate

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import com.google.firebase.FirebaseApp


class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    private var navController: NavController? = null
    private lateinit var fragmentManager: FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(applicationContext)
        fragmentManager = supportFragmentManager
        val post: ImageView = findViewById(R.id.post)
        post.setOnClickListener {
            navigateToFragment(post())
        }

        val advice: ImageView = findViewById(R.id.advice)
        advice.setOnClickListener {
            navigateToFragment(Advice())
        }

        val like: ImageView = findViewById(R.id.like)
        like.setOnClickListener {
            navigateToFragment(like())
        }

        val premium: ImageView = findViewById(R.id.premium)
        premium.setOnClickListener {
            navigateToFragment(premium())
        }

    }
    private fun navigateToFragment(fragment: androidx.fragment.app.Fragment) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host, fragment, fragment.javaClass.simpleName)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}