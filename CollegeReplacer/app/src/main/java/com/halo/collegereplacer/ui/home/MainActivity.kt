package com.halo.collegereplacer.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.room.Room
import com.halo.collegereplacer.R
import com.halo.collegereplacer.databinding.ActivityMainBinding
import com.halo.collegereplacer.db.CRDatabase
import com.halo.collegereplacer.ui.home.viewmodel.UserViewModel
import com.halo.collegereplacer.ui.home.viewmodel.UserViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        val userDao = Room.databaseBuilder(
            this,
            CRDatabase::class.java, "college_replace.db"
        ).build().userDao()

        userViewModel = ViewModelProviders
            .of(this, UserViewModelFactory(userDao))
            .get(UserViewModel::class.java)


        binding.userViewModel = userViewModel
        // Don't forget set lifecycleOwner(类似添加Observable）
        binding.lifecycleOwner = this
    }
}
