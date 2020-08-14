package com.example.exercise_navigation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.exercise_navigation.R
import com.example.exercise_navigation.view_model.UserViewModel
import kotlinx.android.synthetic.main.fragment_confirmation.*


class ConfirmationFragment : Fragment() {
    val userViewModel : UserViewModel by activityViewModels<UserViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel.username.observe(viewLifecycleOwner, Observer { setUsernameReceiver(it) })
        userViewModel.accountNumber.observe(viewLifecycleOwner, Observer { setAccountNumberReceiver(it) })
        userViewModel.amountTransfer.observe(viewLifecycleOwner, Observer { setAmountReceiver(it) })
        userViewModel.bankname.observe(viewLifecycleOwner, Observer { setBankNameReceiver(it) })
    }
    fun setUsernameReceiver(username:String){
        text_username_receiver.text="Sent to ${username}"
    }
    fun setAccountNumberReceiver(accountNumber:String){
        text_account_number_receiver.text="${accountNumber}"
    }
    fun setAmountReceiver(amount:Int){
        text_amount_receiver.text = "Rp. ${amount}"
    }
    fun setBankNameReceiver(bankName:String){
        text_bank_name_receiver.text = "${bankName}"
    }

}