package com.halo.collegereplacer.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.halo.collegereplacer.R
import com.halo.collegereplacer.Injection
import com.halo.collegereplacer.databinding.ActivityMainBinding
import com.halo.collegereplacer.ui.home.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        userViewModel = ViewModelProviders
            .of(this, Injection.providerUserViewModelFactory(this))
            .get(UserViewModel::class.java)

        // Don't forget set lifecycleOwner(类似添加Observable）
        binding.lifecycleOwner = this

        val layoutManager = LinearLayoutManager(this)

        rv_user_list.layoutManager = layoutManager
        rv_user_list.hasFixedSize()
        rv_user_list.adapter = UserListAdapter()
        rv_user_list.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))

        binding.userViewModel = userViewModel
    }
}
