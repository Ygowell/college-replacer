package com.halo.collegereplacer.ui.search

import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.halo.collegereplacer.Injection
import com.halo.collegereplacer.R
import com.halo.collegereplacer.databinding.ActivitySearchBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_search.*

/**
 * Created by James on 2019/3/16.
 * Desc:
 */
class RepoListActivity : AppCompatActivity() {

    private lateinit var repoViewModel: RepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bingding : ActivitySearchBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_search
        )

        repoViewModel = ViewModelProviders.of(
            this,
            Injection.providerRepoViewModelFactory(this)
        ).get(RepoViewModel::class.java)

        val layoutManager = LinearLayoutManager(this)
        rv_repo_list.layoutManager = layoutManager
        rv_repo_list.hasFixedSize()
        rv_repo_list.adapter = RepoListAdapter()
        rv_repo_list.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))

        bingding.repoViewModel = repoViewModel

        btn_search.setOnClickListener {
            repoViewModel.search()
        }
    }
}