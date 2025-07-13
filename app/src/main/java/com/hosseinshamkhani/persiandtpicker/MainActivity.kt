package com.hosseinshamkhani.persiandtpicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.hosseinshamkhani.persiandtpickercompose.picker.JalaliDatePicker
import com.hosseinshamkhani.persiandtpickercompose.picker.TimePicker
import com.hosseinshamkhani.persiandtpicker.ui.theme.JalaliDateTimePickerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var selectedDate by remember { mutableStateOf("") }
            var selectedTime by remember { mutableStateOf("") }

            JalaliDateTimePickerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize() ,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
                    ) {
                        JalaliDatePicker(
                            onDateSelected = { jYear: Int, jMonth: Int, jDay: Int ->
                                selectedDate = "Current date is: $jYear : $jMonth : $jDay"
                            },
                            textColor = MaterialTheme.colorScheme.onBackground,
                            selectedTextColor = MaterialTheme.colorScheme.background,
                            backGroundColor = MaterialTheme.colorScheme.background,
                            selectedItemBackgroundColor = MaterialTheme.colorScheme.onBackground,
                        )

                        TimePicker(
                            onTimeChanged = { hour: Int, minutes: Int, amPm: Int? ->
                                selectedTime = "$hour:$minutes $amPm"
                            },
                            textColor = MaterialTheme.colorScheme.onBackground,
                            selectedTextColor = MaterialTheme.colorScheme.background,
                            backGroundColor = MaterialTheme.colorScheme.background,
                            selectedItemBackgroundColor = MaterialTheme.colorScheme.onBackground,
                        )

                        Text(
                            modifier = Modifier
                                .clip(MaterialTheme.shapes.large)
                                .background(MaterialTheme.colorScheme.surfaceContainer)
                                .padding(16.dp),
                            text = "$selectedDate  $selectedTime"
                        )
                    }
                }
            }
        }
    }
}

