package id.co.mondo.suitmediatest.data.network

import id.co.mondo.suitmediatest.data.response.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int
    ): UsersResponse


}