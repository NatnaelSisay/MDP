package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import com.example.lab3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val waterData: ArrayList<WaterData> = arrayListOf()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {




        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.addResourceButton.setOnClickListener {
            val name :String = binding.waterResourceNameField.text.toString().trim()
            val location :String = binding.locationField.text.toString().trim()
            val type :String = binding.typeField.text.toString().trim()

            if(name.isEmpty() || location.isEmpty() || type.isEmpty()){
                Toast.makeText(this, "Fields cannot be empty!!", Toast.LENGTH_LONG).show()
            }else{
                val w = WaterData(name, location, type)
                waterData.add(w)
                addWaterDataToTable(w)
            }

        }

        waterData.forEach {
         addWaterDataToTable(it)
        }





        setContentView(binding.root)


    }


    fun addWaterDataToTable(waterData: WaterData){
        val t = TableRow(this).apply {
            showDividers = LinearLayout.SHOW_DIVIDER_BEGINNING
        }
        t.addView(TextView(this,).apply {
            this.text = waterData.name
        })
        t.addView(TextView(this,).apply {
            this.text = waterData.location
        })
        t.addView(TextView(this,).apply {
            this.text = waterData.type
        })
        binding.table.addView(t)
    }
}