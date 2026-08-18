package `in`.dipuguide.gitstar.presentation.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import `in`.dipuguide.gitstar.domain.repository.GitRepo
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val gitRepo: GitRepo,
) : ViewModel() {

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            gitRepo.fetchGitRepo(
                "stars"
            ).onSuccess { items ->
                Log.d("TAG", "$items")
            }.onFailure { e ->
                Log.d("TAG", "FAILED: $e")
            }
        }
    }
}