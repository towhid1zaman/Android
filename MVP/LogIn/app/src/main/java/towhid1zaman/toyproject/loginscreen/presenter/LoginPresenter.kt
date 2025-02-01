package towhid1zaman.toyproject.loginscreen.presenter

import towhid1zaman.toyproject.loginscreen.model.LoginModel
import towhid1zaman.toyproject.loginscreen.model.User
import towhid1zaman.toyproject.loginscreen.view.LoginView

class LoginPresenter(private val view: LoginView) {

    private val loginModel = LoginModel()

    fun login(username: String, password: String) {
        val user = User(username, password)
        if (loginModel.isValidUser(user)) {
            view.onLoginSuccess("Login Successful!")
        } else {
            view.onLoginError("Invalid Credentials!")
        }
    }
}