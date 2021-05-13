package com.indovision.belanja.ui.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.gms.auth.api.signin.*
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.indovision.belanja.R
import com.indovision.belanja.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding as FragmentLoginBinding
    private lateinit var mGoogleSignInClient: GoogleSignInClient

    companion object {
        const val RC_SIGN_IN = 100
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail().build()
        mGoogleSignInClient = GoogleSignIn.getClient(context as Context, gso)
    }

    override fun onStart() {
        super.onStart()
        val account = GoogleSignIn.getLastSignedInAccount(context)
        if (account != null)
            successLogin(account)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            signInWithGoogle.setOnClickListener { signInGoogle() }
        }
    }

    private fun signInGoogle() {
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInGoogleAccountFromIntent(task)
        }
    }

    private fun handleSignInGoogleAccountFromIntent(task: Task<GoogleSignInAccount>) {
        try {
            val account = task.getResult(ApiException::class.java) as GoogleSignInAccount
            successLogin(account)
        } catch (e: ApiException) {
            Log.d(
                LoginFragment::class.java.simpleName,
                GoogleSignInStatusCodes.getStatusCodeString(e.statusCode)
            )
            Toast.makeText(context, getString(R.string.sign_in_failed), Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun successLogin(account: GoogleSignInAccount) {
        Log.d(
            LoginFragment::class.java.simpleName,
            GoogleSignInStatusCodes.getStatusCodeString(GoogleSignInStatusCodes.SUCCESS)
        )
        Log.d(
            LoginFragment::class.java.simpleName,
            account.email.toString()
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
