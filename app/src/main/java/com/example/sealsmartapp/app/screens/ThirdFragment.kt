package com.example.sealsmartapp.app.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import com.example.sealsmartapp.R
import com.example.sealsmartapp.databinding.FragmentSecondBinding
import com.example.sealsmartapp.databinding.FragmentThirdBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThirdFragment : Fragment() {

    private lateinit var binding: FragmentThirdBinding
    private val viewModel by viewModels<ThirdViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater, container, false)

        binding.button.setOnClickListener {
            viewModel.getAccount()
        }

        viewModel.liveData.observe(viewLifecycleOwner) {
            setFragmentResult("KEY", bundleOf("key" to  it))
        }



        return binding.root
    }

    companion object {
        fun newInstance() = ThirdFragment()
    }
}