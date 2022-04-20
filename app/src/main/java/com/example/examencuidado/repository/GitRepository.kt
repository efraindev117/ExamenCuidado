package com.example.examencuidado.repository

import com.example.examencuidado.network.GitService
import javax.inject.Inject

class GitRepository @Inject constructor(private val gitService: GitService ) {

    suspend fun getDataResponse() = gitService.getResponseUser()
}