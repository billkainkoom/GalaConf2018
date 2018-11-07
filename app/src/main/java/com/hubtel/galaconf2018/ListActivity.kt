package com.hubtel.galaconf2018

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.billkainkoom.ogya.quicklist.LayoutManager
import com.billkainkoom.ogya.quicklist.Listable
import com.billkainkoom.ogya.quicklist.ListableHelper
import com.hubtel.galaconf2018.component.*
import com.hubtel.galaconf2018.databinding.*

class ListActivity : AppCompatActivity() {

    lateinit var activityListBinding: ActivityListBinding
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_list)
        activityListBinding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        context = this

        loadPage()
    }

    fun loadPage() {
        var data = mutableListOf<Listable>()

        //greetings
        data.add(General(title = "Greetings from Abroad", type = ListableTypes.ComponentSectionHeader))
        data.add(Greeting("Upload contacts", image = R.drawable.ic_contacts_black_24dp))
        data.add(Greeting("All people", image = R.drawable.ic_view_list_black_24dp))


        //answers
        data.add(General(title = "Answers from Ghana", type = ListableTypes.ComponentSectionHeader))
        data.add(Answer(name = "Elijah Tetteh", subtitle = "Added from Facebook", image = R.drawable.profile, extraImage = R.drawable.ic_pan_tool_black_24dp))
        data.add(Answer(name = "Raymond Okai", subtitle = "Added from Facebook", image = R.drawable.profile, extraImage = R.drawable.ic_pan_tool_black_24dp))
        data.add(Answer(name = "Beatrice Dosu", subtitle = "Added from Facebook", image = R.drawable.profile, extraImage = R.drawable.ic_pan_tool_black_24dp))


        ListableHelper.loadList(
                context = context,
                recyclerView = activityListBinding.list,
                listableType = ListableTypes.ComponentGreeting,
                listables = data,
                listableBindingListener = { listable, listableBinding, position ->
                    when (listable.getListableType()) {
                        ListableTypes.ComponentGreeting -> {
                            ComponentGreeting.render(listableBinding as ComponentGreetingBinding, listable as Greeting)
                        }
                        ListableTypes.ComponentAnswer -> {
                            ComponentAnswer.render(listableBinding as ComponentAnswerBinding, listable as Answer)
                        }
                        ListableTypes.ComponentSectionHeader -> {
                            ComponentSectionHeader.render(listableBinding as ComponentSectionHeaderBinding, listable as General)
                        }
                    }


                },
                layoutManagerType = LayoutManager.Vertical
        )
    }
}
