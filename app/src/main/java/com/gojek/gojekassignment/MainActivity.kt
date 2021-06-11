package com.gojek.gojekassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gojek.gojekassignment.databinding.MainActivityBinding
import com.gojek.gojekassignment.ui.main.MainFragment
import com.gojek.gojekassignment.ui.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }
}