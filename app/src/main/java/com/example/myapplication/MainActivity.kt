package com.example.myapplication


import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

import com.example.myapplication.R.layout.custom_toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val dialog = AlertDialog.Builder(this@MainActivity)
                dialog.setTitle("請選擇功能")
                dialog.setMessage("請根據下方按鈕選擇要顯示的物件")

                dialog.setNeutralButton(
                    "取消"
                ) { dialogInterface, i ->
                    Toast.makeText(
                        this@MainActivity,
                        "dialog關閉",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                dialog.setNegativeButton(
                    "自定義Toast"
                ) { dialogInterface, i -> showToast() }
                dialog.setPositiveButton(
                    "自定義Toast"
                ) { dialogInterface, i -> showToast() }

                dialog.setPositiveButton(
                    "顯示list"
                ) { dialogInterface, i -> showListDialog() }
                dialog.show()
            }

            private fun showToast() {
                val toast = Toast(this@MainActivity)
                toast.setGravity(Gravity.TOP, 0, 50)
                toast.duration = Toast.LENGTH_SHORT
                val inflater = layoutInflater
                val layout = inflater.inflate(
                    R.layout.custom_toast,
                    findViewById(R.id.custom_toast_root) as ViewGroup
                )
                toast.view = layout
                toast.show()
            }

            private fun showListDialog() {
                val list = arrayOf("messsage1", "messsage2", "messsage3", "messsage4", "messsage5")
                val dialog_list = AlertDialog.Builder(this@MainActivity)
                dialog_list.setTitle("使用LIST呈現")
                dialog_list.setItems(list) { dialogInterface, i ->
                    Toast.makeText(
                        this@MainActivity,
                        "你選得是" + list[i], Toast.LENGTH_SHORT
                    ).show()
                }
                dialog_list.show()
            }
        })
    }
}
