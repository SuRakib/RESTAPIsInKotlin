package com.example.platzifakeapi130tr.views.register

import android.app.DownloadManager.Request
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.platzifakeapi130tr.R
import com.example.platzifakeapi130tr.databinding.FragmentRegisterBinding
import com.example.platzifakeapi130tr.models.register.RequestRegister
import dagger.hilt.android.AndroidEntryPoint

//S20
@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private  val viewModel : RegisterViewModel by viewModels()
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding=FragmentRegisterBinding.inflate(inflater, container, false)

        //add observer ..it works like ear
        viewModel.registerResponse.observe(viewLifecycleOwner){


            if (it.isSuccessful) {

                Log.d("TAG", "DATA : ${it.body()} ")

            }



        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.registerBtn.setOnClickListener {

            val name= binding.userName.text.toString().trim()
            val email= binding.userEmail.text.toString().trim()
            val password= binding.password.text.toString().trim()

            handleRegister(name,email,password)


        }
        binding.loginBtn.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)

        }

    }

    private fun handleRegister(name: String, email: String, password: String) {

        //call view model

        val request= RequestRegister(name=name,
            email = email,
            password = password,
            avatar = "https://img.freepik.com/free-vector/cute-cool-baby-holding-teddy-bear-doll-cartoon-vector-icon-illustration-people-holiday-isolated_138676-5356.jpg?w=2000")

        viewModel.register(request)
    }


}