package com.malkinfo.autocompletetextexmple

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private lateinit var completeText:AutoCompleteTextView
    private lateinit var display:TextView
    private lateinit var subBtn :Button
    val foodList = arrayListOf<String>(
        "Vada Pav","Chicken Biryani","Dal Khana","Chapati","Anda Biryani",
        "Egg Rice","Hyderabad Biryani","Sharma","Mandi","Chicken 65","brinjal gravy",
        "Snack","finger chips","pizza","Passta","Maggi","Tea","Burger"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**find Id All*/

        completeText = findViewById(R.id.completeText)
        display = findViewById(R.id.tvDisplay)
        subBtn = findViewById(R.id.btn)
        /**set Adapter*/
        val adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1,
            foodList
        )
        completeText.setAdapter(adapter)
        completeText.onItemClickListener = this



    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
       val item = parent?.getItemAtPosition(position).toString()
        /**set Toast massge*/
        Toast.makeText(this,item,Toast.LENGTH_SHORT).show()
        /**set KeyBord Hide*/
        var km = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        km.hideSoftInputFromWindow(currentFocus?.windowToken,0)
        subBtn.setOnClickListener {
            /**set Display*/
            display.text = item
            display.visibility = View.VISIBLE
            completeText.setText("")

        }
    }
}


