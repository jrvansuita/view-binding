package com.vansuita.viewbinding.sample

import androidx.fragment.app.Fragment
import com.vansuita.viewbinding.sample.databinding.FragmentBindBinding
import com.vansuita.viewbinding.viewBinding

class BindingFragment : Fragment(R.layout.fragment_bind) {

	private val binding: FragmentBindBinding by viewBinding()

}