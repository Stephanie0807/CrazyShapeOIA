package tw.edu.pu.csim.tcyang.crazyshape

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import kotlinx.android.synthetic.main.activity_main.*
@GlideModule
public final class MyAppGlideModule : AppGlideModule()


class MainActivity : AppCompatActivity() {

    var Flag:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val img: ImageView = findViewById(R.id.imgTitle)
        GlideApp.with(this)
            .load(R.drawable.cover)
            .override(800, 600)
            .into(imgTitle)

        RndShape()

        Toast.makeText(baseContext, "作者：黃麗琪", Toast.LENGTH_LONG).show()

        imgNext.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(p0: View?): Boolean {
                intent = Intent(this@MainActivity, GameActivity::class.java).apply {
                putExtra("形狀", Flag)
            }
                //starActivity(intent)
                startActivityForResult(intent,99)
                return true
            }
        })
        imgNext.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                RndShape()
            }
    })
}
fun RndShape() {
    Flag = (1..4).random()
    when (Flag) {
        1 -> imgNext.setImageResource(R.drawable.circle)
        2 -> imgNext.setImageResource(R.drawable.square)
        3 -> imgNext.setImageResource(R.drawable.star)
        4 -> imgNext.setImageResource(R.drawable.triangle)
    }
}

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 99){
            intent= Intent(this@MainActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}