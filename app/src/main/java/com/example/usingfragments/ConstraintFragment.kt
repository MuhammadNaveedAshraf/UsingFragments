package com.example.usingfragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ConstraintFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ConstraintFragment : Fragment() {
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
        val view: View = inflater.inflate(R.layout.fragment_constraint,container,false)
        val bundle = arguments
        val person:Person = Person()
        person.name = bundle!!.getString("name")
        person.email = bundle!!.getString("email")
        person.password = bundle!!.getString("password")
        person.phone = bundle!!.getString("phone")
        view.findViewById<EditText>(R.id.username_editText).setText(person.name)
        view.findViewById<EditText>(R.id.email_editText).setText(person.email)
        view.findViewById<EditText>(R.id.password_editText).setText(person.password)
        view.findViewById<EditText>(R.id.phone_editText).setText(person.phone)



//        val button = requireView().findViewById<Button>(R.id.sign_up_btn)

//        button.setOnClickListener {
//
//            val fragment = RelativeFragment()
//
//            val bundle: Bundle = Bundle()
//            bundle.putString("name",requireView().findViewById<EditText>(R.id.username_editText).text.toString())
//            bundle.putString("email",requireView().findViewById<EditText>(R.id.email_editText).text.toString())
//            bundle.putString("password",requireView().findViewById<EditText>(R.id.password_editText).text.toString())
//            bundle.putString("phone",requireView().findViewById<EditText>(R.id.phone_editText).text.toString())
//            fragment.arguments = bundle
//
//        }
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_constraint, container, false)

    return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ConstraintFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ConstraintFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}