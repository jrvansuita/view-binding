<img src="app/src/main/res/mipmap-xxxhdpi/ic_launcher_round.png?raw=true" align="left" hspace="1" vspace="1">

# View Binding

This is an [**Android**](https://developer.android.com) library. It makes your life easier by reducing boilerplate code and avoiding redudante lines of code when are using the [ViewBinding](https://developer.android.com/topic/libraries/view-binding) feature on your Android project. This library show up in my head as an very good example on how the property delegation functionality from kotlin can help us.


-----

### Binding on Activity

> Yes, the ```viewBinding()``` method will bind the layout for you.

```Kotlin

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding : ActivityMainBinding by viewBinding()
}

```

### Inflating on Activity

> You can access the inflated view using the ```root``` property as usual

```Kotlin

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding<ActivityMainBinding>(ViewBindingMethod.INFLATE)
    
    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(binding.root)
    }
}

```



### Implementation from Fragment

> Yes, you don't need to call the ```setContentView()``` method anymore. 

```Kotlin

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding : ActivityMainBinding by viewBinding()
    
    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
     //setContentView(binding.root)
    }
}

```
