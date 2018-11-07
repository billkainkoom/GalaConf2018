package com.hubtel.galaconf2018.component

import android.content.Context
import android.os.Handler

import com.billkainkoom.ogya.quickdialog.QuickDialog
import com.billkainkoom.ogya.quickdialog.QuickDialogType
import com.billkainkoom.ogya.quicklist.BaseComponent
import com.billkainkoom.ogya.quicklist.Listable
import com.billkainkoom.ogya.quicklist.ListableType
import com.hubtel.galaconf2018.R
import com.hubtel.galaconf2018.databinding.ComponentSuggestionBinding


data class Suggestion(var name: String, var image: Int, var extraImage: Int) : Listable {

    override fun getListableType(): ListableType? {
        return ListableTypes.ComponentSuggestion
    }

}


//response
object ComponentSuggestion : BaseComponent<ComponentSuggestionBinding, Suggestion>() {

    override fun listableType(): ListableType {
        return ListableTypes.ComponentSuggestion
    }

    override fun render(binding: ComponentSuggestionBinding, listable: Suggestion) {
        //customization
        binding.title.text = listable.name
        binding.image.setImageResource(listable.image)
        binding.extraImage.setImageResource(listable.extraImage)
    }

    fun render(binding: ComponentSuggestionBinding, listable: Suggestion, context: Context, action: () -> Unit) {
        //customization
        render(binding, listable)

        binding.close.setOnClickListener {
            QuickDialog(
                    context = context,
                    style = QuickDialogType.Alert,
                    image = R.drawable.ic_delete_black_24dp,
                    title = "Remove",
                    message = "Do you want to remove ${listable.name}")
                    .overrideButtonNames("Yes", "No")
                    .overrideClicks(positiveClick = { ->

                        val progress = QuickDialog(context = context, style = QuickDialogType.Progress, title = "Please wait", message = "Removing ${listable.name}").show()

                        Handler().postDelayed({
                            progress.dismiss()
                            action()
                        }, 2000)


                    }, negativeClick = { ->

                    }).show()
        }


    }


}

