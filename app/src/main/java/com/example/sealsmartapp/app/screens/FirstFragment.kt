package com.example.sealsmartapp.app.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.sealsmartapp.R
import com.example.sealsmartapp.data.navigator
import com.example.sealsmartapp.databinding.FragmentFirstBinding
import com.example.sealsmartapp.domain.entities.AccountModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel by viewModels<FirstViewModel>()
    private var accountModel: AccountModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        if (accountModel == null)
            binding.buttonNextFragment.setEnabled(false)

        binding.requstToken.setOnClickListener {
            viewModel.zaprosToken()
        }
        binding.requstAccount.setOnClickListener {
            viewModel.zaprosAccount()
            binding.buttonNextFragment.setEnabled(true)
        }

        binding.buttonNextFragment.setOnClickListener {
            navigator().showSecondFragment(accountModel!!, viewModel)
        }

        viewModel.liveDataAccount.observe(viewLifecycleOwner) {
            binding.tvTest.text = it
        }

        viewModel.liveData2.observe(viewLifecycleOwner) {
            accountModel = it
        }

        viewModel.liveData.observe(viewLifecycleOwner) {
            binding.textView.text = it
        }

        return binding.root
    }

    companion object {
        fun newInstance() = FirstFragment()

    }
}