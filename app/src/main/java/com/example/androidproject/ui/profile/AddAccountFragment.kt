package com.example.androidproject.ui.profile

import User
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.lifecycle.ViewModelProvider
import com.example.androidproject.Data.AccountRepository
import com.example.androidproject.Data.UserRepository
import com.example.androidproject.R
import com.example.androidproject.ViewModels.AccountViewModel
import com.example.androidproject.ViewModels.UserViewModel
import com.example.androidproject.entities.Account
import com.example.androidproject.entities.Service


class AddAccountFragment : Fragment() {

    private val userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
    private  var loggedInUser: User =  User(0,"test")

    init {
//        val usersList  = userViewModel.allUsers.value
//
//        if(usersList != null){loggedInUser = usersList.get(0) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add_account, container, false)

        val addAccountButton: Button = view.findViewById(R.id.button_add_account)

        val accountViewModel = ViewModelProvider(this).get(AccountViewModel::class.java)

        addAccountButton.setOnClickListener{
            var strings : ArrayList<String> =  ArrayList()
            val email = view.findViewById<EditText>(R.id.input_email_Account).toString()
            val password = view.findViewById<EditText>(R.id.input_password_account).toString()
            var service = view.findViewById<RadioGroup>(R.id.radioGroupTypeAccount).checkedRadioButtonId.toString()
            strings.add(email)
            strings.add(password)
            if (!checkIfEmpty(strings)){
                if (service.equals("radio_google")){
                    accountViewModel.addAccount(Account(Service.Google,email,loggedInUser.userId))
                }
            }

        }

        return view
    }

    fun checkIfEmpty(strings:ArrayList<String>):Boolean {
        for (string in strings){
            if (string.isBlank()){
                return true
            }
        }
        return false
    }

}