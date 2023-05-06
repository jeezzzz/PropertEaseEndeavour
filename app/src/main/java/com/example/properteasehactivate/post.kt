package com.example.properteasehactivate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [post.newInstance] factory method to
 * create an instance of this fragment.
 */
class post : Fragment() {
    private lateinit var Name: EditText
    private lateinit var phoneno: EditText
    private lateinit var adress: EditText
    private lateinit var area: EditText
    private lateinit var price: EditText
    private lateinit var bhk: EditText
    private lateinit var park: EditText
    private lateinit var save: Button

    private lateinit var dbRef: DatabaseReference
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
        val view= inflater.inflate(R.layout.fragment_post, container, false)
//write your code here
        Name = view.findViewById(R.id.ownerName)
        phoneno = view.findViewById(R.id.Contactno)
        adress = view.findViewById(R.id.Address)
        area = view.findViewById(R.id.Size)
        price = view.findViewById(R.id.Price)
        bhk = view.findViewById(R.id.BHK)
        park = view.findViewById(R.id.Parking)
        save = view.findViewById(R.id.Save)

        dbRef = FirebaseDatabase.getInstance().getReference("Owners")

        save.setOnClickListener {
            saveOwnerData()
            Toast.makeText(requireContext(), "Details Saved", Toast.LENGTH_LONG).show()

            Name.text.clear()
            phoneno.text.clear()
            adress.text.clear()
            area.text.clear()
            price.text.clear()
            bhk.text.clear()
            park.text.clear()
        }

        return view
    }
    private fun saveOwnerData() {
        val pname = Name.text.toString()
        val number = phoneno.text.toString()
        val adres = adress.text.toString()
        val areas = area.text.toString()
        val cost = price.text.toString()
        val spaceing = bhk.text.toString()
        val parking = park.text.toString()

        if (pname.isEmpty()) {
            Name.error = "Field Required"
            return
        }
        if (number.isEmpty()) {
            phoneno.error = "Field Required"
            return
        }
        if (adres.isEmpty()) {
            adress.error = "Field Required"
            return
        }
        if (areas.isEmpty()) {
            area.error = "Field Required"
            return
        }
        if (cost.isEmpty()) {
            price.error = "Field Required"
            return
        }
        if (spaceing.isEmpty()) {
            bhk.error = "Field Required"
            return
        }
        if (parking.isEmpty()) {
            park.error = "Field Required"
            return
        }

        val ownerid = dbRef.push().key!!
        val owner = OwnerModel(ownerid, pname, number, adres, areas, cost, spaceing, parking)

        dbRef.child(ownerid).setValue(owner)
            .addOnCompleteListener {
                Toast.makeText(requireContext(), "Details Saved", Toast.LENGTH_LONG).show()

                Name.text.clear()
                phoneno.text.clear()
                adress.text.clear()
                area.text.clear()
                price.text.clear()
                bhk.text.clear()
                park.text.clear()
            }
            .addOnFailureListener { err ->
                Toast.makeText(requireContext(), "Error ${err.message}", Toast.LENGTH_LONG).show()
            }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment post.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            post().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}