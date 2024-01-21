package com.example.cashvault.presentation.components


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cashvault.ui.theme.white

@Composable
fun TransactionButton(
    text: String,
    icon: ImageVector,
    backgroundColor: Color,
    contentColor: Color,
    onButtonClick: () -> Unit,
    modifier: Modifier
) {

    Button(
        modifier = modifier,
        onClick = { onButtonClick },
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        shape = RoundedCornerShape(10.dp)
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.width(4.dp))



  Text(text = text,
      color = white)
    }



}

@Preview(showBackground = false)
@Composable
fun TransactionButtonPreview(){
    TransactionButton(
        text = "Deposit",
        icon = Icons.Default.KeyboardArrowUp,
        backgroundColor = Color.White,
        contentColor = Color.Black,
        onButtonClick = { /*TODO*/ },
        modifier = Modifier
    )
}
