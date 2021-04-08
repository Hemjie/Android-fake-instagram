package com.formation.instagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.formation.instagram.adapters.PostAdapter
import com.formation.instagram.models.PostModel
import com.formation.instagram.models.UserModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class PostListActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var posts: MutableList<PostModel>

    lateinit var adapter: PostAdapter

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_list)

        bottomNavigationViewAction()

        fillPostList()

        adapter = PostAdapter(posts)
        val rv = findViewById<RecyclerView>(R.id.recycler_view)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
    }

    override fun onClick(v: View?) {
    }

    private fun bottomNavigationViewAction(){
        bottomNavigationView = findViewById(R.id.bottom_navigation_view)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.action_home -> {
                    true
                }
                R.id.action_user -> {
                    val intent = Intent(this, UserActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    private fun fillPostList() {
        posts = mutableListOf()

        posts.add(
            PostModel(1L, UserModel("marjo", null), null, listOf("sam", "toto", "titi"), "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Asperiores, aspernatur, culpa eaque ex id maiores minus nobis odio pariatur quaerat quam quasi qui quia, quidem quis quo sed sint voluptate.")
        )

        posts.add(
            PostModel(1L, UserModel("lela", null), null, listOf("hemjie", "toto", "titi", "sam", "steven", "tata", "cannelle"), "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Asperiores, aspernatur, culpa eaque ex id maiores minus nobis odio pariatur quaerat quam quasi qui quia, quidem quis quo sed sint voluptate.")
        )
    }
}