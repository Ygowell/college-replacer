package com.halo.collegereplacer.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.halo.collegereplacer.R
import androidx.recyclerview.widget.RecyclerView
import com.halo.collegereplacer.databinding.UserListItemBinding
import com.halo.collegereplacer.db.User
import com.halo.collegereplacer.model.Repo

class UserListAdapter: RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    private var userList: List<User> = emptyList()

    override fun getItemCount() = userList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(parent)

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    fun update(userList: List<User>) {
        this.userList = userList
        notifyDataSetChanged()
    }

    inner class UserViewHolder(
        private val itemView: ViewGroup,
        private val binding: UserListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(itemView.context),
            R.layout.user_list_item,
            itemView,
            false
        )) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.user = user
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("items")
        fun RecyclerView.bindItems(users: List<User>) {
            val adapter = adapter as UserListAdapter
            adapter.update(users)
        }
    }
}