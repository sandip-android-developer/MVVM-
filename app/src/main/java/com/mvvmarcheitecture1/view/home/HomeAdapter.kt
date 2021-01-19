package com.mvvmarcheitecture1.view.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.mvvmarcheitecture1.R
import com.mvvmarcheitecture1.databinding.ItemLayoutBinding
import com.mvvmarcheitecture1.service.model.response.User
import com.mvvmarcheitecture1.view.base.BaseActivity


class HomeAdapter(
    var context: Context,
    val users: ArrayList<User>
) : RecyclerView.Adapter<HomeAdapter.DataViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_layout,
            parent,
            false
        )
    )

    override fun getItemCount(): Int {
        return users.size

    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        //   holder.bind(users.get(position))
        holder.binding.homeViewModel = users.get(position)


        /*holder.itemView.setOnClickListener {
            context.lifecycleScope.launch {
                context.settingsManager.setUSer(users.get(position))
            }

            observeUiPreferences()
        }*/

    }
    /* open fun observeUiPreferences() {
        context.settingsManager.uiModeFlow.asLiveData().observe(context) { uiMode ->
             println("USerData---"+uiMode)
         }

     }*/

    class DataViewHolder(var binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        /*fun bind(user: User) {
            itemView.textViewUserName.text = user.name
            itemView.textViewUserEmail.text = user.email
            Glide.with(itemView.imageViewAvatar.context)
                .load(user.avatar)
                .into(itemView.imageViewAvatar)
        }*/
    }

    fun addUsers(users: List<User>) {
        this.users.apply {
            clear()
            addAll(users)
        }

    }


    inner class AllOnClickHandle {
        open fun onClick() {
            println("OnClick---")
            var navController =
                Navigation.findNavController(context as BaseActivity, R.id.nav_host_fragment)

            navController.navigate(
                R.id.action_navigation_home_to_blankFragment
            )
        }
    }


}