package `in`.dipuguide.gitstar.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import `in`.dipuguide.gitstar.data.datasorce.remote.api.GitRepoApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val GIT_API_BASE_URL = "https://api.github.com/"

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun buildRetrofitApi(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(GIT_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideRetrofitApi(retrofit: Retrofit) {
        retrofit.create(GitRepoApiInterface::class.java)
    }
}