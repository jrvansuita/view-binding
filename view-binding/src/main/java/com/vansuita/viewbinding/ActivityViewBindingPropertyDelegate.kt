package com.vansuita.viewbinding

import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.annotation.MainThread
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ActivityViewBindingPropertyDelegate<T : ViewBinding>(
	private val activity: ComponentActivity,
	private val viewBindingMethod: ViewBindingMethod,
	private val bindingClass: Class<T>
) : ReadOnlyProperty<ComponentActivity, T>, DefaultLifecycleObserver {

	private var binding: T? = null

	@MainThread
	override fun onCreate(owner: LifecycleOwner) {
		super.onCreate(owner)

		if (viewBindingMethod == ViewBindingMethod.INFLATE)
			activity.setContentView(binding!!.root)

		owner.lifecycle.removeObserver(this)
	}

	override fun getValue(thisRef: ComponentActivity, property: KProperty<*>): T {
		if (binding == null) {
			binding = when (viewBindingMethod) {
				ViewBindingMethod.BIND -> bindingClass.bind(
					thisRef.findViewById<ViewGroup>(android.R.id.content).getChildAt(0)
				)
				ViewBindingMethod.INFLATE -> bindingClass.inflate(thisRef.layoutInflater)
			}

			thisRef.lifecycle.addObserver(this)
		}

		return binding!!
	}
}