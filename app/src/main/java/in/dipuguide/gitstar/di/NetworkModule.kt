package `in`.dipuguide.gitstar.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import `in`.dipuguide.gitstar.data.datasorce.remote.api.GitRepoApiInterface
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun buildRetrofitApi(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(GIT_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideRetrofitApi(retrofit: Retrofit): GitRepoApiInterface {
      return  retrofit.create(GitRepoApiInterface::class.java)
    }
}

const val GIT_API_BASE_URL = "https://api.github.com/"
