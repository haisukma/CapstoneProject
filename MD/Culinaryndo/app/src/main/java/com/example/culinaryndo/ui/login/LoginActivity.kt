package com.example.culinaryndo.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import androidx.activity.viewModels
import com.example.culinaryndo.R
import com.example.culinaryndo.ViewModelFactory
import com.example.culinaryndo.data.model.LoginResult
import com.example.culinaryndo.databinding.ActivityLoginBinding
import com.example.culinaryndo.ui.main.MainActivity
import com.example.culinaryndo.ui.main.MainViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance (this@LoginActivity)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener { login() }
    }

    private fun login() {
        val email = binding.edEmail.text.toString()
        val password = binding.edPassword.text.toString()

        when {
            email.isEmpty() -> {
                binding.signupEmailInputLayout.error = "Email tidak boleh kosong!"
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                binding.signupEmailInputLayout.error = "Email tidak Valid"
            }
            password.isEmpty() -> {
                binding.signupPasswordtextInputLayout.error = "Password tidak boleh kosong!"
            }
            else -> {
                viewModel.saveSession(LoginResult("fasih","1","12345678",true))
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}