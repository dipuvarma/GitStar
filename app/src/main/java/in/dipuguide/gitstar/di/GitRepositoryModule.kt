package `in`.dipuguide.gitstar.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import `in`.dipuguide.gitstar.data.repository.GitRepoImpl
import `in`.dipuguide.gitstar.domain.repository.GitRepo
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
abstract class GitRepositoryModule {

    @Provides
    @Binds
    abstract fun bindsGitRepo(gitRepoImpl: GitRepoImpl): GitRepo

}