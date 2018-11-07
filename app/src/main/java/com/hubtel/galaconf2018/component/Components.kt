package com.hubtel.galaconf2018.component

import com.billkainkoom.ogya.quicklist.BaseComponent
import com.billkainkoom.ogya.quicklist.Listable
import com.billkainkoom.ogya.quicklist.ListableType
import com.hubtel.galaconf2018.R
import com.hubtel.galaconf2018.databinding.ComponentAnswerBinding
import com.hubtel.galaconf2018.databinding.ComponentGreetingBinding


data class Greeting(var name: String) : Listable {

    override fun getListableType(): ListableType? {
        return ListableTypes.ComponentGreeting
    }

}

data class Answer(var name: String) : Listable {

    override fun getListableType(): ListableType? {
        return ListableTypes.ComponentAnswer
    }

}


//greeting
object ComponentGreeting : BaseComponent<ComponentGreetingBinding, Greeting>() {

    override fun listableType(): ListableType {
        return ListableTypes.ComponentGreeting
    }

    override fun render(binding: ComponentGreetingBinding, listable: Greeting) {
        //customization
        binding.title.text = listable.name
    }

}


//response
object ComponentAnswer : BaseComponent<ComponentAnswerBinding, Answer>() {

    override fun listableType(): ListableType {
        return ListableTypes.ComponentGreeting
    }

    override fun render(binding: ComponentAnswerBinding, listable: Answer) {
        //customization
        binding.title.text = listable.name
    }

    fun render(binding: ComponentAnswerBinding, listable: Answer,callBack:()->Unit) {

    }

}