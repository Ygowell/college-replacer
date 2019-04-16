package com.halo.collegereplacer.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.halo.collegereplacer.R
import com.halo.collegereplacer.databinding.RepoListItemBinding
import com.halo.collegereplacer.model.Repo

/**
 * Created by James on 2019/3/16.
 * Desc:
 */
class RepoListAdapter : RecyclerView.Adapter<RepoListAdapter.RepoItemViewHolder>() {

    private var repoList: List<Repo> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoItemViewHolder {
        return RepoItemViewHolder(parent)
    }

    override fun getItemCount() = repoList.size

    override fun onBindViewHolder(holder: RepoItemViewHolder, position: Int) {
        holder.bind(repoList[position])
    }

    fun update(repos: List<Repo>) {
        this.repoList = repos
    }

    class RepoItemViewHolder(
        private val parent: ViewGroup,
        private val binding: RepoListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.repo_list_item,
            parent,
            false
        )
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(repo: Repo) {
            binding.repo = repo
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("items")
        fun RecyclerView.bindItems(repos: List<Repo>) {
            val adapter = adapter as RepoListAdapter
            adapter.update(repos)
        }
    }
}