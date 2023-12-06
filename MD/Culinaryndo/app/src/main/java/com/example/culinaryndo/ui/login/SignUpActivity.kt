package com.example.culinaryndo.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.culinaryndo.R
import com.example.culinaryndo.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnSignup.setOnClickListener { singup() }
    }

    private fun singup() {
        val firstname = binding.edFirstname.text.toString()
        val lastname = binding.edLastname.text.toString()
        val username = binding.edUsername.text.toString()
        val email = binding.edEmail.text.toString()
        val password = binding.edPassword.text.toString()
        val password_verif = binding.edPasswordVerif.text.toString()

        when{
            firstname.isEmpty() -> {
                binding.edLayoutFirstname.error = getString(R.string.warning_firstname_empty)
            }
            firstname.length < 3 -> {
                binding.edLayoutFirstname.error = getString(R.string.warning_3_character)
            }
            username.isEmpty() -> {
                binding.edLayoutUsername.error = getString(R.string.warning_username_empty)
            }
            username.length < 5 -> {
                binding.edLayoutUsername.error = getString(R.string.warning_5_character)
            }
            email.isEmpty() -> {
                binding.edLayoutEmail.error = getString(R.string.warning_email_empty)
            }
            password.isEmpty() -> {
                binding.edLayoutPasswordVerif.error = getString(R.string.warning_password_empty)
            }
            !password.equals(password_verif) -> {
                binding.edLayoutPasswordVerif.error = getString(R.string.warning_password_verif)
            }
            else -> {
                //create account
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> finish()
        }
        return true
    }
}