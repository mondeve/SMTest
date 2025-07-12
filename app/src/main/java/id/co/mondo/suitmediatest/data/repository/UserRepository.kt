package id.co.mondo.suitmediatest.data.repository

import id.co.mondo.suitmediatest.data.network.ApiService
import id.co.mondo.suitmediatest.data.response.UserItem
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getUsersList(): List<UserItem> {
        return apiService.getUsers().data
    }


}