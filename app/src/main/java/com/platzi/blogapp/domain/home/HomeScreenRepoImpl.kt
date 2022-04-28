package com.platzi.blogapp.domain.home

import com.platzi.blogapp.core.Resource
import com.platzi.blogapp.data.model.Post
import com.platzi.blogapp.data.model.remote.home.HomeScreenDataSource

class HomeScreenRepoImpl(private val dataSource: HomeScreenDataSource): HomeScreenRepo {

    override suspend fun getLatestPost(): Resource<List<Post>> = dataSource.getLatestPost()
}