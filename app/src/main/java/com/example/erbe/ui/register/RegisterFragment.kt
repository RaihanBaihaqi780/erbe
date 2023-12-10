package com.example.erbe.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.erbe.R
import com.example.erbe.databinding.FragmentRegisterBinding
import com.example.erbe.local.UserEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null

    private val binding get() = _binding!!
    private val viewModel: RegisterViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState:Bundle?
    ): View?{
        _binding = FragmentRegisterBinding.inflate(inflater, container,false)
        init()
        observeData()
        return binding.root

    }
    private fun observeData(){
        with(viewModel){
            observeRegister().observe(viewLifecycleOwner){
                it.let{data->
                    if (data){
                        findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                    }else{
                        Toast.makeText(requireContext(),"Email Sudah Terdaftar", Toast.LENGTH_LONG).show()
                    }

                }
            }
        }
    }
    private fun init(){
        binding.btnDaftar.setOnClickListener{
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val user = UserEntity(0, name, email, password )
            viewModel.insertUser(user)


        }
    }
}