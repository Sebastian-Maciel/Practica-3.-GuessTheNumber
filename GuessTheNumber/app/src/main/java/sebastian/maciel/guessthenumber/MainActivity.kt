package sebastian.maciel.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var minValue:Int = 0
    var maxValue:Int = 100
    var num:Int = 0
    var won:Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessings: TextView = findViewById(R.id.guessings)
        val down: Button = findViewById(R.id.down)
        val up: Button = findViewById(R.id.up)
        val generate: TextView = findViewById(R.id.generate)
        val guessed: TextView = findViewById(R.id.guessed)

        generate.setOnClickListener(){
            num = Random.nextInt(minValue, maxValue)
            guessings.setText(num.toString())
            generate.visibility = View.INVISIBLE
            guessed.visibility = View.VISIBLE
        }

        up.setOnClickListener(){
            minValue = num
            if (checkingLimits()){
                num = Random.nextInt(minValue, maxValue)
                guessings.setText(num.toString())
            } else{
                guessings.setText("A caray me ganaste :C")
            }
        }

        down.setOnClickListener(){
            maxValue = num
            if (checkingLimits()){
                num = Random.nextInt(minValue, maxValue)
                guessings.setText(num.toString())
            } else{
                guessings.setText("A caray me ganaste :C")
            }
        }

        guessed.setOnClickListener(){
            if (!won){
                guessings.setText("Adiviné, tu número es el siguiente: $num")
                guessed.setText("Volver a jugar")
                won = true
            } else {
                generate.visibility = View.VISIBLE
                guessings.setText("Tap on generate to star")
                guessed.visibility = View.GONE
                resetValues()
            }
        }
    }

    fun resetValues(){
        minValue = 0
        maxValue = 100
        won = false
        num = 0
    }

    fun checkingLimits(): Boolean{
        return minValue != maxValue
    }
}