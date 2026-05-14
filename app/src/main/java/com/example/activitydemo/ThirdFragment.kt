package com.example.activitydemo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult

class ThirdFragment : Fragment() {
    private val TAG = "FragmentLifecycle"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "ThirdFragment onCreateView")
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "ThirdFragment onViewCreated")

        val etName = view.findViewById<EditText>(R.id.et_name)
        val etAge = view.findViewById<EditText>(R.id.et_age)
        val btnSave = view.findViewById<Button>(R.id.btn_save)

        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString()

            setFragmentResult("requestKey", bundleOf("name" to name, "age" to age))
            
            // Navigate back to the first fragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FirstFragment())
                .commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "ThirdFragment onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "ThirdFragment onResume")
    }
}
