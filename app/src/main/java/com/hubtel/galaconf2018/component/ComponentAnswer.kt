package com.hubtel.galaconf2018.component

import com.billkainkoom.ogya.quicklist.BaseComponent
import com.billkainkoom.ogya.quicklist.Listable
import com.billkainkoom.ogya.quicklist.ListableType
import com.hubtel.galaconf2018.R
import com.hubtel.galaconf2018.databinding.ComponentAnswerBinding
import com.hubtel.galaconf2018.databinding.ComponentGreetingBinding


data class Answer(var name: String, var subtitle: String, var image: Int, var extraImage: Int) : Listable {

    override fun getListableType(): ListableType? {
        return ListableTypes.ComponentAnswer
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
        binding.subtitle.text = listable.subtitle
        binding.image.setImageResource(listable.image)
        binding.extraImage.setImageResource(listable.extraImage)

    }
}

