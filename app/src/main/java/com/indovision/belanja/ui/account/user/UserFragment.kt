package com.indovision.belanja.ui.account.user

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.indovision.belanja.R
import com.indovision.belanja.data.MenuEntity
import com.indovision.belanja.data.source.local.UserPreference
import com.indovision.belanja.data.source.remote.RemoteDataSource
import com.indovision.belanja.databinding.FragmentUserBinding
import com.indovision.belanja.ui.auth.AuthActivity
import com.indovision.belanja.ui.cart.CartActivity
import com.indovision.belanja.viewmodel.AccountViewModel
import com.indovision.belanja.viewmodel.ViewModelFactory

class UserFragment : Fragment() {
    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding as FragmentUserBinding
    private lateinit var viewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)

        val factory = ViewModelFactory.getInstance(RemoteDataSource())
        viewModel = ViewModelProvider(this, factory)[AccountViewModel::class.java]

        getData()
        setMenu()

        binding.btnLogout.setOnClickListener { logOut() }
        return binding.root
    }

    private fun setMenu() {
        val menuList = ArrayList<MenuEntity>()
        menuList.add(MenuEntity(name = "Profile"))
        menuList.add(MenuEntity(name = "Favorite"))
        menuList.add(MenuEntity(name = "Pesan"))
        menuList.add(MenuEntity(name = "Keranjang Belanja"))

        val adapter = MenuAdapter(menuList, object : MenuAdapter.ItemMenuClickListener{
            override fun onItemMenuClick(id: String) {
                when(id){
                    "1" -> Navigation.createNavigateOnClickListener(R.id.action_userFragment_to_profileFragment)
                    "2" -> Navigation.createNavigateOnClickListener(R.id.action_userFragment_to_favoriteFragment)
                    "3" -> Navigation.createNavigateOnClickListener(R.id.action_userFragment_to_favoriteFragment)
                    "4" -> startActivity(Intent(context, CartActivity::class.java))
                }
            }
        })
        with(binding){
            rvUserMenu.setHasFixedSize(true)
            rvUserMenu.layoutManager = LinearLayoutManager(context)
            rvUserMenu.adapter = adapter
        }
    }

    private fun logOut() {
        UserPreference(context as Context).clearAll()
        startActivity(Intent(context, AuthActivity::class.java))
    }

    private fun getData() {
        viewModel.getAccount(UserPreference(context as Context).getUserId())
            .observe(viewLifecycleOwner, {
                with(binding) {
                    userFullName.text =
                        resources.getString(R.string.fullNameUser, it.firstName, it.lastName)
                    userAddress.text = it.address
                }
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
