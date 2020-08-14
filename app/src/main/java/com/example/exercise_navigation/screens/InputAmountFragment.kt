package com.example.exercise_navigation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.exercise_navigation.R
import com.example.exercise_navigation.view_model.UserViewModel
import kotlinx.android.synthetic.main.fragment_input_amount.*


class InputAmountFragment : Fragment(),View.OnClickListener {
    lateinit var navController: NavController
    val userViewModel : UserViewModel by activityViewModels<UserViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)
        button_send_amount.setOnClickListener(this)
        userViewModel.username.observe(viewLifecycleOwner, Observer { setTextReceiver(it) })
    }

    fun setTextReceiver(username: String){
        text_receiver.text="To : ${username}"
    }


    override fun onClick(v: View?) {
        when(v){
            button_send_amount ->{
                val amountTransfer = amount_transfer.text.toString().toInt()
                userViewModel.toConfirmation(amountTransfer)
                navController.navigate(R.id.action_inputAmountFragment_to_confirmationFragment)
            }
        }
    }

}