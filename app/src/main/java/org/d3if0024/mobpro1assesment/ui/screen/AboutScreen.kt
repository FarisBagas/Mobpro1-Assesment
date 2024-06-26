package org.d3if0024.mobpro1assesment.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if0024.mobpro1assesment.R
import org.d3if0024.mobpro1assesment.ui.theme.Mobpro1AssesmentTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavHostController) {
    Scaffold (
        topBar = {
            TopAppBar(navigationIcon = {
               IconButton(onClick = {navController.popBackStack()}) {
                   Icon(
                       imageVector =Icons.Filled.ArrowBack ,
                       contentDescription = stringResource(id = R.string.kembali),
                       tint = MaterialTheme.colorScheme.primary
                   )
               }
            },
                title = {
                Text(text = (stringResource(id = R.string.tentang_dev)))
            },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    ) { padding ->

        Column (
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(painter = painterResource(
                id = R.drawable.foto_biodata),
                contentDescription = stringResource(id = R.string.foto),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding)
                    .padding(16.dp)

            )
            Text(
                text = stringResource(id = R.string.biodata),
                modifier = Modifier
                    .padding(padding)
                    .padding(15.dp)
            )


        }

    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun AboutScreenPreview() {
    Mobpro1AssesmentTheme {
        AboutScreen(rememberNavController())
    }
}