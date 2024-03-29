package com.formation.instagram.adapters

import android.graphics.BlurMaskFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.formation.instagram.R
import com.formation.instagram.models.PostModel
import com.formation.instagram.utils.GlideBlurTransformation
import com.google.android.material.imageview.ShapeableImageView

class PostAdapter(val posts : List<PostModel>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val cardView = itemView.findViewById<CardView>(R.id.item_card_view)
        val avatar = itemView.findViewById<ShapeableImageView>(R.id.item_avatar)
        val nickname = itemView.findViewById<TextView>(R.id.item_nickname)
        val imagePostBlur = itemView.findViewById<ImageView>(R.id.item_photo_post_blur)
        val imagePost = itemView.findViewById<ImageView>(R.id.item_photo_post)
        val imageLike = itemView.findViewById<ImageView>(R.id.item_image_like)
        val nbrLike = itemView.findViewById<TextView>(R.id.item_nbr_like)
        val description = itemView.findViewById<TextView>(R.id.item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        val context = holder.avatar.context

        holder.avatar.setImageResource(R.drawable.avatar)
        holder.description.text = post.description
        holder.imageLike.setImageResource(R.drawable.heart_void)
        holder.imagePost.setImageResource(R.drawable.femme_montagne)
        //holder.imagePostBlur.setImageResource(R.drawable.femme_montagne)
        holder.nbrLike.text = "${post.users?.size} like(s)"
        holder.nickname.text = post.user?.nickname

        Glide.with(context)
            .load(R.drawable.femme_montagne)
            .transform(GlideBlurTransformation(context))
            .into(holder.imagePostBlur)

    }

    override fun getItemCount(): Int {
        return posts.size
    }
}