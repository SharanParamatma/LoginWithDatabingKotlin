package com.india.loginkotlinmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/*third step  design your viewModel*/
class LoginViewModel : ViewModel() {
   // properties
    var mobile = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    private var userMutableLiveData: MutableLiveData<User>? = null

    // a method which extend LiveData
    val user: LiveData<User>
        get() {
            if (userMutableLiveData == null) {
                userMutableLiveData = MutableLiveData()
            }
            return userMutableLiveData!!
        }


    // a method for button click
    fun onLoginClicked() {
        val user = User(mobile.value, password.value)
        userMutableLiveData?.value = user

    }

}