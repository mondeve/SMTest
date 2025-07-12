package id.co.mondo.suitmediatest.data.network

import id.co.mondo.suitmediatest.data.response.UsersResponse
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): UsersResponse


}