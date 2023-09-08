package com.jaax.dogedex.auth

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jaax.dogedex.R
import com.jaax.dogedex.auth.ui.login.LoginFragment
import com.jaax.dogedex.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    private lateinit var signUpFragmentActions: SignUpFragmentActions

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        signUpFragmentActions = try {
            context as SignUpFragmentActions
        } catch(e: ClassCastException) {
            throw java.lang.ClassCastException("$context error ${e.message!!}")
        }
    }

    private fun setupSignUpButton() {
        binding.btnRegister.setOnClickListener {
            validateFields()
        }
    }

    private fun validateFields() {
        binding.etUsername.error = ""
        binding.etPassword.error = ""

        val email = binding.etUsername.text.toString()
        if(!isValidEmail(email)) {
            binding.etUsername.error = "Email no válido"
            return
        }

        val password = binding.etPassword.text.toString()
        if(password.isEmpty()) {
            binding.etPassword.error = "Contraseña inválida"
            return
        }

        val passwordConfirmation = binding.etPasswordConfirm.text.toString()
        if(passwordConfirmation != password) {
            binding.etPassword.error = "Las contraseñas son distintas"
            return
        }

        signUpFragmentActions.onSignUpFieldsValidated(email, password, passwordConfirmation)
    }

    private fun isValidEmail(email: String?): Boolean {
        return !email.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    interface SignUpFragmentActions {
        fun onSignUpFieldsValidated(email: String, password: String, passwordConfirmation: String)
    }
}