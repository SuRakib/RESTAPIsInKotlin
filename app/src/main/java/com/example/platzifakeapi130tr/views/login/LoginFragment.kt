package com.example.platzifakeapi130tr.views.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.platzifakeapi130tr.R
import com.example.platzifakeapi130tr.databinding.FragmentLoginBinding
import com.example.platzifakeapi130tr.models.login.RequestLogin
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


//s13
@AndroidEntryPoint
class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding

    //s10
    private val viewModel: LoginViewModel by viewModels()  //insist of view model provider+1 line and this is providing object

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentLoginBinding.inflate(inflater,container,false)


        //s12

        viewModel.loginResponse.observe(viewLifecycleOwner) {


            if (it.isSuccessful) {

                Log.d("TAG", "Data : ${it.body()} ")

            }


        }

//

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginBtn.setOnClickListener{                         //s-1=value get from login fragment

         val email=binding.userEmail.text.toString().trim()
            val password=binding.password.text.toString().trim()

            handleLogin(email,password)                              //S-2= function call with email,pass parameter

        }

    }

    private fun handleLogin(email: String, password: String) {
  //s11
        val request = RequestLogin(email = email, password = password)

        viewModel.login(request)


    }          //

}