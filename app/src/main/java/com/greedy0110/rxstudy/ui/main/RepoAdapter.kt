package com.greedy0110.rxstudy.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.greedy0110.rxstudy.R
import com.greedy0110.rxstudy.data.Repo

class RepoAdapter(
    private val context: Context,
    var data: List<Repo>
) : RecyclerView.Adapter<RepoAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_item_repo, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.run {
            val cur = data[position]
            txt_rv_item_repo_name.text = cur.repo_name
        }
    }

    inner class Holder(view: View): RecyclerView.ViewHolder(view) {
        val txt_rv_item_repo_name = view.findViewById<TextView>(R.id.txt_rv_item_repo_name)
    }
}