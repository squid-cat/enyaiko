package com.squids.enyaiko

import android.app.ActionBar
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CalendarView
import androidx.gridlayout.widget.GridLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        var calender_bc = findViewById<GridLayout>(R.id.calender_bc)
        for (i in 0 .. calender_bc.rowCount-1){
            for (j in 0 .. calender_bc.columnCount-1) {
                val view =  View(this)
                val param = GridLayout.LayoutParams()
                param.rowSpec= GridLayout.spec(i)
                param.columnSpec= GridLayout.spec(j)
                view.layoutParams = param
                Log.d("16進数の文字確認",Integer.toHexString(i*j).toString().padStart(2,'0'))
                print(Integer.toHexString(i*j).toString())
                view.setBackgroundColor(Color.parseColor("#ff00ff" + Integer.toHexString(i*j).toString().padStart(2,'0')))

                calender_bc.addView(view)
            }
        }




        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
         //Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}