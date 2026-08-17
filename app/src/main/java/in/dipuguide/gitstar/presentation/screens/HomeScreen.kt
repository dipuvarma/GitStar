package `in`.dipuguide.gitstar.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun HomeScreen(
     homeViewModel: HomeViewModel = hiltViewModel(),
) {

    LaunchedEffect(true) {
        homeViewModel.loadData()
    }

}