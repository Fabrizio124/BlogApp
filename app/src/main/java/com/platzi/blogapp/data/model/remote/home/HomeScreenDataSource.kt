package com.platzi.blogapp.data.model.remote.home

import com.google.firebase.firestore.FirebaseFirestore
import com.platzi.blogapp.core.Resource
import com.platzi.blogapp.data.model.Post
import kotlinx.coroutines.tasks.await

class HomeScreenDataSource {

    suspend fun getLatestPost(): Resource<List<Post>>{
       val postList = mutableListOf<Post>()
       val querySnapshot = FirebaseFirestore.getInstance().collection("posts").get().await()
        for(post in querySnapshot.documents) {
            post.toObject(Post::class.java)?.let { fbPost ->
                postList.add(fbPost)
            }
        }
        return Resource.Success(postList)
    }
}