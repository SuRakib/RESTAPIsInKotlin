package com.example.platzifakeapi130tr.views.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import coil.load
import com.example.platzifakeapi130tr.databinding.FragmentProfileBinding
//s28
class ProfileFragment : Fragment() {

     lateinit var binding: FragmentProfileBinding

     val viewModel : ProfileViewModel by viewModels()   //view model creation

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

      binding=FragmentProfileBinding.inflate(inflater, container, false)

       viewModel.getUserProfile()   ////view model call
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

  //observer

    viewModel.profileResponse.observe(viewLifecycleOwner){

        //s-31
        Log.d("TAG", "response : ${it}} ")

  if(it.isSuccessful){

      it.body()?.let {

    binding.apply {

       nameValueTextView.text=it.name
        emailValueTextView.text=it.email
        roleValueTextView.text=it.role
        avatarImageView.load(it.avatar)

    }

      }


  }

    }


    }


}