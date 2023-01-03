package com.example.standard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.standard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(binding.containterMain.id, HomeFragment())
            .commitAllowingStateLoss()

        binding.bottomNavMain.run {
            setOnItemSelectedListener {
                when(it.itemId) {
                    R.id.menu_home -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.containterMain.id, HomeFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_setting -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.containterMain.id, SettingFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_more -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.containterMain.id, MoreFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }
            selectedItemId = R.id.menu_home
        }
    }
}