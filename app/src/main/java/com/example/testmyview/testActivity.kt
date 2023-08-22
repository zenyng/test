package com.example.testmyview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity

import android.widget.ImageView
import com.example.testmyview.databinding.ActivityMainBinding


class testActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  lateinit var intent:Intent
    private lateinit var testImageId:ImageView
    private lateinit var glide:GlideObj
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        testImageId  = findViewById(R.id.testimage)
              // "  aabb  ".replace(" ","")
           val glide:GlideObj = GlideObj(this,testImageId,"  https://media4.giphy.com/media/13Nc3xlO1kGg3S/giphy.gif?cid=ecf05e47qkes5ft4momlhyvzdq5rzm46pfvbmxbepkv5rzo5&ep=v1_gifs_related&rid=giphy.gif&ct=g")
              glide.setOnclick {
                  try{
                      intent = Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.youtube.com/watch?v=Rj0nhzmYlW8")).
                      setPackage("com.google.android.youtube")
                      //object   포켓 사용하면됨
                      if (intent != null)
                      {
                          startActivity(intent)

                      }/*else{
                         throw IllegalAccessError("intent is null ")
                     }*/


                  }catch (e:Exception)
                  {
                      Log.i("TestSoce","${e.message}")

                  }finally {
                      //intent = null
                  }
              }
        // 액티비티 잇는가?
         //util 포장
         // 렉 처리 list clear 이미지 삭제
         //
         //
       //if(getActivity()!=null)


    }

    override fun onDestroy()
    {
        super.onDestroy()
        if(glide!=null){
            Log.i("test","객체 살아 잇음.")
            glide.cleanObj()

        }

    }


}