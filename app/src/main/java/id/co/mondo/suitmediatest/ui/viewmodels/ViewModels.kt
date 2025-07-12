package id.co.mondo.suitmediatest.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.co.mondo.suitmediatest.data.repository.UserRepository
import id.co.mondo.suitmediatest.data.response.UserItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ViewModels @Inject constructor(
    private val repository: UserRepository
):  ViewModel(){

    var name by mutableStateOf("")
    var nameUser by mutableStateOf("")
    var palindromeInput by mutableStateOf("")
    var isPalindromeResult by mutableStateOf<String?>(null)

    var users by mutableStateOf<List<UserItem>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    private var currentPage = 1

    var isRefreshing by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)

    fun fetchUsers() {
        viewModelScope.launch {
            if (!isRefreshing) isLoading = true
            isRefreshing = true

            try {
                delay(2000L)
                isLoading = true
                val response = repository.getUsersList(currentPage)
                currentPage = if (currentPage == 1) 2 else 1
                users = response
                Log.d("API_SUCCESS", "Jumlah user: ${response.size}")
                Log.d("API_SUCCESS", "Data user: $response")
            } catch (e: Exception) {
                Log.e("API_ERROR", "Gagal mengambil data: ${e.message}")
                errorMessage = e.message ?: "Terjadi keslahan"
            } finally {
                isLoading = false
                isRefreshing = false
            }
        }
    }

    fun isNameValid(): Boolean = name.isNotBlank()

    fun checkPalindrome() {
        val cleaned = palindromeInput.replace("\\s".toRegex(), "").lowercase()

        isPalindromeResult = when {
            palindromeInput.isBlank() -> {
                "Please enter a word"
            }
            cleaned == cleaned.reversed() -> {
                "is Palindrome"
            }
            else -> {
                "not Palindrome"
            }
        }
    }
}