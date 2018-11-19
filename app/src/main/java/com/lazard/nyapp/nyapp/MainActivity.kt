package com.lazard.nyapp.nyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.lazard.nyapp.picturetaker.PictureTaker
import com.lazard.nyapp.picturetaker.PictureTakerCamera
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        sample_text.text = stringFromJNI()

        button.setOnClickListener { PictureTaker.takeFromCamera(this) { path-> sample_text.text=""+path }}
        button2.setOnClickListener { PictureTaker.takeFromGallery(this) { path-> sample_text.text=""+path }}
    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
