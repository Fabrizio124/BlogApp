package com.platzi.blogapp.domain.home

import com.platzi.blogapp.core.Resource
import com.platzi.blogapp.data.model.Post

interface HomeScreenRepo {
    suspend fun getLatestPost(): Resource<List<Post>>
}