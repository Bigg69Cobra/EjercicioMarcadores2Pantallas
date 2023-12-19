package com.entregar.ejerciciomarcadores2pantallas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class AtacanNegros : ComponentActivity() {
    private var contadorBlancos = 0
    private var contadorNegros = 0
    private var contadorFaltasBlancos = 0
    private var contadorFaltasNegros = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dos)

        // CONTADOR-NEGROS:
        //referencia al marcadorResultadoNegros
        val marcadorResultadoNegros = findViewById<TextView>(R.id.marcadorResultadoNegros)

        //inicializamos el marcadorResultadoNegros con el contadorBlancos a 0
        marcadorResultadoNegros.setText(contadorNegros.toString())

        //creamos las variables para los botones de sumar y restar
        val buttonSumar1 = findViewById<Button>(R.id.buttonSumar1)
        val buttonSumar2 = findViewById<Button>(R.id.buttonSumar2)
        val buttonSumar3 = findViewById<Button>(R.id.buttonSumar3)
        val buttonRestar1 = findViewById<Button>(R.id.buttonRestar1)

        //asociaciamos una expresión lambda como respuesta(callback) al evento Clic sobre los botones:
        //botón de sumar 1
        buttonSumar1.setOnClickListener {
            contadorNegros++
            marcadorResultadoNegros.setText(contadorNegros.toString())
        }

        //botón de sumar 2
        buttonSumar2.setOnClickListener {
            contadorNegros = contadorNegros + 2
            marcadorResultadoNegros.setText(contadorNegros.toString())
        }

        //botón de sumar 3
        buttonSumar3.setOnClickListener {
            contadorNegros = contadorNegros + 3
            marcadorResultadoNegros.setText(contadorNegros.toString())
        }

        //botón de restar 1
        buttonRestar1.setOnClickListener {
            contadorNegros--
            if (contadorNegros < 0){
                contadorNegros = 0
            }
            marcadorResultadoNegros.setText(contadorNegros.toString())
        }




        //FALTAS-NEGROS
        //referencia al marcadorFaltasNegros
        val marcadorFaltasNegros = findViewById<TextView>(R.id.marcadorFaltasNegros)

        //inicializamos el textViewFaltasLocal con el contadorFaltasLocal a 0
        marcadorFaltasNegros.setText(marcadorFaltasNegros.toString())

        //creamos las variables para los botones de sumar, restar
        val buttonRestarPersonalNegros = findViewById<Button>(R.id.buttonRestarPersonalNegros)
        val buttonSumarPersonalAtaque = findViewById<Button>(R.id.buttonSumarPersonalAtaque)


        //asociaciamos una expresión lambda como respuesta (callback) al evento Clic sobre los botones:
        //botón de sumar 1 falta
        buttonSumarPersonalAtaque.setOnClickListener {
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








        // CONTADOR-NEGROS:BLANCOS
        //referencia al marcadorResultadoBlancos
        val marcadorResultadoBlancos = findViewById<TextView>(R.id.marcadorResultadoBlancos)





        //FALTAS-BLANCOS
        //referencia al marcadorFaltasNegros
        val marcadorFaltasBlancos = findViewById<TextView>(R.id.marcadorFaltasBlancos)

        //inicializamos el marcadorFaltasNegros con el contadorFaltasLocal a 0
        marcadorFaltasBlancos.setText(contadorFaltasBlancos.toString())

        //creamos las variables para los botones de sumar, restar
        val buttonRestarPersonalBlancos = findViewById<Button>(R.id.buttonRestarPersonalBlancos)
        val buttonSumarPersonalDefensa = findViewById<Button>(R.id.buttonSumarPersonalDefensa)


        //asociaciamos una expresión lambda como respuesta (callback) al evento Clic sobre los botones:
        //botón de sumar 1 falta
        buttonSumarPersonalDefensa.setOnClickListener {
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








        //CAMBIO-POSESIÓN
        // Localizamos el botón de abrir la nueva actividad
        val buttonCambioPosesionABlancos = findViewById<Button>(R.id.buttonCambioPosesionABlancos)

        // Y le asociamos el gestor de eventos para el clic
        // Creando un intent que abra la otra actividad
        buttonCambioPosesionABlancos.setOnClickListener{
            val intent = Intent(baseContext, MainActivity::class.java)  //llama a la otra pantalla
            intent.putExtra("contadorNegros", contadorNegros)
            startActivity(intent)
        }
    }
}
/*
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
*/