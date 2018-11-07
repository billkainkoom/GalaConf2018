package com.hubtel.galaconf2018.component

import com.billkainkoom.ogya.quicklist.BaseComponent
import com.billkainkoom.ogya.quicklist.Listable
import com.billkainkoom.ogya.quicklist.ListableType
import com.hubtel.galaconf2018.databinding.ComponentSectionHeaderBinding


data class General(var title: String = "", var type: ListableType) : Listable {

    override fun getListableType(): ListableType? {
        return type
    }

}

object ComponentSectionHeader : BaseComponent<ComponentSectionHeaderBinding, General>() {
    override fun listableType(): ListableType {
        return ListableTypes.ComponentSectionHeader
    }

    override fun render(binding: ComponentSectionHeaderBinding, listable: General) {
        binding.title.text = listable.title

    }

}