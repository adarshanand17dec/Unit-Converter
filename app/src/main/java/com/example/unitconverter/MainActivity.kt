package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UnitConverter(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun UnitConverter(modifier: Modifier) {

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Centimeter") }
    var outputUnit by remember { mutableStateOf("Meter") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(0.01) }



    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

       //Here all the UI elements will be stacked below each other
        Text("Unit Converter")
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = inputValue, onValueChange = {
            inputValue = it
        // Here goes what should happen, when the value of OutlinedTextField change

        },
            label = {Text("Enter Value")})
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            //Input Box
            //Here all the UI elements will be stacked nect to each other
            Box{
                // Input Button
                Button(onClick = { iExpanded = true }) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false}) {
                    DropdownMenuItem(text =  {Text("Centimeter")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Centimeter"
                            conversionFactor.value = 0.01

                        }
                    )
                    DropdownMenuItem(text =  {Text("Meter")}, onClick = { /*TODO*/})
                    DropdownMenuItem(text =  {Text("Feet")}, onClick = { /*TODO*/})
                    DropdownMenuItem(text =  {Text("Millimeter")}, onClick = { /*TODO*/})

                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            // Output Box
            Box{
                // Output Button
                Button(onClick = { oExpanded = true }) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false}) {
                    DropdownMenuItem(text =  {Text("Centimeter")}, onClick = { /*TODO*/})
                    DropdownMenuItem(text =  {Text("Meter")}, onClick = { /*TODO*/})
                    DropdownMenuItem(text =  {Text("Feet")}, onClick = { /*TODO*/})
                    DropdownMenuItem(text =  {Text("Millimeter")}, onClick = { /*TODO*/})

                }
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Text("Result:")
    }
}




@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter(modifier = Modifier.fillMaxSize())
}