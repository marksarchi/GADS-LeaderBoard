package com.sarchimarcus.gads_learderboard.submit

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sarchimarcus.gads_learderboard.R
import com.sarchimarcus.gads_learderboard.network.GadsApi
import kotlinx.android.synthetic.main.activity_submitt.*
import kotlinx.android.synthetic.main.confirm_submission_screen.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class SubmitActivity : AppCompatActivity() {

    var custom_dialog: Dialog? = null
    var success_dialog: Dialog? = null
    private lateinit var handler:Handler

    private var width = 0
    private var height: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submitt)

        val submitButton = submit_btn
        val emailInput = editText3
        val firstNameInput = editText
        val lastNameInput = editText2
        val projectLinkInput = editText4

        var yes_button = yes_button
        var close_button = close_button
        val metrics = resources.displayMetrics
        width = metrics.widthPixels
        height = metrics.heightPixels

        val retrofitSubmit = Retrofit.Builder()
            .baseUrl("https://docs.google.com/forms/d/e/")
            .build()

        submitButton.setOnClickListener {
            if(firstNameInput.text.toString().isEmpty() || lastNameInput.text.toString().isEmpty() || emailInput.text.toString().isEmpty() ||projectLinkInput.getText().toString().isEmpty()){
                Toast.makeText(this, "Please complete details", Toast.LENGTH_SHORT).show();
            }else{
                custom_dialog?.setContentView(R.layout.confirm_submission_screen)
                close_button.setOnClickListener {
                    custom_dialog?.dismiss()
                }
                custom_dialog?.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
                custom_dialog?.getWindow()?.setLayout((6 * width) / 7, (4 * height) / 5);
                custom_dialog?.show();

                yes_button.setOnClickListener {
                    val email = emailInput.text.toString()
                    val firstName = firstNameInput.text.toString()
                    val lastName = lastNameInput.text.toString()
                    val projectLink = projectLinkInput.text.toString()

                    postFormData(firstName, lastName, email, projectLink)
                }

            }

        }


    }

    val repoJob = Job()
    val coroutineScope = CoroutineScope(repoJob + Dispatchers.Main)

    fun postFormData(firstName: String, secondName: String, email: String, link: String) {
        coroutineScope.launch {
            val retrofitCall = GadsApi.retrofitService.postProjectDetails(
                firstName,
                secondName,
                email,
                link
            )
            retrofitCall.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        success_dialog?.setContentView(R.layout.successful_screen)
                        success_dialog?.getWindow()
                         success_dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
                        success_dialog?.getWindow()?.setLayout((6 * width) / 7, (4 * height) / 5);
                        success_dialog?.show();
                        handler = Handler()
                        handler.postDelayed({
                            success_dialog!!.cancel()
                            success_dialog!!.dismiss()
                            custom_dialog!!.dismiss()
                        }, 1000)

                    }

                }


                override fun onFailure(call: Call<Void>, t: Throwable) {
                    success_dialog?.setContentView(R.layout.not_successful_screen);
                    success_dialog?.getWindow()?.setBackgroundDrawable( ColorDrawable(Color.TRANSPARENT));
                    success_dialog?.getWindow()?.setLayout((6 * width)/7, (4 * height)/5);
                    success_dialog?.show();

                    handler = Handler();
                    handler.postDelayed({
                        success_dialog?.cancel();
                        success_dialog?.dismiss();
                    }, 1000)

                }



            })
        }
    }
}
