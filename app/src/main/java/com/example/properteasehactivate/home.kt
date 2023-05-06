package com.example.properteasehactivate

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_home, container, false)
        val notilogo=view.findViewById<ImageView>(R.id.notilogo)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager


        notilogo.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_notification)
        }
        val profile=view.findViewById<ImageView>(R.id.profile)
        profile.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_profile)
        }
        val futureRatePrediction=view.findViewById<TextView>(R.id.futureRatePredictionTxt)
        futureRatePrediction.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_futureRatePrediction)
        }
        val advice=view.findViewById<TextView>(R.id.advicetxt)
        advice.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_advice)
        }


        recyclerView.setOnClickListener{
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
            findNavController().navigate(R.id.action_home2_to_ratePrediction)
        }
        val prices = arrayOf(
            "₹56 LAC", "₹72 LAC", "₹85 LAC", "₹64 LAC", "₹91 LAC",
            "₹78 LAC", "₹68 LAC", "₹93 LAC", "₹82 LAC", "₹76 LAC"
        )
        val bhk = arrayOf(
            "1 BHK", "2 BHK", "3 BHK", "4 BHK", "1 BHK",
            "2 BHK", "3 BHK", "4 BHK", "1 BHK", "2 BHK"
        )

        val sqft = arrayOf(
            " | 800 sqft", " | 1000 sqft", " | 1200 sqft", " | 1500 sqft", " | 900 sqft",
            " | 1100 sqft", " | 1300 sqft", " | 1600 sqft", " | 950 sqft", " | 1050 sqft"
        )
        val photo = arrayOf(
            R.drawable.house1, R.drawable.house2, R.drawable.house3, R.drawable.house4, R.drawable.house5, R.drawable.house6, R.drawable.house7, R.drawable.house8, R.drawable.house9, R.drawable.house10)

        val houselist = ArrayList<House>()
        for(i in 0..9)
        {
            val house = House(photo[i], prices[i],bhk[i],sqft[i])
            houselist.add(house)
        }
        val myfkinAdapter = Adapter(houselist)
        val rv = view.findViewById<RecyclerView>(R.id.recyclerView)
        rv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rv.adapter=myfkinAdapter

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