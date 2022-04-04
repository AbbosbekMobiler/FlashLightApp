package com.example.AbbosbekBotirjonovich

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var cameraM : CameraManager
    var isFlash = false

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cameraM = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        imgPower.setOnClickListener {
            flashLightOnRoOff(it)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun flashLightOnRoOff(v: View?) {
        if (!isFlash){
            val cameraListId = cameraM.cameraIdList[0]
            cameraM.setTorchMode(cameraListId,true)
            isFlash = true
            imgPower.setImageResource(R.drawable.ic_icon_on)

        }
        else{
            val cameraListId = cameraM.cameraIdList[0]
            cameraM.setTorchMode(cameraListId,false)
            isFlash = false
            imgPower.setImageResource(R.drawable.ic_icon_off)

        }
    }
}