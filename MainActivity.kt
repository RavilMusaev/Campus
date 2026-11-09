
package kg.iuca.campuscard

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                CampusCardScreen()
            }
        }
    }
}

@Composable
fun CampusCardScreen() {

    // Переключение расположения кнопок
    var useSpaceBetween by remember {
        mutableStateOf(true)
    }

    // Переключение вертикального выравнивания
    var alignTimeTop by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        // Эксперимент 6: распределение свободного места
        verticalArrangement = Arrangement.SpaceBetween,

        horizontalAlignment = Alignment.Start
    ) {

        // Верхняя часть экрана
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            // Заголовок с аватаром
            ProfileHeader(
                name = "Ravil Musaev",
                status = "In class · Building B"
            )

            // Exercise 1: блок с текстом по центру
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Campus Card",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Ravil Musaev",
                    fontSize = 18.sp
                )

                Text(
                    text = "Student ID: 2026001",
                    color = Color.Gray
                )
            }

            // Заголовок расписания
            Text(
                text = "Today",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            // Список занятий
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                ScheduleRow(
                    time = "09:00",
                    title = "CS101 Introduction to Computer Science and Programming",
                    room = "Lab 3",
                    alignTop = alignTimeTop
                )

                ScheduleRow(
                    time = "11:00",
                    title = "MATH210 Mathematics",
                    room = "A-204"
                )

                ScheduleRow(
                    time = "14:00",
                    title = "Soft Skills",
                    room = "Hall 1"
                )
            }
        }

        // Нижняя панель с кнопками
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),

                // Exercise 2: два варианта расположения
                horizontalArrangement =
                    if (useSpaceBetween) {
                        Arrangement.SpaceBetween
                    } else {
                        Arrangement.spacedBy(
                            16.dp,
                            Alignment.CenterHorizontally
                        )
                    },

                verticalAlignment = Alignment.CenterVertically
            ) {

                Button(
                    onClick = {
                        Toast.makeText(
                            context,
                            "Campus Map",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                ) {
                    Text("Map")
                }

                Button(
                    onClick = {
                        Toast.makeText(
                            context,
                            "Your QR Code",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                ) {
                    Text("Show QR")
                }
            }

            // Переключатель Arrangement
            TextButton(
                onClick = {
                    useSpaceBetween = !useSpaceBetween
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Switch button arrangement")
            }

            // Переключатель вертикального выравнивания
            TextButton(
                onClick = {
                    alignTimeTop = !alignTimeTop
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Switch time alignment: Top / Center")
            }
        }
    }
}

// Exercise 5: отдельная функция заголовка
@Composable
fun ProfileHeader(
    name: String,
    status: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Квадратный аватар
        Box(
            modifier = Modifier
                .size(56.dp)
                .background(
                    MaterialTheme.colorScheme.primaryContainer
                )
        )

        // Информация о студенте
        Column {
            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = status,
                color = Color.Gray
            )
        }
    }
}

// Exercise 4 и 5: отдельная функция строки расписания
@Composable
fun ScheduleRow(
    time: String,
    title: String,
    room: String,
    alignTop: Boolean = false
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),

        // Exercise 3: Top или CenterVertically
        verticalAlignment =
            if (alignTop) {
                Alignment.Top
            } else {
                Alignment.CenterVertically
            }
    ) {

        // Время слева
        Text(
            text = time,
            modifier = Modifier.width(56.dp),
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )

        // Название курса занимает свободное место
        Text(
            text = title,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        // Аудитория справа
        Text(
            text = room,
            modifier = Modifier.width(72.dp),
            fontSize = 13.sp,
            color = Color.Gray
        )
    }
}
