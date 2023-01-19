<img src="app/src/main/res/mipmap-xxxhdpi/ic_launcher_round.png?raw=true" align="left" hspace="1" vspace="1">

# View Binding

This is an [**Android**](https://developer.android.com) library. It makes your life easier by reducing boilerplate code and avoiding redudante lines of code when are using the [ViewBinding](https://developer.android.com/topic/libraries/view-binding) feature on your Android project. This library show up in my head as an very good example on how the property delegation functionality from kotlin can help us.


-----

### Usage on Activity

<details open><summary>Binding</summary>

> Yes, the ```viewBinding()``` method will bind to the root view for you.

```Kotlin

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding : ActivityMainBinding by viewBinding()
}

```
</details>

<details><summary>Inflating</summary>

> You don't need to set the layout calling ```setContentView()```. It will be done automatically.
```Kotlin

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by viewBinding(ViewBindingMethod.INFLATE)
    
}

```
</details>
    
### Usage on Fragment

<details><summary>Binding</summary>

```Kotlin
 
> The ```viewBinding()``` method will track the fragment view lifecycle and destroy the ViewBinding instance for you.
    
class MyFragment : Fragment(R.layout.fragment_layout) {

    private val binding by viewBinding<FragmentLayoutBinding>()
    
}
```
</details>

<details><summary>Inflating</summary>

> Using this way, it gives you the ```onCreateView```
    
```Kotlin
class MyFragment : Fragment() {

    private val binding by viewBinding<FragmentLayoutBinding>(ViewBindingMethod.INFLATE)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root
}
```
</details>
