package com.example.exercise_navigation.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel(){
    val username : MutableLiveData<String> = MutableLiveData("")
    val accountNumber : MutableLiveData<String> = MutableLiveData("")
    val bankname : MutableLiveData<String> = MutableLiveData("")
    val amountTransfer : MutableLiveData<Int> = MutableLiveData(0)

    fun toInputRecipient(name: String){

    }
    fun toInputAmount(inBankName:String, inAccountNumber:String, inUsername:String){
        username.value=inUsername
        accountNumber.value=inAccountNumber
        bankname.value=inBankName
    }
    fun toConfirmation(inAmountTransfer:Int){
        amountTransfer.value=inAmountTransfer
    }
}