package com.example.populararticles.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.populararticles.R
import com.example.populararticles.databinding.FragmentAboutBinding
import com.example.populararticles.databinding.FragmentHomeBinding

class AboutFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentAboutBinding>(inflater, R.layout.fragment_about, container, false)
        return binding.root
    }
}