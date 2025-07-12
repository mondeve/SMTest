package id.co.mondo.suitmediatest.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ViewModels @Inject constructor():  ViewModel(){

    var name by mutableStateOf("")
    var palindromeInput by mutableStateOf("")
    var isPalindromeResult by mutableStateOf<String?>(null)

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