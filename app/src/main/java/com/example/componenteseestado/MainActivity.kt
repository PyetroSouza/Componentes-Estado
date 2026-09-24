package com.example.componenteseestado

import android.R.attr.contentDescription
import android.R.attr.fontFamily
import android.R.attr.label
import android.R.attr.text
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.collection.mutableObjectIntMapOf
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DoubleArrow
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberWideNavigationRailState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.isCtrlPressed
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.AndroidFont
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componenteseestado.ui.theme.ComponentesEEstadoTheme
import com.example.componenteseestado.ui.theme.Righteous
import java.util.function.IntConsumer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentesEEstadoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BasicComponentScreen(
                        modifier = Modifier
                            .padding((innerPadding))
                    )
                }
            }
        }
    }
}

@Composable
fun BasicComponentScreen(modifier: Modifier = Modifier) {
    var textoInput by remember {
        mutableStateOf(TextFieldValue(""))
    }

    var quantidade by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var kotlin by remember {
        mutableStateOf(false)
    }

    var jetpackCompose by remember {
        mutableStateOf(false)
    }

    var android by remember {
        mutableStateOf(false)
    }

    var sistemaSelecionado by remember {
        mutableStateOf("")
    }

    var corFundo by remember {
        mutableStateOf(Color(239, 247, 207))
    }

    var favoritado by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(corFundo)
            .padding(start = 5.dp, end = 5.dp)
    ) {
        Text(
            text = "Aulas Android",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3DDC84),
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            letterSpacing = 4.sp
        )
        Text(
            text = "com JetPack Compose",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(66, 133, 244),
            fontFamily = Righteous,
            modifier = Modifier.align(Alignment.CenterHorizontally)

        )

        Spacer(modifier = Modifier.height(5.dp))
        ////////////////////
        //NOME E SOBRENOME//
        ///////////////////

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = textoInput,
            singleLine = true,
            onValueChange = { novoValor ->
                Log.i("text", novoValor.text)

                textoInput = novoValor
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words
            ),
            label = {
                Text("Nome e Sobrenome")
            },
            shape = RoundedCornerShape(
                10.dp
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Ícone pessoa",
                    tint = Color(66, 133, 244),
                )
            }
        )

        Spacer(modifier = Modifier.height(5.dp))

        ////////////////////
        //   QUANTIDADE   //
        ///////////////////

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = quantidade,
            singleLine = true,
            onValueChange = { novoValor ->
                quantidade = novoValor
            },
            label = {
                Text("Quantidade")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            placeholder = {
                Text(text = "Qual a quantidade?")
            },
            shape = RoundedCornerShape(
                10.dp
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Blue,
                unfocusedTextColor = Color.Blue,
                unfocusedPlaceholderColor = Color.Gray
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Numbers,
                    contentDescription = "Ícone quantidade",
                    tint = Color(66, 133, 244)
                )
            }
        )

        Spacer(modifier = Modifier.height(5.dp))

        ////////////////////
        //     EMAIL     //
        ///////////////////

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text(text = "Digite seu email")
            },
            shape = RoundedCornerShape(
                10.dp
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Blue,
                unfocusedTextColor = Color.Blue,
                unfocusedPlaceholderColor = Color.Gray
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Ícone de Email",
                    tint = Color(66, 133, 244)
                )
            }
        )

        Spacer(modifier = Modifier.height(5.dp))

        ////////////////////
        //   CHECK BOX   //
        ///////////////////
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = kotlin,
                onCheckedChange = { kotlin = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Blue
                )
            )
            Text("Kotlin")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = android,
                onCheckedChange = { android = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Blue
                )
            )
            Text("Android")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = jetpackCompose,
                onCheckedChange = { jetpackCompose = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Blue
                )
            )
            Text("Jetpack Compose")
        }

        ////////////////////
        //  RADIO BUTTON  //
        ///////////////////

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == "mo",
                onClick = { sistemaSelecionado = "mo" }
            )
            Text(text = "MacOs")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == "wi",
                onClick = { sistemaSelecionado = "wi" }
            )
            Text(text = "Windows")
        }


        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == "ln",
                onClick = { sistemaSelecionado = "ln" }
            )
            Text(text = "Linux")
        }

        ////////////////////
        //    BUTTON      //
        ///////////////////

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    corFundo = Color(239, 247, 207)
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color.Unspecified,
                )
            ) {
                Text(text = "Clique aqui")
            }

            OutlinedButton(
                onClick = {
                    corFundo = Color(0xFF9C91B2)
                },

                ) {
                Text(text = "Outro botão")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            if (favoritado) {
                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            favoritado = false
                        },
                    imageVector = Icons.Default.Favorite,
                    tint = Color(255, 0, 0),
                    contentDescription = "Favorite Icon"
                )
            } else {
                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            favoritado = true
                        },
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite Border Icon"
                )
            }
        }

    }
}

