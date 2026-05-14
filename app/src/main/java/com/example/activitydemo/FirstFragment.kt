package com.example.activitydemo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener

class FirstFragment : Fragment() {
    private val TAG = "FragmentLifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "FirstFragment onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "FirstFragment onCreateView")
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "FirstFragment onViewCreated")
        val tvData = view.findViewById<TextView>(R.id.tv_data)

        setFragmentResultListener("requestKey") { _, bundle ->
            val name = bundle.getString("name")
            val age = bundle.getString("age")
            tvData.text = "Ім'я: $name, Вік: $age"
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "FirstFragment onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "FirstFragment onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "FirstFragment onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "FirstFragment onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "FirstFragment onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "FirstFragment onDestroy")
    }
}
