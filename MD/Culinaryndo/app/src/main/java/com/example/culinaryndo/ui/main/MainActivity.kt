package com.example.culinaryndo.ui.main

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
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
import android.Manifest
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import com.example.culinaryndo.component.LoadingDialog
import com.example.culinaryndo.data.Result
import com.example.culinaryndo.ui.home.DetailFoodActivity
import com.example.culinaryndo.ui.scan.ScanActivity.Companion.CAMERAX_RESULT
import com.example.culinaryndo.utils.uriToFile

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>{
        ViewModelFactory.getInstance(this)
    }
    private lateinit var binding: ActivityMainBinding

    private var currentImageUri: Uri? = null

    private lateinit var loadingDialog: LoadingDialog

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                Toast.makeText(this, "Permission request granted", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Permission request denied", Toast.LENGTH_LONG).show()
            }
        }

    private fun allPermissionsGranted() =
        ContextCompat.checkSelfPermission(
            this,
            REQUIRED_PERMISSION
        ) == PackageManager.PERMISSION_GRANTED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadingDialog = LoadingDialog(this@MainActivity)

        binding.apply {
            navView.background = null
            navView.menu.getItem(2).isEnabled = false

            btnScan.setOnClickListener{
               startCameraX()
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

    private fun startCameraX() {
        if (!allPermissionsGranted()) {
            requestPermissionLauncher.launch(REQUIRED_PERMISSION)
        }else{
            launcherIntentCameraX.launch(Intent(this@MainActivity,ScanActivity::class.java))
        }
    }

    private val launcherIntentCameraX = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == CAMERAX_RESULT) {
            currentImageUri = it.data?.getStringExtra(ScanActivity.EXTRA_CAMERAX_IMAGE)?.toUri()

            currentImageUri?.let { uri ->
                val imageFile = uriToFile(uri,this)
                Log.d("Image File: ","showImage: ${imageFile.path}")

                loadingDialog.startLoadingDialog()

//                viewModel.analyzeImage(imageFile).observe(this@MainActivity){ result ->
//                    if (result != null){
//                        when(result){
//                            is Result.Loading -> {
//                                loadingDialog.startLoadingDialog()
//                            }
//                            is Result.Success -> {
//                                Toast.makeText(this,result.data.message,Toast.LENGTH_SHORT).show()
//                                val intent = Intent(this, DetailFoodActivity::class.java)
//                                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
//                                startActivity(intent)
//                            }
//                            is Result.Error -> {
//                                loadingDialog.dismisDialog()
//                                Toast.makeText(this,result.error,Toast.LENGTH_SHORT).show()
//                            }
//                        }
//                    }
//                }
            }
        }
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

    companion object {
        private const val REQUIRED_PERMISSION = Manifest.permission.CAMERA
    }
}