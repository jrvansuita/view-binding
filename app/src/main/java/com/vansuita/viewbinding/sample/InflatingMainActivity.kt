package com.vansuita.viewbinding.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.vansuita.viewbinding.ViewBindingMethod
import com.vansuita.viewbinding.sample.databinding.ActivityMainBinding
import com.vansuita.viewbinding.viewBinding

//Inflating Example
class InflatingMainActivity : AppCompatActivity() {

	private val binding by viewBinding<ActivityMainBinding>(ViewBindingMethod.INFLATE)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)
		bindListeners()
	}

	private fun bindListeners() {
		binding.btBind.setOnClickListener {
			replaceFragment(BindingFragment())
		}

		binding.btInflate.setOnClickListener {
			replaceFragment(InflatingFragment())
		}
	}

	private fun replaceFragment(fragment: Fragment) {
		supportFragmentManager.beginTransaction()
			.replace(R.id.container, fragment)
			.commit()
	}
}
