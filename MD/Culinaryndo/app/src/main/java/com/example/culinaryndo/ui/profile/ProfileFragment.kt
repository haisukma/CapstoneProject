package com.example.culinaryndo.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.culinaryndo.R
import com.example.culinaryndo.ViewModelFactory
import com.example.culinaryndo.databinding.FragmentProfileBinding
import com.example.culinaryndo.ui.login.LoginActivity
import com.example.culinaryndo.ui.main.MainViewModel
import com.example.culinaryndo.ui.profile.setting.SettingActivity
import com.example.culinaryndo.ui.profile.term.TermsActivity

class ProfileFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentProfileBinding
    private val viewModel by viewModels<ProfileViewModel>{
        ViewModelFactory.getInstance(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnSetting.setOnClickListener(this@ProfileFragment)
            btnTerms.setOnClickListener(this@ProfileFragment)
            btnLogout.setOnClickListener(this@ProfileFragment)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_setting -> {
                startActivity(Intent(requireActivity(),SettingActivity::class.java))
            }
            R.id.btn_terms -> {
                startActivity(Intent(requireActivity(),TermsActivity::class.java))
            }
            R.id.btn_logout -> {
                viewModel.logout()
                startActivity(Intent(requireActivity(),LoginActivity::class.java))
                requireActivity().finish()
            }
        }
    }
}