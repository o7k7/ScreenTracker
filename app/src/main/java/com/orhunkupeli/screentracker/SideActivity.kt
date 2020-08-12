package com.orhunkupeli.screentracker

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_side)

        supportFragmentManager.beginTransaction().add(
            R.id.frm_container,
            InnerFragment()
        ).commit()
    }

    fun test() {
        Log.e("TEST::", "ORHUN")
    }
}