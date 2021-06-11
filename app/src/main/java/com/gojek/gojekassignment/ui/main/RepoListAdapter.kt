package com.gojek.gojekassignment.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.gojek.gojekassignment.core.models.Repository
import com.gojek.gojekassignment.databinding.ItemRepoBinding

/**
 * Created by LaatonWalaBhoot on 11/06/21.
 */
class RepoListAdapter(): ListAdapter<Repository, RepoViewHolder>(ItemDiffItemCallback()) {

    private val repositories: MutableList<Repository> get() = currentList

    class ItemDiffItemCallback : DiffUtil.ItemCallback<Repository>() {

        override fun areItemsTheSame(old: Repository, new: Repository): Boolean {
            return old.url == new.url
        }

        override fun areContentsTheSame(old: Repository, new: Repository): Boolean {

            return false
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val binding = ItemRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepoViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        with(repositories[position]) {
            holder.bindRepository(this)
        }
    }
}