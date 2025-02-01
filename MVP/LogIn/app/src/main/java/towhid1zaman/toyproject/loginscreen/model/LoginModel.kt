package towhid1zaman.toyproject.loginscreen.model

class LoginModel {
    fun isValidUser(user: User): Boolean {
        return user.userName == "admin" && user.password =="1234"
    }
}