package com.example.culinaryndo.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.culinaryndo.R
import com.example.culinaryndo.ViewModelFactory
import com.example.culinaryndo.databinding.ActivityMainBinding
import com.example.culinaryndo.ui.scan.ScanActivity

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>{
        ViewModelFactory.getInstance(this)
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            navView.background = null
            navView.menu.getItem(2).isEnabled = false

            btnScan.setOnClickListener{
                startActivity(Intent(this@MainActivity,ScanActivity::class.java))
            }
        }

//        viewModel.getSession().observe(this){ session ->
//            if(session.isLogin != false){
//                startActivity(Intent(this, LoginActivity::class.java))
//                finish()
//            }
//        }

        setBottomNavigationView()
    }

    fun setBottomNavigationView(){
        setSupportActionBar(binding.bottomAppBar)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.homeFragment,
            R.id.bookmarkFragment,
            R.id.none,
            R.id.historyFragment,
            R.id.profileFragment
        ).build()

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}