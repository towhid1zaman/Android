package towhid1zaman.toyproject.loginscreen.view

interface LoginView {
    fun onLoginSuccess(message: String)
    fun onLoginError(message: String)
}