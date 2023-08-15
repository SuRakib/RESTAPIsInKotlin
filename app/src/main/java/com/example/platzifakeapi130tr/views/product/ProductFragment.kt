package com.example.platzifakeapi130tr.views.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.platzifakeapi130tr.R
import com.example.platzifakeapi130tr.databinding.FragmentProductBinding


class ProductFragment : Fragment() {
//ss32
lateinit var binding: FragmentProductBinding
//ss37
val viewModel: ProductViewModel by viewModels()

    lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentProductBinding.inflate(inflater, container, false)

        adapter = ProductAdapter()
        viewModel.getAllProducts()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myProfileBtn.setOnClickListener {

      findNavController().navigate(R.id.action_productFragment_to_profileFragment)


        }

        viewModel.registerProduct.observe(viewLifecycleOwner) {
            if (it.isSuccessful) {
                adapter.submitList(it.body())

                binding.productRCV.adapter = adapter
            }
        }


    }


}