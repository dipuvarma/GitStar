package `in`.dipuguide.gitstar.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import `in`.dipuguide.gitstar.data.repository.GitRepoImpl
import `in`.dipuguide.gitstar.domain.repository.GitRepo
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsGitRepo(gitRepoImpl: GitRepoImpl): GitRepo

}