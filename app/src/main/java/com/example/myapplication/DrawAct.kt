package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityDrawBinding

/**
 * @create zhl
 * @date 2022/11/7 18:05
 * @description
 *
 * @update
 * @date
 * @description
 **/
class DrawAct : AppCompatActivity() {
    lateinit var vb: ActivityDrawBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityDrawBinding.inflate(layoutInflater)
        setContentView(vb.root)
        vb.tv.setOnClickListener {
            vb.door.also {
                if (!it.closing) it.startCloseDoor()
                else it.stopCloseDoor(true)
            }
        }
        Log.d("onCreate", "onCreate")
    }

}