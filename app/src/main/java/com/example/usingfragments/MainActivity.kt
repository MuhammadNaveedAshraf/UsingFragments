package com.example.usingfragments

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import com.example.usingfragments.SignUpPrefs


class MainActivity : AppCompatActivity() {
    private val fragmentManager = supportFragmentManager
    var currentActiveButton:Int =-1
    fun constraintFragment(view: View){
        val person: Person = Person("naveed","manshraf@gmail.com","123123123","12359403")
        val bundle: Bundle = Bundle()
        bundle.putString("name",person.name)
        bundle.putString("email",person.email)
        bundle.putString("password",person.password)
        bundle.putString("phone",person.phone)

        val fragment = ConstraintFragment()
        fragment.arguments = bundle
        val newBtn = R.id.fragment1_btn
        activateButton(newBtn)
        replaceFragment(fragment,newBtn)
    }
    fun relativeFragment(view: View){
        val newBtn = R.id.fragment2_btn
        activateButton(newBtn)
        replaceFragment(RelativeFragment(),newBtn)
    }
    fun linearFragment(view: View){
        val newBtn = R.id.fragment3_btn
        activateButton(newBtn)
        replaceFragment(LinearFragment(),newBtn)
    }
    fun replaceFragment(fragment:Fragment,newBtn:Int){
        if(newBtn!=currentActiveButton){
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainerView,fragment)
//        fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            currentActiveButton = newBtn
        }
    }
    fun activateButton(buttonId:Int){
        val newBtn:Button = findViewById(buttonId)
        if(currentActiveButton!=-1){
            val currentBtn:Button = findViewById(currentActiveButton)
            currentBtn.setTextColor(Color.WHITE)
            currentBtn.setBackgroundColor(getResources().getColor(R.color.dark_red))
//            currentBtn.background = resources.getDrawable(R.color.button_background_color)
        }
        newBtn.setBackgroundColor(Color.GRAY)
        newBtn.setTextColor(Color.BLACK)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}