package com.example.pageviewer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.pageviewer.databinding.FragmentImageBinding

class ImageFragment : Fragment() {

    private var binding: FragmentImageBinding? = null
    private lateinit var args: ImageFragmentArgs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null)
            binding = FragmentImageBinding.inflate(inflater, container, false)
        init()
        return binding!!.root
    }

    private fun init() {
        args = ImageFragmentArgs.fromBundle(requireArguments())
        binding!!.imgLogo.setImageResource(args.image)
        binding!!.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}