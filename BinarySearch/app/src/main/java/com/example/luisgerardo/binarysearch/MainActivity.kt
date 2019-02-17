/**
 * @author Luis Leon
 */
package com.example.luisgerardo.binarysearch

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView1 = findViewById<TextView>(R.id.text1)
        val image1 = findViewById<ImageView>(R.id.img1)
        val textView2 = findViewById<TextView>(R.id.text2)

        val animation1 = AnimationUtils.loadAnimation(this, R.anim.anim1)
        val animation2 = AnimationUtils.loadAnimation(this, R.anim.anim2)
        val animation3 = AnimationUtils.loadAnimation(this, R.anim.anim3)

        image1.startAnimation(animation3)
        textView1.startAnimation(animation1)
        textView2.startAnimation(animation2)

        Timer().schedule( object : TimerTask()
        {
            override fun run(){
                val intent = Intent(this@MainActivity, firstActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 5000)
    }
}
