package com.indovision.belanja.ui.account.profile

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.indovision.belanja.R
import com.indovision.belanja.data.source.local.UserPreference
import com.indovision.belanja.data.source.remote.RemoteDataSource
import com.indovision.belanja.databinding.FragmentProfileBinding
import com.indovision.belanja.viewmodel.ProfileViewModel
import com.indovision.belanja.viewmodel.ViewModelFactory

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding as FragmentProfileBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        val factory = ViewModelFactory.getInstance(RemoteDataSource())
        viewModel = ViewModelProvider(this, factory)[ProfileViewModel::class.java]

        getData()
        return binding.root
    }

    private fun getData() {
        viewModel.getProfile(UserPreference(context as Context).getUserId())
            .observe(viewLifecycleOwner, {
                with(binding) {
                    inputFullName.setText(resources.getString(R.string.fullNameUser, it.firstName, it.lastName))
                    inputEmail.setText(it.email)
                    inputAddress.setText(it.email)

                    if (it.gender.equals("male",true)) rbMale.isChecked = true
                    else rbFemale.isChecked = true

                    Glide.with(context as Context).apply { RequestOptions.overrideOf(150, 150) }
                        .load(it.imagePath).into(userImage)
                }
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
