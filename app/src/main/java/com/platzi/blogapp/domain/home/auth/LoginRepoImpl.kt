package com.platzi.blogapp.domain.home.auth

import com.google.firebase.auth.FirebaseUser
import com.platzi.blogapp.data.model.remote.home.auth.LoginDataSource

class LoginRepoImpl(private val dataSource:LoginDataSource): LoginRepo {

    //El signo "=" es lo mismo que hacer un return
    override suspend fun signIn(email: String, password: String): FirebaseUser? = dataSource.signIn(email, password)
}