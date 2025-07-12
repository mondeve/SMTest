package id.co.mondo.suitmediatest.data.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {

    private val BASE_URL = "https://reqres.in/api/"
    private val API_KEY = "reqres-free-v1"

    private val apiKeyInterceptor = Interceptor { chain ->
        val originalRequest = chain.request()
        val requestWithApiKey = originalRequest.newBuilder()
            .addHeader("x-api-key", API_KEY)
            .build()
        chain.proceed(requestWithApiKey)
    }

    fun getApiService(): ApiService {
        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(ApiService::class.java)
    }



}