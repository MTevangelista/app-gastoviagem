package com.example.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        setListeners()
    }
    
    private fun setListeners() {
        buttonCalculate.setOnClickListener(this)
    }
    
    override fun onClick(view: View) {
        val id = view.id
        
        if (id == R.id.buttonCalculate) {
            calculate()
        }
    }
    
    private fun calculate() {
        if (validationOk()) {
            val distance = editTxtDistance.text.toString().toFloat()
            val price = editTxtPrice.text.toString().toFloat()
            val autonomy = editTxtAutonomy.text.toString().toFloat()
            
            val totalValue = (distance * price) / autonomy
            txtViewTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
        }
    }
    
    private fun validationOk(): Boolean {
        return (
                editTxtDistance.text.toString() != ""
                && editTxtPrice.text.toString() != ""
                && editTxtAutonomy.text.toString() != ""
        )
    }
    
}