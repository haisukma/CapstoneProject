package com.example.culinaryndo.ui.profile.term

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.culinaryndo.R
import com.example.culinaryndo.databinding.ActivityTermsBinding

class TermsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTermsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.webView.loadUrl("https://app.websitepolicies.com/policies/view/jpxixchv")
        binding.webView.settings.javaScriptEnabled = true
    }
}