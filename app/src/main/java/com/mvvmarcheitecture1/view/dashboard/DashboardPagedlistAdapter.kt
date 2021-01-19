package com.mvvmarcheitecture1.view.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mvvmarcheitecture1.R
import com.mvvmarcheitecture1.service.model.response.PhotoListResponse
import kotlinx.android.synthetic.main.item_photo.view.*

class DashboardPagedlistAdapter :
    PagingDataAdapter<PhotoListResponse, DashboardPagedlistAdapter.PagedListAdapter>(
        PhotoListComparator
    ) {
    class PagedListAdapter(view: View) : RecyclerView.ViewHolder(view) {
        var imageViewAvatarPhoto = view!!.imageViewAvatarPhoto
        var textViewUserNamePhoto = view!!.textViewUserNamePhoto
    }

    override fun onBindViewHolder(
        holder: DashboardPagedlistAdapter.PagedListAdapter,
        position: Int
    ) {
        holder.textViewUserNamePhoto.text = getItem(position)!!.support.text
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DashboardPagedlistAdapter.PagedListAdapter {
        return PagedListAdapter(
            LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        )


    }

    object PhotoListComparator : DiffUtil.ItemCallback<PhotoListResponse>() {
        override fun areItemsTheSame(
            oldItem: PhotoListResponse,
            newItem: PhotoListResponse
        ): Boolean {
            return oldItem == newItem

        }

        override fun areContentsTheSame(
            oldItem: PhotoListResponse,
            newItem: PhotoListResponse
        ): Boolean {
            return oldItem.equals(newItem)
        }

    }

}