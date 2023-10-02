package com.example.actividad_2_android

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {


    // El arreglo de la clase ItemsViewModel | ArrayList of class ItemsViewModel
    val data = ArrayList<ItemsViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initSpinner()

    }

    //ACA SE PONEN LOS DATOS DE LAS VISTAS
    fun llenarCardViewVidrio() {
        data.add(ItemsViewModel(R.drawable.baterias, "VIDRIO", "Estos son los puntos de reciclaje"))
    }

    fun llenarCardViewPapel() {
        data.add(ItemsViewModel(R.drawable.papel, "PAPEL", "Estos son los puntos de reciclaje"))
    }

    fun llenarCardViewLata() {
        data.add(ItemsViewModel(R.drawable.lata, "LATA", "Estos son los puntos de reciclaje"))
    }

    fun llenarCardViewBateria() {
        data.add(
            ItemsViewModel(
                R.drawable.baterias, "BATERÍA", "Estos son los puntos de reciclaje"
            )
        )
    }

    fun llenarCardViewTelefono() {
        data.add(
            ItemsViewModel(
                R.drawable.telefono, "TELÉFONO", "Estos son los puntos de reciclaje"
            )
        )
    }


    fun initSpinner() {

        // accede a los items de la lista | Categoria es nombre de variable | el resorcesgetstrinarray() obtiene los items del archivo string.xml .
        val categoria = resources.getStringArray(R.array.Categorias)

        // accede al spinner ubicado en el layout, activity_main.xml .
        val spinner = findViewById<Spinner>(R.id.categorias)

        //Valida si no es nulo, hace el arrayadapter, toma el objeto seleccionado y lo almacena en la variable adapter.
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this, android.R.layout.simple_spinner_item, categoria
            )
            spinner.adapter = adapter
            //selector de la categoria al pinchar
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    val categoriaSeleccionada = spinner.selectedItem.toString()

                    //seleccion de la categoria y al ser igual al nombre de la categoria, hace las siguientes acciones
                    when (categoriaSeleccionada) {
                        "RECICLAJE DE VIDRIO" -> {
                            Toast.makeText(
                                this@MainActivity,
                                "Seleccionaste vidrio, aquí vamos!",
                                Toast.LENGTH_SHORT
                            ).show()
                            data.clear()
                            llenarCardViewVidrio()
                            initRecyclerView()

                        }

                        "RECICLAJE DE PAPEL" -> {
                            Toast.makeText(
                                this@MainActivity,
                                "Seleccionaste papel, aquí vamos!",
                                Toast.LENGTH_SHORT
                            ).show()
                            data.clear()
                            llenarCardViewPapel()
                            initRecyclerView()
                        }

                        "RECICLAJE DE LATA" -> {
                            Toast.makeText(
                                this@MainActivity,
                                "Seleccionaste lata, aquí vamos!",
                                Toast.LENGTH_SHORT
                            ).show()
                            data.clear()
                            llenarCardViewLata()
                            initRecyclerView()

                        }

                        "RECICLAJE DE BATERIA" -> {
                            Toast.makeText(
                                this@MainActivity,
                                "Seleccionaste bateria, aquí vamos!",
                                Toast.LENGTH_SHORT
                            ).show()
                            data.clear()
                            llenarCardViewBateria()
                            initRecyclerView()
                        }

                        "RECICLAJE DE TELEFONO" -> {
                            Toast.makeText(
                                this@MainActivity,
                                "Seleccionaste teléfono, aquí vamos!",
                                Toast.LENGTH_SHORT
                            ).show()
                            data.clear()
                            llenarCardViewTelefono()
                            initRecyclerView()
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }

    private fun initRecyclerView() {
        // busca el id del recyclerView y lo guarda en la variable
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        // Crea un layout de forma vertical
        recyclerview.layoutManager = LinearLayoutManager(this)

        //Esto pasara el array a nuestro adaptador
        val adapter = CustomAdapter(data)

        // Configuración del adaptador con el recyclerview
        recyclerview.adapter = adapter

    }
}
