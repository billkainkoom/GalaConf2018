package com.hubtel.galaconf2018

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.billkainkoom.ogya.quickdialog.QuickDialog
import com.billkainkoom.ogya.quickdialog.QuickDialogType
import com.hubtel.galaconf2018.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    lateinit var context: Context
    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)
        context = this
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)



        setSupportActionBar(activityMainBinding.toolbar)

        activityMainBinding.fab.setOnClickListener {
            //when fab is clicked
            QuickDialog(
                    context = context,
                    style = QuickDialogType.Message,
                    title = "Hello World",
                    message = "The quick dialog jumped over the old dialog",
                    image = R.drawable.ic_info_outline_black_24dp)
                    .overrideButtonNames(positive = "Cancel")
                    .overrideClicks(
                            positiveClick = { ->
                                Toast.makeText(context, "Clicked on OK", Toast.LENGTH_SHORT).show()
                            },
                            negativeClick = {

                            },
                            neutralClick = {

                            }

                    )
                    .showPositiveButton()
                    .show()
        }

        activityMainBinding.content.button1.setOnClickListener {
            QuickDialog(
                    context = context,
                    style = QuickDialogType.Alert,
                    title = "Proceed",
                    message = "Do you want to take this action")
                    .overrideButtonNames("Yes", "No")
                    .overrideClicks(positiveClick = { ->
                        Toast.makeText(context, "Yes", Toast.LENGTH_SHORT).show()
                    }, negativeClick = { ->
                        Toast.makeText(context, "No", Toast.LENGTH_SHORT).show()
                    })
                    .show()
        }

        activityMainBinding.content.button2.setOnClickListener {
            QuickDialog(
                    context = context,
                    style = QuickDialogType.WithInput,
                    title = "Verify Code",
                    message = "Please verify the SMS code that was sent to you")
                    .overrideButtonNames("Verify", "Cancel", "Re-send")
                    .overrideClicks(
                            positiveClick = { dismiss, inputText ->
                                if (inputText.length < 3) {
                                    Toast.makeText(context, "Please enter a 4 digit code", Toast.LENGTH_SHORT).show()
                                } else if (inputText == "4000") {
                                    Toast.makeText(context, "Verified", Toast.LENGTH_SHORT).show()
                                    dismiss()
                                } else {
                                    Toast.makeText(context, "You entered the wrong code", Toast.LENGTH_SHORT).show()
                                }
                            }, negativeClick = { dismiss, inputText ->
                        dismiss()
                    }, neutralClick = { dismiss, inputText ->
                        //Your action
                        dismiss()
                    })
                    .withInputHint("Code")
                    .withInputLength(4)
                    .withInputType(InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL)
                    .showNeutralButton()
                    .show()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}







