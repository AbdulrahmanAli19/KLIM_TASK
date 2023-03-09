package abdulrahman.ali19.klim.di

import abdulrahman.ali19.klim.data.remote.api.Api
import abdulrahman.ali19.klim.data.remote.api.ApiService
import abdulrahman.ali19.klim.data.repo.HomeRepo
import abdulrahman.ali19.klim.data.repo.HomeRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): Api = ApiService.getService()

    @Provides
    @Singleton
    fun provideHomeRepo(
        api: Api
    ): HomeRepo = HomeRepoImpl(api)

}