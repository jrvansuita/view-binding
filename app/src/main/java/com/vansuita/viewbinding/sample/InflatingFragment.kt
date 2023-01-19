package com.vansuita.viewbinding.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vansuita.viewbinding.ViewBindingMethod
import com.vansuita.viewbinding.sample.databinding.FragmentInflateBinding
import com.vansuita.viewbinding.viewBinding

class InflatingFragment : Fragment() {

	private val binding by viewBinding<FragmentInflateBinding>(ViewBindingMethod.INFLATE)

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	) = binding.root
}