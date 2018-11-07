package com.hubtel.galaconf2018.component

import com.billkainkoom.ogya.quicklist.BaseComponent
import com.billkainkoom.ogya.quicklist.Listable
import com.billkainkoom.ogya.quicklist.ListableType
import com.hubtel.galaconf2018.databinding.ComponentGreetingBinding


data class Greeting(var name: String, var image: Int = 0) : Listable {

    override fun getListableType(): ListableType? {
        return ListableTypes.ComponentGreeting
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
        binding.image.setImageResource(listable.image)
    }

}
