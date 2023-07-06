package com.jaax.dogedex.auth.ui.login

import android.content.Context
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jaax.dogedex.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private var loginFragmentActions: LoginFragmentActions? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            loginFragmentActions = context as LoginFragmentActions
        } catch (e: java.lang.ClassCastException) {
            Log.e("ERROR", e.message.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.btnRegister.setOnClickListener {
            loginFragmentActions?.onRegisterButtonClick()
        }
        return binding.root
    }

    interface LoginFragmentActions {
        fun onRegisterButtonClick();
    }
}