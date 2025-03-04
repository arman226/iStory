package com.example.istory.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.istory.BaseApp
import com.example.istory.R
import com.example.istory.databinding.FragmentCalendarBinding
import com.example.istory.viewmodel.StoryViewModel


class CalendarFragment : Fragment(R.layout.fragment_calendar) {

    lateinit var binding:FragmentCalendarBinding
    private lateinit var storyViewModel: StoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)

        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_calendar, container, false);
        storyViewModel= ViewModelProviders.of(requireActivity()).get(StoryViewModel::class.java)
        binding.myViewModel = storyViewModel
        binding.lifecycleOwner=requireActivity()

        return binding.root

    }

}