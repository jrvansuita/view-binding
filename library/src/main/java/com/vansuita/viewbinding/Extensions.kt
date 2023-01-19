package com.vansuita.viewbinding

import android.view.LayoutInflater
import android.view.View
import androidx.activity.ComponentActivity
import androidx.annotation.RestrictTo
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

inline fun <reified T : ViewBinding> Fragment.viewBinding(viewBindingMethod: ViewBindingMethod = ViewBindingMethod.BIND) =
	FragmentViewBindingPropertyDelegate(viewBindingMethod, T::class.java)

inline fun <reified T : ViewBinding> ComponentActivity.viewBinding(viewBindingMethod: ViewBindingMethod = ViewBindingMethod.BIND) =
	ActivityViewBindingPropertyDelegate(this, viewBindingMethod, T::class.java)

@RestrictTo(RestrictTo.Scope.LIBRARY)
internal fun <T : ViewBinding> Class<T>.bind(view: View) =
	getMethod("bind", View::class.java)
		.invoke(null, view) as T

@RestrictTo(RestrictTo.Scope.LIBRARY)
internal fun <T : ViewBinding> Class<T>.inflate(layoutInflater: LayoutInflater) =
	getMethod("inflate", LayoutInflater::class.java)
		.invoke(null, layoutInflater) as T

