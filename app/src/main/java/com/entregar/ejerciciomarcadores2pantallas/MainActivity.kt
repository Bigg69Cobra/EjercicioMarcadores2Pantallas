package com.entregar.ejerciciomarcadores2pantallas

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.entregar.ejerciciomarcadores2pantallas.ui.theme.EjercicioMarcadores2PantallasTheme

class MainActivity : ComponentActivity() {
    private var contadorBlancos = 0
    private var contadorNegros = 0
    private var contadorFaltasBlancos = 0
    private var contadorFaltasNegros = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // CONTADOR-BLANCOS:
        //referencia al marcadorResultadoBlancos
        val marcadorResultadoBlancos = findViewById<TextView>(R.id.marcadorResultadoBlancos)

        //inicializamos el marcadorResultadoBlancos con el contadorBlancos a 0
        marcadorResultadoBlancos.setText(contadorBlancos.toString())

        //creamos las variables para los botones de sumar y restar
        val buttonSumar1 = findViewById<Button>(R.id.buttonSumar1)
        val buttonSumar2 = findViewById<Button>(R.id.buttonSumar2)
        val buttonSumar3 = findViewById<Button>(R.id.buttonSumar3)
        val buttonRestar1 = findViewById<Button>(R.id.buttonRestar1)

        //asociaciamos una expresión lambda como respuesta(callback) al evento Clic sobre los botones:
        //botón de sumar 1
        buttonSumar1.setOnClickListener {
            contadorBlancos++
            marcadorResultadoBlancos.setText(contadorBlancos.toString())
        }

        //botón de sumar 2
        buttonSumar2.setOnClickListener {
            contadorBlancos = contadorBlancos + 2
            marcadorResultadoBlancos.setText(contadorBlancos.toString())
        }

        //botón de sumar 3
        buttonSumar3.setOnClickListener {
            contadorBlancos = contadorBlancos + 3
            marcadorResultadoBlancos.setText(contadorBlancos.toString())
        }

        //botón de restar 1
        buttonRestar1.setOnClickListener {
            contadorBlancos--
            if (contadorBlancos < 0){
                contadorBlancos = 0
            }
            marcadorResultadoBlancos.setText(contadorBlancos.toString())
        }




        //FALTAS-BLANCOS
        //referencia al contadorFaltasBlancos
        val marcadorFaltasBlancos = findViewById<TextView>(R.id.marcadorFaltasBlancos)

        //inicializamos el textViewFaltasLocal con el contadorFaltasLocal a 0
        marcadorFaltasBlancos.setText(contadorFaltasBlancos.toString())

        //creamos las variables para los botones de sumar, restar
        val buttonRestarPersonalBlancos = findViewById<Button>(R.id.buttonRestarPersonalBlancos)
        val buttonSumarPersonalAtaque = findViewById<Button>(R.id.buttonSumarPersonalAtaque)


        //asociaciamos una expresión lambda como respuesta (callback) al evento Clic sobre los botones:
        //botón de sumar 1 falta
        buttonSumarPersonalAtaque.setOnClickListener {
            contadorFaltasBlancos++
            marcadorFaltasBlancos.setText(contadorFaltasBlancos.toString())
        }

        //botón de restar 1 falta
        buttonRestarPersonalBlancos.setOnClickListener {
            contadorFaltasBlancos--
            if (contadorFaltasBlancos < 0){
                contadorFaltasBlancos = 0
            }
            marcadorFaltasBlancos.setText(contadorFaltasBlancos.toString())
        }








        // CONTADOR-BLANCOS:NEGROS
        //referencia al marcadorResultadoNegros
        val marcadorResultadoNegros = findViewById<TextView>(R.id.marcadorResultadoNegros)





        //FALTAS-NEGROS
        //referencia al marcadorFaltasNegros
        val marcadorFaltasNegros = findViewById<TextView>(R.id.marcadorFaltasNegros)

        //inicializamos el marcadorFaltasNegros con el contadorFaltasLocal a 0
        marcadorFaltasNegros.setText(contadorFaltasNegros.toString())

        //creamos las variables para los botones de sumar, restar
        val buttonRestarPersonalNegros = findViewById<Button>(R.id.buttonRestarPersonalNegros)
        val buttonSumarPersonalDefensa = findViewById<Button>(R.id.buttonSumarPersonalDefensa)


        //asociaciamos una expresión lambda como respuesta (callback) al evento Clic sobre los botones:
        //botón de sumar 1 falta
        buttonSumarPersonalDefensa.setOnClickListener {
            contadorFaltasNegros++
            marcadorFaltasNegros.setText(contadorFaltasNegros.toString())
        }

        //botón de restar 1 falta
        buttonRestarPersonalNegros.setOnClickListener {
            contadorFaltasNegros--
            if (contadorFaltasNegros < 0){
                contadorFaltasNegros = 0
            }
            marcadorFaltasNegros.setText(contadorFaltasNegros.toString())
        }




        //RESET-PERSONALES de los dos equipos
        //creamos la variable para el boton de poner las personales a cero
        val buttonResetPersonales = findViewById<Button>(R.id.buttonResetPersonales)

        //botón para poner todos los marcadores a cero
        buttonResetPersonales.setOnClickListener {
            //ponemos los dos contadores a 0
            contadorFaltasBlancos = 0
            contadorFaltasNegros = 0

            //seteamos el valor de los contadores que es 0 en los dos marcadores
            marcadorFaltasBlancos.setText(contadorFaltasBlancos.toString())
            marcadorFaltasNegros.setText(contadorFaltasNegros.toString())
        }





        //RESET ALL
        //creamos la variable para el boton de poner todos los marcadores a cero
        val buttonTotalReset = findViewById<Button>(R.id.buttonTotalReset)

        //botón para poner todos los marcadores a cero
        buttonTotalReset.setOnClickListener {
            contadorBlancos = 0
            contadorNegros = 0
            contadorFaltasBlancos = 0
            contadorFaltasNegros = 0

            marcadorResultadoBlancos.setText(contadorBlancos.toString())
            marcadorResultadoNegros.setText(contadorNegros.toString())

            marcadorFaltasBlancos.setText(contadorFaltasBlancos.toString())
            marcadorFaltasNegros.setText(contadorFaltasNegros.toString())
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EjercicioMarcadores2PantallasTheme {
        Greeting("Android")
    }
}