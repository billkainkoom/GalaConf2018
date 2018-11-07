package com.hubtel.galaconf2018

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.billkainkoom.ogya.quicklist.LayoutManager
import com.billkainkoom.ogya.quicklist.Listable
import com.billkainkoom.ogya.quicklist.ListableHelper
import com.hubtel.galaconf2018.component.*
import com.hubtel.galaconf2018.databinding.ActivityListBinding
import com.hubtel.galaconf2018.databinding.ActivityMainBinding
import com.hubtel.galaconf2018.databinding.ComponentAnswerBinding
import com.hubtel.galaconf2018.databinding.ComponentGreetingBinding

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
        for (index in 0..100) {
            if (index % 2 == 0) {
                data.add(Greeting("Greeting ${index}"))
            } else {
                data.add(Answer("Answer ${index}"))
            }

        }

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
                    }


                },
                layoutManagerType = LayoutManager.Vertical
        )
    }
}
