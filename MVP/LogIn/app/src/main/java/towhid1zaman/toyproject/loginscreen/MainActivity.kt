package towhid1zaman.toyproject.loginscreen


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import towhid1zaman.toyproject.loginscreen.presenter.LoginPresenter
import towhid1zaman.toyproject.loginscreen.view.LoginView


class MainActivity : AppCompatActivity(), LoginView {

    private lateinit var presenter: LoginPresenter
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvMessage = findViewById(R.id.tvMessage)

        presenter = LoginPresenter(this)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            presenter.login(username, password)
        }
    }

    override fun onLoginSuccess(message: String) {
        tvMessage.text = message
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginError(message: String) {
        tvMessage.text = message
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}