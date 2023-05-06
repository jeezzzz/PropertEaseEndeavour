package com.example.properteasehactivate

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [home.newInstance] factory method to
 * create an instance of this fragment.
 */
class home : Fragment() {
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

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_home, container, false)
        val notilogo=view.findViewById<ImageView>(R.id.notilogo)
        notilogo.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_notification)
        }
        val profile=view.findViewById<ImageView>(R.id.profile)
        profile.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_profile)
        }
        val packingandlodging=view.findViewById<TextView>(R.id.packingandlodgingtxt)
        packingandlodging.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_packingandlodging)
        }
        val advice=view.findViewById<TextView>(R.id.advicetxt)
        advice.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_advice)
        }

        val houseview=view.findViewById<CardView>(R.id.houseview1)
        houseview.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_homegeneral)
        }
        val houseviewverified=view.findViewById<CardView>(R.id.houseviewverified1)
        houseviewverified.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_homeverified)
        }
        val vmoney=view.findViewById<TextView>(R.id.valueformoney)
        vmoney.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_valuemoney)
        }
        val rateprid=view.findViewById<TextView>(R.id.ratepredictiontxt)
        rateprid.setOnClickListener{
            val browserIntent = Intent(Intent.ACTION_VIEW)
            browserIntent.data = Uri.parse("http://172.16.1.152:8502/")
            startActivity(browserIntent)
        }

   return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}