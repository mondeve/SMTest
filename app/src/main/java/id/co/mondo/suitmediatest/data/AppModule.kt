package id.co.mondo.suitmediatest.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.co.mondo.suitmediatest.data.network.ApiConfig
import id.co.mondo.suitmediatest.data.network.ApiService
import id.co.mondo.suitmediatest.data.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return ApiConfig().getApiService()
    }

    @Provides
    @Singleton
    fun provideUserRepository(apiService: ApiService): UserRepository {
        return UserRepository(apiService)
    }
}