package com.example.edwfrefref

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.edwfrefref.network.MarsProperty
import com.example.edwfrefref.overview.Status

@BindingAdapter("photoUrl")
fun bind(view: ImageView, url: String?) {

    url?.let {
        val imgUri = url.toUri().buildUpon().scheme("https").build()
        Glide.with(view.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .error(R.drawable.ic_broken_image)
                    .placeholder(R.drawable.loading_animation)
            )
            .into(view)
    }
}


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MarsProperty>?) {
    val adapter = recyclerView.adapter as recycler_grid_adapter
    adapter.submitList(data)
}


@BindingAdapter("ApiStatus")
fun apiStatus(view: ImageView, status: Status?) {

    when (status) {
        Status.LOADING -> {
            view.visibility = View.VISIBLE
            view.setImageResource(R.drawable.loading_animation)
        }
        Status.ERROR -> {
            view.visibility=View.VISIBLE
            view.setImageResource(R.drawable.ic_connection_error)
        }
        Status.DONE -> {
            view.visibility=View.GONE
        }
        else ->{}
    }
}


