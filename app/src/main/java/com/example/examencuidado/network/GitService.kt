package com.example.examencuidado.network

import com.example.examencuidado.model.data.GitResponseUserItem
import com.example.examencuidado.utils.Constants.ACCESS_TOKEN
import com.example.examencuidado.utils.Constants.PATH_USER
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers


interface GitService {

    @GET(PATH_USER)
    @Headers("Authorization: token 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")
    suspend fun getResponseUser(): Response<ArrayList<GitResponseUserItem>>
}