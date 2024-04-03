package org.d3if0024.mobpro1assesment.ui.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if0024.mobpro1assesment.R
import org.d3if0024.mobpro1assesment.navigation.Screen
import org.d3if0024.mobpro1assesment.ui.theme.Mobpro1AssesmentTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold (
        topBar = {
            TopAppBar(title = {
                Text(text = (stringResource(id = R.string.app_name)))
            },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                actions = {
                    IconButton(onClick = {
                    navController.navigate(Screen.About.route)
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Face ,
                            contentDescription = stringResource(id = R.string.tentang_aplikasi),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        }
    ) { padding ->
        ScreenContent(Modifier.padding(padding))
    }


}

@Composable
fun ScreenContent(modifier: Modifier){

    var rupiah by rememberSaveable { mutableStateOf("") }
    val radioOption = listOf(
    stringResource(id = R.string.usd ),
    stringResource(id = R.string.yen)
    )
    var mataUang by rememberSaveable { mutableStateOf(radioOption[0]) }

    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)

    ){

        Text(
            text = stringResource(id = R.string.info_aplikasi)
        )

    OutlinedTextField(
        value =rupiah ,
        onValueChange = { rupiah = it},
        label = { Text(text = stringResource(id = R.string.mata_uang))},
        trailingIcon = { Text(text = "Rp")},
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        modifier = Modifier.fillMaxWidth()
    )

    Row (
        modifier = Modifier
            .padding(top = 9.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
    ) {
        radioOption.forEach{text ->
            MataUangOption(
                label = text,
                isSelected = mataUang == text,
                modifier = Modifier
                    .selectable(
                        selected = mataUang == text,
                        onClick = { mataUang = text },
                        role = Role.RadioButton
                    )
                    .weight(1f)
                    .padding(16.dp)
            )

        }
    }
     Button(
         onClick = {
                   /*TODO*/
                   },
         modifier = Modifier.padding(top = 8.dp),
         contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
     ) {
        Text(text = stringResource(id = R.string.hitung_konversi))
     }

    }
}

@Composable
fun MataUangOption (label:String, isSelected: Boolean, modifier: Modifier) {
Row (
    modifier = modifier,
    verticalAlignment = Alignment.CenterVertically
){
    RadioButton(selected = isSelected, onClick = null)
    Text(
        text = label,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(start = 8.dp)
    )
}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Mobpro1AssesmentTheme {
        MainScreen(rememberNavController())
    }
}