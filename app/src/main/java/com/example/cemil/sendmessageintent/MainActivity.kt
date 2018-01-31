package com.example.cemil.sendmessageintent

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    //Bu yöntem kullanılarak mesaj göndere biliryoruz fakat telefonun kendi mesaj platdormuna gitmemiz gerekiyor.
    fun sendMessage(view: View) {
        val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+phoneText.text.toString()))
        intent.putExtra("sms_body",messageText.text.toString())
        startActivity(intent)
    }
    //Bu Function kullanılarak SmsManager aracılığıyla direkt mesaj gönderiyoruz.
    fun sendDirect(view: View) {
        val mesaj=SmsManager.getDefault()
        mesaj.sendTextMessage(phoneText.text.toString(),null,messageText.text.toString(),null,null)

    }
}
