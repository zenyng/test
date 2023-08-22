package com.example.testmyview;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class GlideObj {
      private ImageView image=null;
     private callBackListener listener;
     private Activity activity = null;

       public GlideObj(Activity activity, ImageView image, String url){
            this.activity = activity;

           if(activity!=null && url !=null && image !=null){
               Glide.with(activity)
                       .load(url.replace(" ",""))
                       .skipMemoryCache(true)
                       .error(R.drawable.ic_launcher_background)
                       .diskCacheStrategy(DiskCacheStrategy.NONE)
                       .into(image);

               image.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       listener.callBack(1);
                   }
               });
           }

       }
       public void setOnclick(callBackListener listener){
                  this.listener = listener;
       }

       public interface callBackListener{
           public void callBack(int y);
       }
       public void cleanObj()
       {
           Glide.get(this.activity).clearDiskCache();
           Glide.get(this.activity).clearMemory();
           this.activity = null;

       }


       public void checkVersion(){
           //com.ybchat.korea.cn
       }
}
