package com.example.properteasehactivate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [premium.newInstance] factory method to
 * create an instance of this fragment.
 */
class premium : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_premium, container, false)


    return view}

    private fun popBackStack() {
        val fragmentManager = childFragmentManager
        val backStackCount = fragmentManager.backStackEntryCount

        if (backStackCount > 0) {
            fragmentManager.popBackStackImmediate()
        } else {
            // Navigate to the home fragment
            val homeFragment = home()
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.premium, homeFragment)
            transaction.commit()
        }

    }}