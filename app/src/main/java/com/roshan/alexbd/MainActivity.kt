package com.roshan.alexbd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.roshan.alexbd.ui.ItemFragment
import com.roshan.alexbd.ui.OnFragmentInteractionListener
import com.roshan.alexbd.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    override fun onButtonClick() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ItemFragment.newInstance(0))
            .commitNow()
    }
}