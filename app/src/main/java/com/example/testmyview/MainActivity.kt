package com.example.testmyview

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.testmyview.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout.TabGravity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private  lateinit var intent:Intent
    private lateinit var testImageId:ImageView
    private lateinit var glide:GlideObj
    private lateinit var button_second :Button
    private lateinit var version : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        button_second = findViewById(R.id.button_second)
        button_second.setOnClickListener(View.OnClickListener {


               intent = Intent(this@MainActivity,testActivity::class.java)
               startActivity(intent)
        })


            Thread{
                try {
                    version= MarketVersionChecker.getMarketVersionFast("com.ybchat.korea.cn")
                   /* if(MarketVersionChecker.getMarketVersionFast("com.ybchat.korea.cn") !=null){
                        version= MarketVersionChecker.getMarketVersionFast("com.ybchat.korea.cn")

                    }*/
                    if(version != null){
                        Log.i("TestSoce","version: ${version}")
                    }

                }catch (e:NullPointerException){
                    Log.i("TestSoce","${e}")
                }



                //
            }.start()




        //java.lang.IllegalStateException: Default FirebaseApp is not initialized in this process com.example.testmyview. Make sure to call FirebaseApp.initializeApp(Context) first.





        testImageId  = findViewById(R.id.testimage)
              // "  aabb  ".replace(" ","")
           glide = GlideObj(this,testImageId,"  https://media4.giphy.com/media/13Nc3xlO1kGg3S/giphy.gif?cid=ecf05e47qkes5ft4momlhyvzdq5rzm46pfvbmxbepkv5rzo5&ep=v1_gifs_related&rid=giphy.gif&ct=g")
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
        /*Glide.with(this)
            .load("https://media4.giphy.com/media/13Nc3xlO1kGg3S/giphy.gif?cid=ecf05e47qkes5ft4momlhyvzdq5rzm46pfvbmxbepkv5rzo5&ep=v1_gifs_related&rid=giphy.gif&ct=g")
            .skipMemoryCache(true)
            .error(R.drawable.ic_launcher_background)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(testImageId)*/

           /*  testImageId.setOnClickListener(View.OnClickListener {
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

            */
               /*   }
              })*/

    }

    override fun onDestroy()
    {
        super.onDestroy()
        if(glide!=null){
                 Log.i("test","객체 살아 잇음.")

         }

    }


}