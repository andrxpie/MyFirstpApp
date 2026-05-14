package com.example.activitydemo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class SecondFragment : Fragment() {
    private val TAG = "FragmentLifecycle"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "SecondFragment onCreateView")
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "SecondFragment onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "SecondFragment onResume")
    }
}
