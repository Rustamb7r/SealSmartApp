package com.example.sealsmartapp.app.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import com.example.sealsmartapp.data.navigator
import com.example.sealsmartapp.databinding.FragmentSecondBinding
import com.example.sealsmartapp.domain.entities.AccountModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private val viewModel by viewModels<SecondViewModel>()
    var onDismissListener: ((textAccountModel: String) -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSecondBinding.inflate(inflater, container, false)

        binding.back.setOnClickListener { goBack() }

        binding.thirdFragment.setOnClickListener { navigator().showThirdFragment() }

        binding.textFromFirstFragment.text =
            requireArguments().getParcelable<AccountModel>(NAME)?.username

        viewModel.liveData.observe(viewLifecycleOwner) {
            onDismissListener?.invoke(it)
            binding.text2.text = it
        }

        binding.button.setOnClickListener {
            viewModel.getAccount()
        }

        setFragmentResultListener("KEY") { _, bundle ->
            val result = bundle.getString("key")
            binding.textFromThirdFragment.text = result
        }


        return binding.root
    }

    fun goBack() {
        requireActivity().onBackPressed()
    }

    companion object {
        private const val NAME = "SECRET"

        fun newInstance(account: AccountModel): SecondFragment {
            val fragment = SecondFragment()
            fragment.arguments = bundleOf(NAME to account)
            return fragment
        }
    }
}