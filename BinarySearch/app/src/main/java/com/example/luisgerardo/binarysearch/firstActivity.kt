/**
 * @author Luis Leon
 */
package com.example.luisgerardo.binarysearch

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class firstActivity : AppCompatActivity(){

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val codeTxt = findViewById<TextView>(R.id.txtCode)

        codeTxt.setText("fun binarySearch(list: List<String>, e: Int): Int {\n" +
                "        fun go(low: Int, high: Int): Int {\n" +
                "            val mid = (low + high) / 2\n" +
                "\n" +
                "            return if (low == mid) 0 else when (list[mid].toInt()) {\n" +
                "                e -> mid\n" +
                "                else -> if (e < list[mid].toInt()) go(low, mid) else go(mid, high)\n" +
                "            }\n" +
                "        }\n" +
                "        return go(0, list.size)\n" +
                "    }")

        val vectorTxt = findViewById<EditText>(R.id.vector)
        val encontrarTxt = findViewById<EditText>(R.id.numEncontrar)
        val buttonSearch = findViewById<Button>(R.id.btnEncontrar)

        buttonSearch.setOnClickListener {
            val index = binarySearch(vectorTxt.text.split(",") ,  encontrarTxt.text.toString().toInt())
            Toast.makeText(this,   "Se encontro en el index ${index+1}", Toast.LENGTH_SHORT).show()
        }
    }

    fun binarySearch(list: List<String>, e: Int): Int {
        fun go(low: Int, high: Int): Int {
            val mid = (low + high) / 2

            return if (low == mid) 0 else when (list[mid].toInt()) {
                e -> mid
                else -> if (e < list[mid].toInt()) go(low, mid) else go(mid, high)
            }
        }
        return go(0, list.size)
    }
}
