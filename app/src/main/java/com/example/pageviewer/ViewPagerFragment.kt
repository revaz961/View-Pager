package com.example.pageviewer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.pageviewer.databinding.FragmentViewPagerBinding


class ViewPagerFragment : Fragment() {

    private var binding: FragmentViewPagerBinding? = null
    private var technologies = mutableListOf<Technology>()
    private lateinit var vpTechnology: ViewPager
    private lateinit var adapter: PagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null) {
            binding = FragmentViewPagerBinding.inflate(inflater, container, false)
            init()
        }
        return binding!!.root
    }

    private fun init() {
        vpTechnology = binding?.vpTechnology!!
        adapter = TechnologyPageAdapter(technologies) {
            val action =
                ViewPagerFragmentDirections.actionViewPagerFragmentToImageFragment(technologies[it].image)
            findNavController().navigate(action)
        }
        vpTechnology.adapter = adapter
    }

    private fun setData() {
        technologies.addAll(
            listOf(
                Technology(
                    getString(R.string.kotlin_title),
                    getString(R.string.kotlin_description),
                    R.drawable.kotlin
                ),
                Technology(
                    getString(R.string.java_title),
                    getString(R.string.java_description),
                    R.drawable.java
                ),
                Technology(
                    getString(R.string.cplus_title),
                    getString(R.string.cplus_description),
                    R.drawable.cplus
                ),
                Technology(
                    getString(R.string.csharp_title),
                    getString(R.string.csharp_description),
                    R.drawable.c_sharp
                ),
                Technology(
                    getString(R.string.python_title),
                    getString(R.string.python_description),
                    R.drawable.python
                ),
                Technology(
                    getString(R.string.js_title),
                    getString(R.string.js_description),
                    R.drawable.nodejs
                ),
                Technology(
                    getString(R.string.angular_title),
                    getString(R.string.angular_description),
                    R.drawable.angular
                ),
                Technology(
                    getString(R.string.react_title),
                    getString(R.string.react_description),
                    R.drawable.react
                )
            )
        )
    }

}