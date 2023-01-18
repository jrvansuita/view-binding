package com.vansuita.viewbinding

import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


class FragmentViewBindingPropertyDelegate<T : ViewBinding>(
	private val viewBindingMethod: ViewBindingMethod,
	private val bindingClass: Class<T>,
) : ReadOnlyProperty<Fragment, T>, DefaultLifecycleObserver {

	private var binding: T? = null

	@MainThread
	override fun onDestroy(owner: LifecycleOwner) {
		owner.lifecycle.removeObserver(this)
		binding = null
	}

	override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
		if (binding == null) {
			binding = when (viewBindingMethod) {
				ViewBindingMethod.BIND -> bindingClass.bind(thisRef.requireView())
				ViewBindingMethod.INFLATE -> bindingClass.inflate(thisRef.layoutInflater)
			}

			thisRef.viewLifecycleOwner.lifecycle.addObserver(this)
		}

		return binding!!
	}
}
