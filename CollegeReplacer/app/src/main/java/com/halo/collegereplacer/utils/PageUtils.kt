package com.halo.collegereplacer.utils

import android.content.Context
import android.content.Intent
import com.halo.collegereplacer.ui.search.RepoListActivity

/**
 * Created by James on 2019/3/16.
 * Desc:
 */
object PageUtils {

    fun openRepoList(context: Context) {
        val intent = Intent(context, RepoListActivity::class.java)
        context.startActivity(intent)
    }
}